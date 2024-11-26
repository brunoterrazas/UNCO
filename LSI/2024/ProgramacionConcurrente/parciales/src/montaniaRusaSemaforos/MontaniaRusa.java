/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montaniaRusaSemaforos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class MontaniaRusa {

    private Semaphore semSubir, semPartir, mutex, semTerminarVuelta;
    private int recorridos, maxRecorridos, maxCapacidad, pasajerosEnTren, pasajerosEnEspera, cantViajes;

    public MontaniaRusa(int capacidad, int cantRecorridos) {
        semSubir = new Semaphore(capacidad, true);
        semPartir = new Semaphore(0);
        maxCapacidad = capacidad;
        maxRecorridos = cantRecorridos;
        mutex = new Semaphore(1);
        semTerminarVuelta = new Semaphore(0, true);
        pasajerosEnTren = 0;
        recorridos = 0;
        cantViajes = 0;
    }

    public void subir(String pasajero) {
        try {
            semSubir.acquire();
            mutex.acquire();
            pasajerosEnTren++;
            cantViajes++;
            mutex.release();
            if (pasajerosEnTren == maxCapacidad) {
                semPartir.release();
            }
            semTerminarVuelta.acquire();
            System.out.println(pasajero + " terminó de dar la vuelta");
        } catch (InterruptedException ex) {
            Logger.getLogger(MontaniaRusa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void darVuelta() {
        try {
            semPartir.acquire();
            if (recorridos < maxRecorridos) {
                System.out.println(".......Tren viajando........");
                Thread.sleep(2000);

                semTerminarVuelta.release(maxCapacidad);
                System.out.println("....Pasajeros bajando....");
                Thread.sleep(1000);
                mutex.acquire();
                pasajerosEnTren = 0;
                mutex.release();
                recorridos++;
                System.out.println("Recorridos: " + recorridos);
                semSubir.release(maxCapacidad);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(MontaniaRusa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getCantViajes() {
        return cantViajes;
    }

    public int getTotal() {
        return maxCapacidad * maxRecorridos;
    }
}
