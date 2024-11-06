/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje5v2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class Olla {

    private int nRaciones;
    private Lock mutex;
    private Condition CECanibal;
    private Condition CECocinero;
    private Lock mutexComer;
    private int racionesActual;
    private boolean cocineroNotificado;

    public Olla(int raciones) {
        mutex = new ReentrantLock(true);
        mutexComer = new ReentrantLock(true);
        CECanibal = mutex.newCondition();
        CECocinero = mutex.newCondition();
        nRaciones = raciones;
        racionesActual = raciones;
   
    }

    public void cocinar() {
        mutex.lock();
        try {
            System.out.println("El cocinero esperando para cocinar");
            while (racionesActual > 0) {

                CECocinero.await();//esperando para cocinar
            }
            System.out.println("Al cocinero le avisan que no hay mas raciones:"
                    + racionesActual);
            racionesActual = nRaciones;//cocina mas raciones
            System.out.println("El Cocinero prepara mas raciones de comida:"
                    + racionesActual);

            CECanibal.signalAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            mutex.unlock();
        }
    }

    public void comer(String canibal) {
        mutexComer.lock();
        mutex.lock();
        try {
          
             while (racionesActual == 0) {
                if(racionesActual==0)
                {
                 System.out.println(canibal + " encuentra la olla vacía y notifica al cocinero.");
                CECocinero.signal(); // Notifica al cocinero solo si la olla está vacía
                }
                CECanibal.await(); // Espera a que el cocinero reponga las raciones
            }

            // Consume una ración si está disponible
            racionesActual--;
                System.out.println(canibal + " empieza a comer su ración de comida");
            
            System.out.println(canibal + " come su racion de comida");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            mutex.unlock();
            mutexComer.unlock();
        }
    }


}
