package Controladores;

import Modelos.Instructor;
import com.mycompany.escuelademanejo_escritorio.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DAO exclusivo para funciones almacenadas PostgreSQL
 */
public class FunctionsDAO {

    private final ConexionBD conexionBD = ConexionBD.getInstancia();


    // =========================================================
    // ✔ 1) cantidad_vehiculos_disponibles() → INT
    // =========================================================
    public Integer cantidadVehiculosDisponibles() {

        String sql = "SELECT cantidad_vehiculos_disponibles() AS total";

        try (PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("total");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }



    // =========================================================
    // ✔ 2) nombre_instructor_asignado(matricula) → tabla
    //    (name, apellidopaterno, apellidomaterno)
    // =========================================================
    public Instructor instructorAsignadoPorMatricula(String matricula) {

    String sql = "SELECT * FROM nombre_instructor_asignado(?)";

    try {
        PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql);
        ps.setString(1, matricula);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Instructor inst = new Instructor(
                    null,
                rs.getString("name"),
                rs.getString("apellidopaterno"),
                rs.getString("apellidomaterno"),
                    false,
                    matricula
            );
            return inst;
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null; // no encontró instructor
}


}
