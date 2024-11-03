/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje1;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class ComedorCuartel {

   private Semaphore semMostradorAlmuerzo;
   private Semaphore semMostradorPostre;
   private Semaphore semAbridores;
   public ComedorCuartel()
   {
      semMostradorAlmuerzo=new Semaphore(5,true);
      semMostradorPostre=new Semaphore(3,true);      
      semAbridores=new Semaphore(10,true);
   }
   public void almorzar(String nombre)
   {
       try {
           int opcion=valorRandom(1,2);
           
                   semMostradorAlmuerzo.acquire();
           switch(opcion)
           {
               case 1: //comer y tomar agua
                   System.out.println(nombre+" toma una bandeja y pide comida con una botella de agua");
                   break;
               case 2: //comer y tomar una gaseosa
                   System.out.println(nombre+" toma una bandeja y pide comida con una botella de gaseosa");
                   System.out.println(nombre+" pide un abridor");
                   
                   semAbridores.acquire();
                   System.out.println(nombre+" usa el abridor para abrir la botella de gaseosa");
                   Thread.sleep(1000);
                   semAbridores.release();
                   break;
           }
           //comer postre
           boolean comePostre=valorRandom(1,2)==2;
           if(comePostre)
           {
               try {
                   System.out.println(nombre+" va a pedir su postre");
                   semMostradorPostre.acquire();
                   System.out.println(nombre+" come su postre");
                   Thread.sleep(600);
                   semMostradorPostre.release();
               } catch (InterruptedException ex) {
                   Logger.getLogger(ComedorCuartel.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
          
       } catch (InterruptedException ex) {
           Logger.getLogger(ComedorCuartel.class.getName()).log(Level.SEVERE, null, ex);
       }
     
       
      
   }
   public void dejarBandeja(String nombre)
   {   
       semMostradorAlmuerzo.release();
       System.out.println(nombre+" deja su bandeja en la cocina y se va.");
   }
   
   public  int valorRandom(int min, int max) {
        int randomNum = (int) (Math.random() * (max - min + 1)) + min;
        return randomNum;
    }
   
   
    
}
