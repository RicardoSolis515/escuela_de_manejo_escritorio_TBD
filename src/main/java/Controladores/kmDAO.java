/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import com.mycompany.escuelademanejo_escritorio.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
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

    
}
