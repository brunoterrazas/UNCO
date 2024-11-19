/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje1Semaforosv2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class Fabrica {
    private int cantidadAutos;
    private Semaphore semDisponiblesRuedas;
    private Semaphore semDisponiblesPuertas;
    private Semaphore semDisponiblesCarroceria;
    private Semaphore semCapacidadMaximaRuedas;
    private Semaphore semCapacidadMaximaPuertas;
    private Semaphore semCapacidadMaximaCarroceria;
    private Semaphore semEnsamblar;
    public Fabrica(int ruedasCapacidad, int puertasCapacidad, int carroceriaCapacidad) {
        semDisponiblesRuedas = new Semaphore(0);
        semDisponiblesPuertas = new Semaphore(0);
        semDisponiblesCarroceria = new Semaphore(0);
        semCapacidadMaximaRuedas = new Semaphore(ruedasCapacidad);
        semCapacidadMaximaPuertas = new Semaphore(puertasCapacidad);
        semCapacidadMaximaCarroceria = new Semaphore(carroceriaCapacidad);
        semEnsamblar = new Semaphore(1);
        cantidadAutos = 0;
    }

    public void producirRuedas(String equipo) {
        try {
            semCapacidadMaximaRuedas.acquire();
            System.out.println(equipo + " produciendo rueda.");
            semDisponiblesRuedas.release();
        } catch (InterruptedException e) {
            System.err.println(equipo + " fue interrumpido mientras producía ruedas.");
        }
    }

    public void producirPuertas(String equipo) {
        try {
            semCapacidadMaximaPuertas.acquire();
            System.out.println(equipo + " produciendo puerta.");
            semDisponiblesPuertas.release();
        } catch (InterruptedException e) {
            System.err.println(equipo + " fue interrumpido mientras producía puertas.");
        }
    }

    public void producirCarroceria(String equipo) {
        try {
            semCapacidadMaximaCarroceria.acquire();
            System.out.println(equipo + " produciendo carrocería.");
            semDisponiblesCarroceria.release();
        } catch (InterruptedException e) {
            System.err.println(equipo + " fue interrumpido mientras producía carrocerías.");
        }
    }

    public void ensamblarAutomovil(String equipo) {
        try {
            semDisponiblesPuertas.acquire(2);
            semDisponiblesRuedas.acquire(4);
            semDisponiblesCarroceria.acquire(1);
            semEnsamblar.acquire();

            cantidadAutos++;
            System.out.println(equipo + " ensamblando auto número " + cantidadAutos);

            if (cantidadAutos % 5 == 0) {
                empaquetarAutos();
            }

            semCapacidadMaximaPuertas.release(2);
            semCapacidadMaximaRuedas.release(4);
            semCapacidadMaximaCarroceria.release(1);
            semEnsamblar.release();
        } catch (InterruptedException e) {
            System.err.println(equipo + " fue interrumpido mientras ensamblaba.");
        }
    }

    private void empaquetarAutos() throws InterruptedException {
        System.out.println("Empaquetando autos...");
        Thread.sleep(200);
        System.out.println("Autos empaquetados y listos para distribución.");
    }
}
