/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje4;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Consumidor implements Runnable {

    private Buffer buffer;
    private String nombre;

    public Consumidor(Buffer b, String nom) {
        this.buffer = b;
        this.nombre = nom;
    }

    public void run() {
        while (true) {
            try {
                Random val = new Random();

               // int num = val.nextInt(20);

              //  int aleatorio = num * 1000;
                
                Thread.sleep((300));

                System.out.println(nombre+" esperando para sacar un item");
                buffer.sacar(nombre);

            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        }

    }
}
