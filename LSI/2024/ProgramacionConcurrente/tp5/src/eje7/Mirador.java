/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje7;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Mirador {
    private Semaphore semEscalera,semTobogan,semToboganUno,semToboganDos;
    public Mirador(int maxEscalera)
    {
      semEscalera=new Semaphore(maxEscalera,true);
      semToboganUno=new Semaphore(1,true);
      semToboganDos=new Semaphore(1,true);
    }
    public void subirEscalera(String visitante)
    {
       try {
            System.out.println(visitante+" sube a la escalera"); 
            semEscalera.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Mirador.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public void bajarTobogan(String visitante)
    {
        try {
            System.out.println(visitante+" esperando para bajar del tobogan");
            int opc=valorRandom(2);//1 o 2
            switch(opc)
             {
                case 1: 
                  semToboganUno.acquire();
                  System.out.println(visitante+" baja por tobogan uno");
                  Thread.sleep(1500);
                  semToboganUno.release();
                  break;
                case 2: 
                  semToboganDos.acquire();
                  System.out.println(visitante+" baja por tobogan dos");
                  Thread.sleep(1500);
                  semToboganDos.release();
                  break;
             }
            
             semEscalera.release();
            } catch (InterruptedException ex) {
            Logger.getLogger(Mirador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public int valorRandom(int max) {
        return (int) (Math.random() * max + 1);
    }
    
}
