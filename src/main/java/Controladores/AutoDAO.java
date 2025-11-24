/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

/**
 *
 * @author Usuario
 */



import Modelos.Auto;
import com.mycompany.escuelademanejo_escritorio.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AutoDAO {

    ConexionBD conexionBD = ConexionBD.getInstancia();

    // ===================== ALTAS =====================
    public boolean agregarAuto(Auto auto) {
        String sql = "INSERT INTO auto (matricula, asignado, marca, modelo, kilometraje) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql);

            ps.setString(1, auto.getMatricula());
            ps.setBoolean(2, auto.isAsignado());
            ps.setString(3, auto.getMarca());
            ps.setString(4, auto.getModelo());
            ps.setString(5, auto.getKilometraje());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ===================== BAJAS =====================
    public boolean eliminarAuto(String matricula) {
        String sql = "DELETE FROM auto WHERE matricula = ?";

        try {
            PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql);
            ps.setString(1, matricula);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            // En caso de FK (instructor → auto), debe mostrar error controlado
            e.printStackTrace();
            return false;
        }
    }

    // ===================== CAMBIOS =====================
    public boolean editarAuto(Auto auto) {
        String sql = "UPDATE auto SET asignado = ?, marca = ?, modelo = ?, kilometraje = ? "
                + "WHERE matricula = ?";

        try {
            PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql);

            ps.setBoolean(1, auto.isAsignado());
            ps.setString(2, auto.getMarca());
            ps.setString(3, auto.getModelo());
            ps.setString(4, auto.getKilometraje());
            ps.setString(5, auto.getMatricula());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ===================== CONSULTA INDIVIDUAL =====================
    public Auto mostrarAuto(String matricula) {
        String sql = "SELECT * FROM auto WHERE matricula = ?";
        Auto auto = null;

        try {
            PreparedStatement ps = conexionBD.getConexion().prepareStatement(sql);
            ps.setString(1, matricula);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                auto = new Auto(
                        rs.getString("matricula"),
                        rs.getBoolean("asignado"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("kilometraje")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return auto;
    }

    // ===================== LISTA DE AUTOS =====================
    public ArrayList<Auto> mostrarAutos() {
        ArrayList<Auto> lista = new ArrayList<>();
        String sql = "SELECT * FROM auto";

        ResultSet rs = conexionBD.ejecutarIstruccionSQL(sql);

        try {
            while (rs.next()) {
                Auto auto = new Auto(
                        rs.getString("matricula"),
                        rs.getBoolean("asignado"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("kilometraje")
                );

                lista.add(auto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    
    public ArrayList<Auto> mostrarAutosNoAsignados(boolean asignados) {
        ArrayList<Auto> lista = new ArrayList<>();
        String sql = "SELECT * FROM auto WHERE asignado = " + asignados;

        ResultSet rs = conexionBD.ejecutarIstruccionSQL(sql);

        try {
            while (rs.next()) {
                Auto auto = new Auto(
                        rs.getString("matricula"),
                        rs.getBoolean("asignado"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("kilometraje")
                );

                lista.add(auto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
