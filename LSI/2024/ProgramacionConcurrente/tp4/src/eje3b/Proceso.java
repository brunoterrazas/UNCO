/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje3b;
import java.util.concurrent.Semaphore;

class Proceso{
    private final Semaphore semaforoP1 = new Semaphore(1); 
    private final Semaphore semaforoP3 = new Semaphore(0);
    private final Semaphore semaforoP2 = new Semaphore(0);

    public void P1() throws InterruptedException {
        while (true) {
            semaforoP1.acquire();
            System.out.println("Ejecutando P1");
            Thread.sleep(1000);
            System.out.println("Finalizado P1");
            semaforoP3.release();
        }
    }

    public void P3() throws InterruptedException {
        while (true) {
            semaforoP3.acquire();
            System.out.println("Ejecutando P3");
            Thread.sleep(1000);
            System.out.println("Finalizado P3");
            semaforoP2.release();
        }
    }

    public void P2() throws InterruptedException {
        while (true) {
            semaforoP2.acquire();
            System.out.println("Ejecutando P2");
            Thread.sleep(1000);
            System.out.println("Finalizado P2");
            semaforoP1.release();
        }
    }
}