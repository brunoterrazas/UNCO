/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje4a;

import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Usuario
 */
public class Pasajero extends Thread {
    private Tren tren;

    public Pasajero(String nombre, Tren tren) {
        super(nombre);
        this.tren = tren;
    }

    @Override
    public void run() {
       
            tren.comprarTicket(this.getName());
            tren.subir(this.getName());
      
       
    }
}
