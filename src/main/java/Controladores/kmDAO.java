/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.RegistroKilometraje;
import com.mycompany.escuelademanejo_escritorio.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class kmDAO {
    
    ConexionBD conexionBD = ConexionBD.getInstancia();
    
    
    
    public Map<String, Integer> obtenerKilometrosPorInstructor() {
    Map<String, Integer> datos = new HashMap<>();

    String sql = """
        SELECT 
            i.nss,
            CONCAT(i.nombre, ' ', i.apellidopaterno) AS instructor,
            SUM(r.kilometros_agregados) AS total_km
        FROM registro_kilometraje r
        LEFT JOIN instructor i ON i.nss = r.nss_instructor
        GROUP BY i.nss, instructor
        ORDER BY total_km DESC
    """;

    try (PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            String nombreInstructor = rs.getString("instructor");
            int km = rs.getInt("total_km");
            datos.put(nombreInstructor, km);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return datos;
}
    
    public List<RegistroKilometraje> obtenerHistorialPorMatricula(String filtroMatricula) {
    List<RegistroKilometraje> lista = new ArrayList<>();

    String sql = """
        SELECT * FROM registro_kilometraje
        WHERE matricula ILIKE ?
        ORDER BY fecha_registro DESC
    """;

    try (PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql)) {

        ps.setString(1, "%" + filtroMatricula + "%");

        try (ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                RegistroKilometraje registro = new RegistroKilometraje(
                    rs.getInt("id"),
                    rs.getString("matricula"),
                    rs.getString("nss_instructor"),
                    rs.getInt("kilometros_agregados"),
                    rs.getTimestamp("fecha_registro")
                );

                lista.add(registro);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}

    public boolean corregirRegistroKilometraje(int idRegistro) {

    String sql = "CALL corregir_registro_kilometraje(?);";

    try (PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql)) {

        ps.setInt(1, idRegistro);
        ps.execute();
        return true; // éxito

    } catch (SQLException e) {
        e.printStackTrace();
        return false; // error
    }
}


    
}
