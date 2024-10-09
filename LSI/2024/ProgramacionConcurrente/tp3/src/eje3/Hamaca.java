/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Hamaca {

    public synchronized void descansar(String nameHamster) {

        try {
            System.out.println("El " + Thread.currentThread().getName()+ " esta descansando");
            Thread.sleep(600);
            System.out.println("El "+nameHamster+" deja de descansar");
        } catch (InterruptedException ex) {

            System.out.println("El " + nameHamster + " no pudo descansar en la hamaca");
            Logger.getLogger(ThreadHamster.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
