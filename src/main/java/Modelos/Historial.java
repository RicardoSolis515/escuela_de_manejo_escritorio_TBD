/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Usuario
 */
public class Historial {
    
    private int id;
    private String fecha_cambio;
    private String nss;
    private String nombre;
    private String apellidopaterno;
    private String apellidomaterno;

    private String vehiculo_anterior;
    private String marca_anterior;
    private String modelo_anterior;

    private String vehiculo_nuevo;
    private String marca_nueva;
    private String modelo_nueva;

    public Historial(int id, String fecha_cambio, String nss, String nombre,
                                    String apellidopaterno, String apellidomaterno,
                                    String vehiculo_anterior, String marca_anterior, String modelo_anterior,
                                    String vehiculo_nuevo, String marca_nueva, String modelo_nueva) {
        this.id = id;
        this.fecha_cambio = fecha_cambio;
        this.nss = nss;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.vehiculo_anterior = vehiculo_anterior;
        this.marca_anterior = marca_anterior;
        this.modelo_anterior = modelo_anterior;
        this.vehiculo_nuevo = vehiculo_nuevo;
        this.marca_nueva = marca_nueva;
        this.modelo_nueva = modelo_nueva;
    }

    // Getters
    public int getId() { return id; }
    public String getFecha_cambio() { return fecha_cambio; }
    public String getNss() { return nss; }
    public String getNombre() { return nombre; }
    public String getApellidopaterno() { return apellidopaterno; }
    public String getApellidomaterno() { return apellidomaterno; }
    public String getVehiculo_anterior() { return vehiculo_anterior; }
    public String getMarca_anterior() { return marca_anterior; }
    public String getModelo_anterior() { return modelo_anterior; }
    public String getVehiculo_nuevo() { return vehiculo_nuevo; }
    public String getMarca_nueva() { return marca_nueva; }
    public String getModelo_nueva() { return modelo_nueva; }
}
