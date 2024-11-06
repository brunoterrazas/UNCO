/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje4;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CentroHemoterapia {
    private final int cantidadCamillas;
    private int cantidadEnCamilla;
    private final Semaphore semCamilla;
    private final int cantidadRevistas;
    private int cantidadConRevista;
    private final Semaphore semRevista;
    private final Semaphore mutexCamilla;
    private final Semaphore mutexRevista;
    private final Semaphore semTelevisor;

    public CentroHemoterapia(int camillas, int revistas) {
        cantidadCamillas = camillas;
        cantidadEnCamilla = 0;
        semCamilla = new Semaphore(cantidadCamillas, true);
        cantidadRevistas = revistas;
        semRevista = new Semaphore(cantidadRevistas, true);
        cantidadConRevista = 0;
        semTelevisor = new Semaphore(0);
        mutexCamilla = new Semaphore(1);
        mutexRevista = new Semaphore(1);
    }

    public void donarSangre(String donador) {
        try {
            // Intento adquirir camilla
            if (semCamilla.tryAcquire()) {
                tomarCamilla(donador);
            } else {
                // Sin camilla, intenta obtener una revista
                if (semRevista.tryAcquire()) {
                    System.out.println(donador + " está leyendo una revista mientras espera.");
                    tomarCamillaDesdeRevista(donador);
                } else {
                    System.out.println(donador + " está mirando el televisor mientras espera.");
                    esperarConTelevisor(donador);
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(CentroHemoterapia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void tomarCamilla(String donador) throws InterruptedException {
        System.out.println(donador + " ocupa una camilla para donar sangre.");
        mutexCamilla.acquire();
        cantidadEnCamilla++;
        mutexCamilla.release();
        Thread.sleep(2000); // Simulación de tiempo de donación
        liberarCamilla(donador);
    }

    private void tomarCamillaDesdeRevista(String donador) throws InterruptedException {
        // Espera a una camilla después de leer una revista
        semCamilla.acquire();
        System.out.println(donador + " deja la revista y va a la camilla.");
        liberarRevista();
        tomarCamilla(donador);
    }

    private void esperarConTelevisor(String donador) throws InterruptedException {
        semTelevisor.acquire(); // Espera hasta que una revista esté disponible
        System.out.println(donador + " toma una revista cuando se libera.");
        donarSangre(donador); // Reintenta proceso de donación con revista
    }

    private void liberarCamilla(String donador) {
        try {
            mutexCamilla.acquire();
            cantidadEnCamilla--;
            System.out.println(donador + " ha terminado de donar y libera una camilla.");
            mutexCamilla.release();
            semCamilla.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(CentroHemoterapia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void liberarRevista() {
        try {
            mutexRevista.acquire();
            cantidadConRevista--;
            System.out.println("Una revista ha sido liberada.");
            mutexRevista.release();
            semRevista.release();
            semTelevisor.release(); // Permite que alguien viendo la TV tome la revista
        } catch (InterruptedException ex) {
            Logger.getLogger(CentroHemoterapia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
