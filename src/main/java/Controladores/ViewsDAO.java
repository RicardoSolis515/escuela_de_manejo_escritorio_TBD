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
import Modelos.Instructor_Auto;
import com.mycompany.escuelademanejo_escritorio.ConexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewsDAO {

    ConexionBD conexionBD = ConexionBD.getInstancia();

    // ===================== LISTA: vista_instructor_auto =====================
    public ArrayList<Instructor_Auto> obtenerVistaInstructorAuto() {

        ArrayList<Instructor_Auto> lista = new ArrayList<>();
        String sql = "SELECT * FROM vista_instructor_auto";

        ResultSet rs = conexionBD.ejecutarIstruccionSQL(sql);

        try {
            while (rs.next()) {
                Instructor_Auto v = new Instructor_Auto(
                        rs.getString("nss"),
                        rs.getString("nombre"),
                        rs.getString("apellidopaterno"),
                        rs.getString("apellidomaterno"),
                        rs.getBoolean("senior"),
                        rs.getString("auto_matricula"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("kilometraje"),
                        rs.getBoolean("asignado")
                );
                lista.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    public ArrayList<Instructor_Auto> obtenerVistaInstructorAutoFiltro(String tipo, String filtro) {

    ArrayList<Instructor_Auto> lista = new ArrayList<>();


    String sql = "SELECT * FROM vista_instructor_auto WHERE " + tipo + " ILIKE ?";

    ResultSet rs = conexionBD.ejecutarConsultaPreparada(sql, "%" + filtro + "%");

    try {
        while (rs != null && rs.next()) {
            Instructor_Auto v = new Instructor_Auto(
                    rs.getString("nss"),
                    rs.getString("nombre"),
                    rs.getString("apellidopaterno"),
                    rs.getString("apellidomaterno"),
                    rs.getBoolean("senior"),
                    rs.getString("auto_matricula"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getString("kilometraje"),
                    rs.getBoolean("asignado")
            );
            lista.add(v);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}



    // ===================== LISTA: vista_historial_completo_instructor =====================
    public ArrayList<Historial> obtenerVistaHistorialCompleto() {

        ArrayList<Historial> lista = new ArrayList<>();
        String sql = "SELECT * FROM vista_historial_completo_instructor";

        ResultSet rs = conexionBD.ejecutarIstruccionSQL(sql);

        try {
            while (rs.next()) {
                Historial v = new Historial(
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
                        rs.getString("modelo_nueva")
                );
                lista.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}


