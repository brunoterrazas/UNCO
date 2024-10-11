/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HamstersLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Acer
 */
public class RuedaLock {

    private Lock llave = new ReentrantLock(true);

    public void rodar(String nombre) {
        try {
            llave.lock();
            System.out.println(nombre + " empieza a rodar");
            Thread.sleep((long) Math.random()* 2500);
        } catch (InterruptedException ex) {
        } finally {
            llave.unlock();
        }
    }
}
