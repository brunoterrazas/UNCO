/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje5;

import java.util.Random;

/**
 *
 * @author Usuario
 */
public class testImpresora {
    public static void main(String[] args) {
        // Definir el número de impresoras de cada tipo
        int numImpresorasA = 3;
        int numImpresorasB = 2;

        // Crear el centro de impresión con impresoras de tipo A y B
        CentroDeImpresion centro = new CentroDeImpresion(numImpresorasA, numImpresorasB);

        // Crear y ejecutar hilos de usuarios
        Cliente[] clientes = new Cliente[10];
        String[] tipos = {"A", "B", "A o B"};
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            String tipoImpresion = tipos[random.nextInt(3)];  // Elige aleatoriamente A, B o A o B
            clientes[i] = new Cliente(("cliente"+i),centro,tipoImpresion);
            clientes[i].start();
        }

        // Esperar a que todos los hilos terminen
        for (int i = 0; i < 10; i++) {
            try {
                clientes[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Todos los trabajos de impresión han terminado.");
    }
}
