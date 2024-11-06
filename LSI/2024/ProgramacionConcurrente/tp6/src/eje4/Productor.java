/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje4;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Productor
        implements Runnable {

    private Buffer buffer;
    private String nombre;

    public Productor(Buffer b, String nom) {
        this.buffer = b;
        this.nombre = nom;
    }

    public void run() {
        while (true) {
            try {
              
                  Thread.sleep((300));
                System.out.println(nombre+" esperando para agregar un item");
               buffer.agregar(new Object(),nombre);

            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }

       //     System.out.println("El hilo termino de ejecutar el hilo:" + nom);
        }
    }
}
