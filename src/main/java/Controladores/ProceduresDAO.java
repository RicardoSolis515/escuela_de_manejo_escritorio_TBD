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
import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 * DAO para manejar llamadas a PROCEDIMIENTOS almacenados
 */
public class ProceduresDAO {

    ConexionBD conexionBD = ConexionBD.getInstancia();

    // ===================== LLAMAR PROCEDIMIENTO SIN RETORNO =====================
    public boolean ejecutarProcedure(String nombreProcedure, Object... params) {
        StringBuilder sql = new StringBuilder("CALL ");
        sql.append(nombreProcedure).append("(");

        // Generar ?, ?, ?, ? dinámicamente
        for (int i = 0; i < params.length; i++) {
            sql.append("?");
            if (i < params.length - 1) sql.append(",");
        }
        sql.append(")");

        try {
            CallableStatement cs = conexionBD.getConexion().prepareCall(sql.toString());

            // Asignar parámetros
            for (int i = 0; i < params.length; i++) {
                cs.setObject(i + 1, params[i]);
            }

            cs.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
