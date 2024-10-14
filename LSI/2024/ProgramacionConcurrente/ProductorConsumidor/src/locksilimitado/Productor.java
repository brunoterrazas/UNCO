/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locksilimitado;

import lockslimitado.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Productor
        implements Runnable {

    private Buffer buffer;
    private int ide;

    public Productor(Buffer b, int id) {
        this.buffer = b;
        this.ide = id;
    }

    public void run() {
        while (true) {
            try {
              
                  Thread.sleep((300));

               buffer.agregar(ide);

            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }

       //     System.out.println("El hilo termino de ejecutar el hilo:" + nom);
        }
    }
}
