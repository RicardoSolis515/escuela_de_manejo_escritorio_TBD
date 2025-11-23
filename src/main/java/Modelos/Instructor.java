/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Usuario
 */
public class Instructor {
    private String NSS;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private boolean senior;
    private String matriculaVehiculo;
    
    public Instructor(){}
    
    // Constructor
    public Instructor(String NSS, String nombre, String apellidoPat, String apellidoMat, boolean senior, String matriculaVehiculo) {
        this.NSS = NSS;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPat;
        this.apellidoMaterno = apellidoMat;
        this.senior = senior;
        this.matriculaVehiculo = matriculaVehiculo;
    }

    // Getters y Setters
    public String getNSS(){
        return NSS;
    }
    
    public void setNSS(String NSS){
        this.NSS = NSS;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPat() {
        return apellidoPaterno;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPaterno = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMaterno;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMaterno = apellidoMat;
    }

    public boolean isSenior() {
        return senior;
    }

    public void setSenior(boolean senior) {
        this.senior = senior;
    }

    public String getMatriculaVehiculo() {
        return matriculaVehiculo;
    }

    public void setMatriculaVehiculo(String matriculaVehiculo) {
        this.matriculaVehiculo = matriculaVehiculo;
    }
}
