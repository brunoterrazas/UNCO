/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje3b;

/**
 *
 * @author Usuario
 */
public class Main {
   public static void main(String[] args) {
Proceso proceso = new Proceso();

        // Crear hilos para cada proceso
        Thread hiloP1 = new Thread(() -> {
            try {
                proceso.P1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread hiloP3 = new Thread(() -> {
            try {
                proceso.P3();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread hiloP2 = new Thread(() -> {
            try {
                proceso.P2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Iniciar los hilos
        hiloP1.start();
        hiloP3.start();
        hiloP2.start();
   
   } 
}
