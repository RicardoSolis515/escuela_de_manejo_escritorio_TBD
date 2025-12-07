/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Usuario
 */

import java.sql.Timestamp;


public class RegistroKilometraje {

    private int id;
    private String matricula;
    private String nssInstructor;
    private int kilometrosAgregados;
    private Timestamp fechaRegistro;

    // Constructor
    public RegistroKilometraje(int id, String matricula, String nssInstructor,
                               int kilometrosAgregados, Timestamp fechaRegistro) {
        this.id = id;
        this.matricula = matricula;
        this.nssInstructor = nssInstructor;
        this.kilometrosAgregados = kilometrosAgregados;
        this.fechaRegistro = fechaRegistro;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNssInstructor() {
        return nssInstructor;
    }

    public void setNssInstructor(String nssInstructor) {
        this.nssInstructor = nssInstructor;
    }

    public int getKilometrosAgregados() {
        return kilometrosAgregados;
    }

    public void setKilometrosAgregados(int kilometrosAgregados) {
        this.kilometrosAgregados = kilometrosAgregados;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}

