/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Usuario
 */
public class Instructor_Auto {
    
    private String nss;
    private String nombre;
    private String apellidopaterno;
    private String apellidomaterno;
    private boolean senior;

    private String auto_matricula;
    private String marca;
    private String modelo;
    private String kilometraje;
    private boolean asignado;

    public Instructor_Auto(String nss, String nombre, String apellidopaterno, String apellidomaterno,
                               boolean senior, String auto_matricula, String marca, String modelo,
                               String kilometraje, boolean asignado) {
        this.nss = nss;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.senior = senior;
        this.auto_matricula = auto_matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.kilometraje = kilometraje;
        this.asignado = asignado;
    }

    // Getters
    public String getNss() { return nss; }
    public String getNombre() { return nombre; }
    public String getApellidopaterno() { return apellidopaterno; }
    public String getApellidomaterno() { return apellidomaterno; }
    public boolean isSenior() { return senior; }
    public String getAuto_matricula() { return auto_matricula; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getKilometraje() { return kilometraje; }
    public boolean isAsignado() { return asignado; }
}
