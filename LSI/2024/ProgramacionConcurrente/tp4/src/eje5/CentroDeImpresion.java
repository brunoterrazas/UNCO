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
import java.util.concurrent.Semaphore;
import java.util.Random;

class CentroDeImpresion {
    private final Semaphore impresorasA;
    private final Semaphore impresorasB;
    private final Semaphore mutex; // Semáforo para manejar la sección crítica (mensajes en consola)

    public CentroDeImpresion(int numA, int numB) {
        this.impresorasA = new Semaphore(numA);
        this.impresorasB = new Semaphore(numB);
        this.mutex = new Semaphore(1); // Solo permite un hilo en la sección crítica a la vez
    }

    public void imprimir(String tipo) {
        try {
            String nombreCliente= Thread.currentThread().getName();
            if (tipo.equals("A")) {
                impresorasA.acquire(); // Adquirir impresora A
                realizarImpresion("A",nombreCliente);
                impresorasA.release(); // Liberar impresora A
            } else if (tipo.equals("B")) {
                impresorasB.acquire(); // Adquirir impresora B
                realizarImpresion("B", nombreCliente);
                impresorasB.release(); // Liberar impresora B
            } else if (tipo.equals("A o B")) {
                // Intentar primero impresora A, luego B
                if (impresorasA.tryAcquire()) {
                    realizarImpresion("A", nombreCliente);
                    impresorasA.release();
                } else if (impresorasB.tryAcquire()) {
                    realizarImpresion("B", nombreCliente);
                    impresorasB.release();
                } else {
                    // Esperar hasta que alguna impresora esté disponible
                    while (true) {
                        if (impresorasA.tryAcquire()) {
                            realizarImpresion("A", nombreCliente);
                            impresorasA.release();
                            break;
                        } else if (impresorasB.tryAcquire()) {
                            realizarImpresion("B", nombreCliente);
                            impresorasB.release();
                            break;
                        }
                        Thread.sleep(100);  // Evitar bucle ocupado
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void realizarImpresion(String tipo, String nombreCliente) {
        try {
            mutex.acquire(); // Adquirir el semáforo para la sección crítica
            System.out.println( nombreCliente + " está imprimiendo en impresora " + tipo);
            mutex.release(); // Liberar el semáforo de la sección crítica
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(new Random().nextInt(2000) + 1000);  // Simula el tiempo de impresión
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            mutex.acquire(); // Adquirir el semáforo para la sección crítica
            System.out.println(nombreCliente + " terminó de imprimir en impresora " + tipo);
            mutex.release(); // Liberar el semáforo de la sección crítica
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

