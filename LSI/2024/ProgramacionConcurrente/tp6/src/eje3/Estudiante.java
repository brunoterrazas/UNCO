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
 * @author Brunot
 */
public class Estudiante extends Thread {
    private Sala sala;
 public Estudiante(String nom, Sala sala)
 {
   super(nom);
   this.sala=sala;
 }
  @Override
  public void run()
  { 
        try {
            sala.tomarMesa(this.getName());
            //simular un tiempo
            Thread.sleep(2000);
            sala.dejarMesa(this.getName());
        } catch (InterruptedException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
}
