/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje5v1;


/**
 *
 * @author Brunot
 */
public class testTren {
       public static void main(String[] args) {
        int cantPasajeros = 8;
        int capacidadTren = 3;  // Capacidad del tren
        Tren tren = new Tren(capacidadTren);

        Vendedor vendedor = new Vendedor("Vendedor", tren);
        vendedor.start();  // Comienza a vender tickets

        ControlTren control = new ControlTren("Control Tren", tren);
        control.start();  // Controla cuándo puede partir el tren
        Pasajero[] pasajeros = new Pasajero[cantPasajeros];
        for (int i = 0; i < cantPasajeros; i++) {
            pasajeros[i] = new Pasajero("Pasajero " + (i + 1), tren);
            pasajeros[i].start();  // Cada pasajero intenta comprar un ticket y subirse al tren
        }
       
    }
}
