/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejeHamsters;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Plato {
   private int cantidad;
   private int comiendo;
   public Plato(int maximo)
   {
     this.cantidad=maximo;
     this.comiendo=0;
   }
   public synchronized void empezarAComer(String nombre)
   {
       try {
           while(comiendo>=3)
           {
           this.wait();
           }
       } catch (InterruptedException ex) {
           Logger.getLogger(Plato.class.getName()).log(Level.SEVERE, null, ex);
       }
       System.out.println(nombre+" empieza a comer");
       comiendo++;   
   }
   public synchronized void terminarDeComer(String nombre)
   {
       System.out.println(nombre+" termino de comer");
       comiendo--;
       this.notify();
   }
}
