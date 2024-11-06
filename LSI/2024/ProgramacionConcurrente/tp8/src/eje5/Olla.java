/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje5;

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
    private Condition CECanival;
    private Condition CECocinero;
    private int racionesActual;
    private boolean cocineroNotificado;

    public Olla(int raciones) {
        mutex = new ReentrantLock(true);
        CECanival = mutex.newCondition();
        CECocinero = mutex.newCondition();
        nRaciones = raciones;
        racionesActual = raciones;
        cocineroNotificado = false;
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

            cocineroNotificado = false;
            CECanival.signalAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            mutex.unlock();
        }
    }

    public void comer(String canival) {
        mutex.lock();
        
        try {
            while (racionesActual == 0) {
                System.out.println(canival+" yo entro ");
                if (!cocineroNotificado) { // Solo el primer caníbal notifica al cocinero
                    System.out.println(canival + " avisa al cocinero que no hay más raciones.");
                    cocineroNotificado = true;
                    CECocinero.signal(); // Despierta al cocinero para que prepare más raciones
                }
                CECanival.await(); // El caníbal espera hasta que haya raciones
            }
            racionesActual--;
            System.out.println(canival + " come su racion de comida");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            mutex.unlock();
        }
    }


}
