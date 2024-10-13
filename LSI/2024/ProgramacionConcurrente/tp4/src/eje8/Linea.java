/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje8;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Linea implements Runnable{
   private ControladorProduccion controladorProduccion;
   public Linea(ControladorProduccion controlador)
   {
       this.controladorProduccion=controlador;
   }
   @Override
   public void run()
   {
       while(true)
       {
           try {
                   controladorProduccion.cambiarLineas();
               Thread.sleep(3000);
               System.out.println("Cambiando lineas");
           
           } catch (InterruptedException ex) {
               Logger.getLogger(Linea.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
   }
}
