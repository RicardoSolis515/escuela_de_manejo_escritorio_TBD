/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Instructor;
import com.mycompany.escuelademanejo_escritorio.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */

public class InstructorDAO {

    ConexionBD conexionBD = ConexionBD.getInstancia();

    // ===================== ALTAS =====================
    public boolean agregarInstructor(Instructor instructor) {
        String sql = "INSERT INTO instructor (nss, nombre, apellidopaterno, apellidomaterno, senior, matriculavehiculo) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql);
            ps.setString(1, instructor.getNSS());
            ps.setString(2, instructor.getNombre());
            ps.setString(3, instructor.getApellidoPat());
            ps.setString(4, instructor.getApellidoMat());
            ps.setBoolean(5, instructor.isSenior());

            if (instructor.getMatriculaVehiculo() != null && !instructor.getMatriculaVehiculo().isEmpty()) {
                ps.setString(6, instructor.getMatriculaVehiculo());
            } else {
                ps.setNull(6, java.sql.Types.VARCHAR);
            }

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ===================== BAJAS =====================
    public boolean eliminarInstructor(String nss) {
        String sql = "DELETE FROM instructor WHERE nss = ?";

        try {
            PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql);
            ps.setString(1, nss);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ===================== CAMBIOS =====================
    public boolean editarInstructor(Instructor instructor) {
        String sql = "UPDATE instructor SET nombre = ?, apellidopaterno = ?, apellidomaterno = ?, "
                   + "senior = ?, matriculavehiculo = ? WHERE nss = ?";

        try {
            PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql);

            ps.setString(1, instructor.getNombre());
            ps.setString(2, instructor.getApellidoPat());
            ps.setString(3, instructor.getApellidoMat());
            ps.setBoolean(4, instructor.isSenior());

            if (instructor.getMatriculaVehiculo() != null && !instructor.getMatriculaVehiculo().isEmpty()) {
                ps.setString(5, instructor.getMatriculaVehiculo());
            } else {
                ps.setNull(5, java.sql.Types.VARCHAR);
            }

            ps.setString(6, instructor.getNSS());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ===================== CONSULTA INDIVIDUAL =====================
    public Instructor mostrarInstructor(String nss) {
        String sql = "SELECT * FROM instructor WHERE nss = ?";
        Instructor i = null;

        try {
            PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql);
            ps.setString(1, nss);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                i = new Instructor(
                        rs.getString("nss"),
                        rs.getString("nombre"),
                        rs.getString("apellidopaterno"),
                        rs.getString("apellidomaterno"),
                        rs.getBoolean("senior"),
                        rs.getString("matriculavehiculo")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return i;
    }

    // ===================== LISTA COMPLETA =====================
    public ArrayList<Instructor> mostrarInstructores() {

        ArrayList<Instructor> lista = new ArrayList<>();
        String sql = "SELECT * FROM instructor";

        ResultSet rs = conexionBD.ejecutarIstruccionSQL(sql);

        try {
            while (rs.next()) {
                Instructor i = new Instructor(
                        rs.getString("nss"),
                        rs.getString("nombre"),
                        rs.getString("apellidopaterno"),
                        rs.getString("apellidomaterno"),
                        rs.getBoolean("senior"),
                        rs.getString("matriculavehiculo")
                );
                lista.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    public ArrayList<Instructor> mostrarInstructoresFiltro(String filtro) {

    ArrayList<Instructor> lista = new ArrayList<>();
    String sql = "SELECT * FROM instructor WHERE nss LIKE ?";

    try (PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql)) {

        ps.setString(1, filtro + "%"); // agrega el comodín correctamente

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Instructor i = new Instructor(
                rs.getString("nss"),
                rs.getString("nombre"),
                rs.getString("apellidopaterno"),
                rs.getString("apellidomaterno"),
                rs.getBoolean("senior"),
                rs.getString("matriculavehiculo")
            );
            lista.add(i);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}

    
}
