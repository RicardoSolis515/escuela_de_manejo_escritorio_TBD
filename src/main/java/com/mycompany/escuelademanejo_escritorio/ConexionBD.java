package com.mycompany.escuelademanejo_escritorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    public ConexionBD() {

        String url = "jdbc:postgresql://localhost:5432/dreamhome";
        String usuario = "postgres";
        String contraseña = "1234";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {

            if (conexion.isValid(2)) {
                System.out.println("Conexión exitosa a la base de datos.");
            }

        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
