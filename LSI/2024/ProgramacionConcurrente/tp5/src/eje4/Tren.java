/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje4;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class Tren {
    private int cantPasajeros;
    private int cantIngresados;
    private int pasajerosEnEspera;
    private Semaphore semPasajeros;
    private Semaphore semTicket;
    private Semaphore semEntrar;
    public Tren(int max)
    {
      cantPasajeros=0;
      cantIngresados=0;
      pasajerosEnEspera=0;
      semPasajeros=new Semaphore(0,true);
      semTicket=new Semaphore(1);
      semEntrar=new Semaphore(max,true);
              
    }
    public void comprarTicket(String pasajero)
    {
        try {
            System.out.println(pasajero+" quiere comprar su ticket");
            semTicket.acquire();
            semEntrar.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Tren.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void entregarTicket(String vendedor)
    {
        System.out.println(vendedor+" entrega su ticket al pasajero");
        semTicket.release();
    }
}
