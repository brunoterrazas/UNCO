/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje5;

/**
 *
 * @author Usuario
 */
class UsoHilosThread {

    public static void main(String[] args)
    {
        System.out.println("Hilo principal iniciando.");
        //Primero, construye un objeto unHilo.
        MiHiloThread mht = new MiHiloThread("#1");
        //Comienza la ejecución del hilo.
        mht.start();
        for (int i = 0; i < 50; i++) {
            System.out.print(" .");
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException exc) {
            System.out.println("Hilo principal interrumpido.");
        }
        System.out.println("Hilo principal finalizado.");
    }
}
