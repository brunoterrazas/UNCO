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
class MiHiloThread extends Thread {


    MiHiloThread(String nombre) {
        super(nombre);
    }
//Punto de entrada del hilo
//Los hilos comienzan a ejecutarse aquí

    public void run() {
        System.out.println("Comenzando " + getName());
        try {
            for (int contar = 0; contar < 10; contar++) {
                Thread.sleep(400);
                System.out.println("En " + getName() + ", el recuento " + contar);
            }
        } catch (InterruptedException exc) {
            System.out.println(getName() + "Interrumpido.");
        }
        System.out.println("Terminando " + getName());
    }
}
