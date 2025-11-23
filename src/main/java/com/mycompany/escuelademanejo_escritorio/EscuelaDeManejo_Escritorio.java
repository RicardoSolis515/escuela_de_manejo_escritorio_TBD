/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.escuelademanejo_escritorio;

/**
 *
 * @author Usuario
 * 
 */

public class EscuelaDeManejo_Escritorio {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                new VentanaLogin();
            }
        }).start();
    }
}
