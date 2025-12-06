package com.mycompany.escuelademanejo_escritorio;

import java.sql.*;

public class ConexionBD {

    private static ConexionBD instancia;  // Singleton

    private Connection conexion;
    private Statement stm;
    private ResultSet rs;

    // Constructor privado
    private ConexionBD() {
        try {
            // Cargar driver de PostgreSQL
            Class.forName("org.postgresql.Driver");

            // Datos de conexión
            String URL = "jdbc:postgresql://localhost:5432/db_escuela_manejo";
            String usuario = "postgres";
            String contrasena = "1234";

            // Abrir conexión
            conexion = DriverManager.getConnection(URL, usuario, contrasena);

            System.out.println("Conexión exitosa a PostgreSQL.");

        } catch (ClassNotFoundException e) {
            System.err.println("Error: Driver de PostgreSQL no encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error al conectar a PostgreSQL.");
            e.printStackTrace();
        }
    }

    // ============================
    // Patrón Singleton
    // ============================
    public static ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    // ============================
    // Ejecución de consultas LMD
    // (INSERT, UPDATE, DELETE)
    // ============================
    public boolean ejecutarInstruccionLMD(String sql) {
        boolean res = false;
        try {
            stm = conexion.createStatement();
            res = stm.executeUpdate(sql) > 0;

        } catch (SQLException e) {
            System.err.println("Error ejecutando instrucción LMD.");
            e.printStackTrace();
        }
        return res;
    }

    // ============================
    // Consultas de selección
    // (SELECT)
    // ============================
    public ResultSet ejecutarIstruccionSQL(String sql) {
        rs = null;
        try {
            stm = conexion.createStatement();
            rs = stm.executeQuery(sql);

        } catch (SQLException e) {
            System.err.println("Error ejecutando instrucción SQL.");
            e.printStackTrace();
        }
        return rs;
    }

    // ============================
    // Obtener la conexión
    // ============================
    public Connection getConexion() {
        return conexion;
    }


    // ============================
    // Inicio de sesión opcional
    // ============================
    public boolean loginAttempt(String user, String password) {
        String URL = "jdbc:postgresql://localhost:5432/db_escuela_manejo";

        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            return true; // Conexión válida
        } catch (SQLException e) {
            return false; // Credenciales incorrectas
        }
    }
    
    public ResultSet ejecutarConsultaPreparada(String sql, Object... parametros) {

    try {
        PreparedStatement ps = conexion.prepareStatement(sql);

        for (int i = 0; i < parametros.length; i++) {
            ps.setObject(i + 1, parametros[i]);
        }

        return ps.executeQuery();

    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}
}
