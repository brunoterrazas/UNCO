/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje3;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Comedor {
    private  int gatosEnEspera;
    private  int perrosEnEspera;
    private Semaphore semPerros;
    private Semaphore semGatos;
    private boolean comenGatos;
    private Semaphore semComer;
    private Semaphore mutex;
    private int cantidadComiendo=0;
    public Comedor(int max)
    {
      semPerros=new Semaphore(0,true);
      semGatos=new Semaphore(0,true);
      gatosEnEspera=0;
      perrosEnEspera=0;
      semComer=new Semaphore(max,true);
      cantidadComiendo=0;
      comenGatos=true;
      mutex=new Semaphore(1,true);
    }
    public void entraPerro(String perro)
    {
        try {
            mutex.acquire(); 
            perrosEnEspera++;
            mutex.release();
            semPerros.acquire();
            semComer.acquire();
            //cant perros en espera +1
            System.out.println(perro+" esta comiendo...");
            Thread.sleep(300);
            semComer.release();
            mutex.acquire();
            perrosEnEspera--;
            mutex.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void entraGato(String gato)
    {
    try {
            mutex.acquire(); 
            gatosEnEspera++;
                 //cant gatos en espera +1
            mutex.release();
            semPerros.acquire();
            semComer.acquire();
            System.out.println(gato+" esta comiendo...");
            Thread.sleep(300);
            semComer.release();
            mutex.acquire();
            gatosEnEspera--;
            mutex.release();     
    
    } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean cambiarTurno()
    { 
        try {
            mutex.acquire();
            if(comenGatos)
           {
             comenGatos=false;
             semGatos.acquire();
             semPerros.release(this.perrosEnEspera);
           }
           else 
           {
               comenGatos=true;
               
             semPerros.acquire();
             semGatos.release(this.gatosEnEspera);
           }
          mutex.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
            return comenGatos ;
    }
}
