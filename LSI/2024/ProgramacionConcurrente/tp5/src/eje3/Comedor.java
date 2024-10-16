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
    private int gatosEnEspera;
    private int perrosEnEspera;
    private Semaphore semPerros;
    private Semaphore semGatos;
    private boolean comenGatos;
    
    
    private Semaphore mutex;
    private int cantidadComiendo=0;
    public Comedor(int max)
    {
      semPerros=new Semaphore(0,true);
      semGatos=new Semaphore(0,true);
      gatosEnEspera=0;
      perrosEnEspera=0;
      comenGatos=true;
      mutex=new Semaphore(1,true);
    }
    public void entraPerro()
    {
        try {
            semPerros.acquire();
            //cant perros en espera +1
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void entraGato()
    {
    try {
            semPerros.acquire();
            //cant gatos en espera +1
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean turno()
    { 
           
      return comenGatos ;
    }
}
