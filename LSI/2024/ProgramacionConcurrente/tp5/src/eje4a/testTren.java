/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje4a;

/**
 *
 * @author Usuario
 */
public class testTren {
    public static void main(String[] args) {
        int cantPasajeros = 25;  // 10 pasajeros
        int maxEspacios = 5;     // El tren tiene espacio para 3 pasajeros
        Tren tren = new Tren(maxEspacios, cantPasajeros);

        Vendedor vendedor = new Vendedor("Vendedor", tren);
        vendedor.start();

        Pasajero[] pasajeros = new Pasajero[cantPasajeros];
        for (int i = 0; i < cantPasajeros; i++) {
            pasajeros[i] = new Pasajero("Pasajero " + (i + 1), tren);
            pasajeros[i].start();
        }

        ControlTren control = new ControlTren("Control Tren", tren);
        control.start();
    }
}
