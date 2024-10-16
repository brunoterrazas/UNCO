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
    private final Semaphore semPerros;
    private final Semaphore semGatos;
    private final boolean comenGatos;
    private final int maxComedor;
    private final Semaphore mutex;
    private int cantidadComiendo=0;
    public Comedor(int max)
    {
      semPerros=new Semaphore(0,true);
      semGatos=new Semaphore(0,true);
      gatosEnEspera=0;
      perrosEnEspera=0;
      this.maxComedor=max;
      cantidadComiendo=0;
      comenGatos=true;
      mutex=new Semaphore(1,true);
    }
    public void entraPerro(String perro)
    {
        try {
            semPerros.acquire();
            mutex.acquire(); 
            perrosEnEspera++;
            mutex.release();
            //cant perros en espera +1
            System.out.println(perro+" esta comiendo...");
            Thread.sleep(300);
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
            semPerros.acquire();
            mutex.acquire(); 
            gatosEnEspera++;
            mutex.release();
            //cant gatos en espera +1
            System.out.println(gato+" esta comiendo...");
            Thread.sleep(300);
             mutex.acquire();
            gatosEnEspera--;
            mutex.release();     
    
    } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean turno()
    { 
           
      return comenGatos ;
    }
}
