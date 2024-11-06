/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class testTrenTuristico {
   public static void main(String[] args) {
        int cantPasajeros = 3;
        int maxEspacios = 3;
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
