/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class TestCorredor {
     public static void main (String[] args)
  {
     Corredor[] corredores={ 
     new Corredor("Ana"),
     new Corredor("Pedro"),
    new Corredor("Laura"),
    new Corredor("Laura")
    };
    //Crear hilos
     Thread[] hiloscorredores ={
    new Thread(corredores[0]),
    new Thread(corredores[1]),
    new Thread(corredores[2]),
    new Thread(corredores[3])};

      for(int i=0;i<hiloscorredores.length;i++)
      {               
             hiloscorredores[i].start();
      }
        for (int i = 1; i < hiloscorredores.length; i++) {
         try {
             hiloscorredores[i].join();
         } catch (InterruptedException ex) {
             Logger.getLogger(TestCorredor.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
      Corredor ganador=obtenerMayor(corredores);
      
      System.out.println("El corredor con mayor recorrido es:"+ganador.getNombre()+" y la distancia recorrida es "+ganador.getDistancia_recorrida());
  }  
      
      /*
        Al finalizar la carrera se desea saber qué corredor hizo la mayor distancia y cual fue
       esa distancia. 
        
        ¿Quién será el encargado de mostrar este mensaje?
      el main
      ¿Cómo hará para esperar que todo los corredores terminen la carrera?
      join()
      */
     public static Corredor obtenerMayor(Corredor[] listaCorredores){
       Corredor mayor=listaCorredores[0];
       
     for (int i = 1; i < listaCorredores.length; i++) {
            if (listaCorredores[i].getDistancia_recorrida() > mayor.getDistancia_recorrida()) {
                mayor = listaCorredores[i];
            }
        }
       return mayor;
     }
}
