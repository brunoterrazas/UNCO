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
public class Rueda {
   
    public synchronized void correr(String nameHamster){
    
          try {
             
               System.out.println("El "+nameHamster+" esta corriendo");
              Thread.sleep(600);
            System.out.println("El "+nameHamster+" deja de correr");
          } catch (InterruptedException ex) {
                System.out.println("El "+nameHamster+" no pudo correr en la rueda");
          
              Logger.getLogger(Rueda.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
     
     
    
}
