/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BarberoDormilonRunnable;

import BarberoDormilonThread.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Barbero extends Persona implements Runnable  {
     private Barberia barberia;
     
    public Barbero(String nombre, Barberia barberia)
    {
      super(nombre);
      this.barberia=barberia;
    }
    public void atender(){
        System.out.println("Estoy atendiendo");
         try {
             Thread.sleep((int)Math.random()*200);
         } catch (InterruptedException ex) {
             Logger.getLogger(Barbero.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Me interrumpieron mi trabajo");
         }
    }
     @Override
    public void run(){
    int cuantos=0;
         System.out.println("Soy el barbero "+this.miNombre);
      while(true)
      {
       this.barberia.esperarCliente(this.miNombre);
       this.atender();
       this.barberia.terminarAtencion();
       cuantos++;
          System.out.println("Cuantos atendi "+cuantos+ " *************");
      }
    }
}
