/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

/**
 *
 * @author Usuario
 */

import Modelos.Historial;
import com.mycompany.escuelademanejo_escritorio.ConexionBD;
import java.sql.*;
import java.util.ArrayList;

public class HistorialDAO {
    private final ConexionBD conexionBD = ConexionBD.getInstancia();

    public ArrayList<Historial> obtenerHistorialCompleto() {
        ArrayList<Historial> lista = new ArrayList<>();
        String sql = "SELECT * FROM vista_historial_completo_instructor ORDER BY fecha_cambio DESC";

        try (PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Historial(
                    rs.getInt("id"),
                    rs.getString("fecha_cambio"),
                    rs.getString("nss"),
                    rs.getString("nombre"),
                    rs.getString("apellidopaterno"),
                    rs.getString("apellidomaterno"),
                    rs.getString("vehiculo_anterior"),
                    rs.getString("marca_anterior"),
                    rs.getString("modelo_anterior"),
                    rs.getString("vehiculo_nuevo"),
                    rs.getString("marca_nueva"),
                    rs.getString("modelo_nuevo")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
