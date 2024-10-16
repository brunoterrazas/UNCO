/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje4;

import java.util.concurrent.Semaphore;

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
    public Tren(int max)
    {
      cantPasajeros=0;
      cantIngresados=0;
      pasajerosEnEspera=0;
      semPasajeros=new Semaphore(0,true);
      semTicket=new Semaphore(0);
              
    }
    public void comprarTicket()
    {
       
    }
    public void entregarTicket()
    {
       
    }
}
