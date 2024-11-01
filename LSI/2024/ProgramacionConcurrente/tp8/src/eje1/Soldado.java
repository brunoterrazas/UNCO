/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class Soldado  extends Thread{
    private ComedorCuartel comedorCuartel;
     public Soldado(String nombre,ComedorCuartel comedor)
     {
       super(nombre);
       comedorCuartel=comedor;
     }
    @Override
     public void run()
     {
        try {
            comedorCuartel.almorzar(getName());
            Thread.sleep(2000);
            comedorCuartel.dejarBandeja(getName());
        } catch (InterruptedException ex) {
            Logger.getLogger(Soldado.class.getName()).log(Level.SEVERE, null, ex);
        }
              
     }
}
