/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

/**
 *
 * @author Usuario
 */

import com.mycompany.escuelademanejo_escritorio.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DAO para manejar funciones almacenadas de PostgreSQL
 */
public class FunctionsDAO {

    ConexionBD conexionBD = ConexionBD.getInstancia();

    // ===================== FUNCIONES QUE REGRESAN UNA SOLA CANTIDAD =====================
    public Integer ejecutarFuncionEntero(String nombreFuncion) {
        String sql = "SELECT " + nombreFuncion + "() AS resultado";

        try {
            PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) return rs.getInt("resultado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // ===================== FUNCIONES CON PARÁMETROS Y QUE REGRESAN TABLAS =====================
    public ResultSet ejecutarFuncionTabla(String nombreFuncion, Object... params) {

        StringBuilder sql = new StringBuilder("SELECT * FROM ");
        sql.append(nombreFuncion).append("(");

        for (int i = 0; i < params.length; i++) {
            sql.append("?");
            if (i < params.length - 1) sql.append(",");
        }
        sql.append(")");

        try {
            PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql.toString());

            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }

            return ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
