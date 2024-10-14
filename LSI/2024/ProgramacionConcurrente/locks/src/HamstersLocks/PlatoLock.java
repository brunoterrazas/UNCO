/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HamstersLocks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Acer
 */
public class PlatoLock {

    private Lock accesoComida;
    private Condition hayLugar;  //hamster en esperando para comer
     
    private int cantidad;
    private int comiendo;

    public PlatoLock(int maximo) {
        accesoComida = new ReentrantLock(true);
        //se crea la variable de condición asociada al lock accesoComida
        hayLugar = accesoComida.newCondition();
        comiendo = 0;
        cantidad = maximo;
    }

    public void empezarAComer(String nombre) {
        try {
            accesoComida.lock();
            while (comiendo >= cantidad) {
                System.out.println(nombre + " debe esperar para comer");
                hayLugar.await();
            }
            System.out.println(nombre + " empieza a comer");
            comiendo++;
        } catch (InterruptedException ex) {
        } finally {
            accesoComida.unlock();
        }
    }

    public void terminarDeComer(String nombre) {
        accesoComida.lock();
        try {
            System.out.println(nombre + " ------ termino de comer");
            comiendo--;
            hayLugar.signalAll();
        } finally {
            accesoComida.unlock();
        }
    }
}
