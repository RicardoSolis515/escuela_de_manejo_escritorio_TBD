package Controladores;

import com.mycompany.escuelademanejo_escritorio.ConexionBD;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class ProceduresDAO {

    ConexionBD conexionBD = ConexionBD.getInstancia();

    // ============================================================
    //  PROCEDIMIENTO 1: registrar_incremento_kilometraje
    // ============================================================
    public boolean registrarIncrementoKilometraje(String matricula, int kmAgregados) {

        String sql = "CALL registrar_incremento_kilometraje(?, ?)";

        try {
            CallableStatement cs = conexionBD.getConexion().prepareCall(sql);
            cs.setString(1, matricula);
            cs.setInt(2, kmAgregados);

            cs.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    // ============================================================
    //  PROCEDIMIENTO 2: intercambiar_autos_instructores
    // ============================================================
    public boolean intercambiarAutos(String nss1, String nss2) {

        String sql = "CALL intercambiar_autos_instructores(?, ?)";

        try {
            CallableStatement cs = conexionBD.getConexion().prepareCall(sql);
            cs.setString(1, nss1);
            cs.setString(2, nss2);

            cs.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}

