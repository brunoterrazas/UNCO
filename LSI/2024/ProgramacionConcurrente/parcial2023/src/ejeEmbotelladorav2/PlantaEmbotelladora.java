/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejeEmbotelladorav2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class PlantaEmbotelladora {

    private int botellasVino, botellasAgua, cajas;
    private final int CAPACIDAD_CAJA_VINO = 10;
    private final int CAPACIDAD_CAJA_AGUA = 10;
    private final int CAPACIDAD_DEPOSITO = 20;
    private Semaphore semEmbotellarVino, semEmbotellarAgua, semEmpaquetar, semCajaVino, semCajaAgua, semChofer,
            semCajas, mutexAgua, mutexVino, mutexDeposito;

    public PlantaEmbotelladora() {
        semEmbotellarVino = new Semaphore(CAPACIDAD_CAJA_VINO);
        semEmbotellarAgua = new Semaphore(CAPACIDAD_CAJA_AGUA);
        semEmpaquetar = new Semaphore(CAPACIDAD_DEPOSITO);
        semChofer = new Semaphore(1);
        semCajaVino = new Semaphore(0);
        semCajaAgua = new Semaphore(0);
        semCajas = new Semaphore(0);
        mutexAgua = new Semaphore(1);
        mutexVino = new Semaphore(1);
        mutexDeposito = new Semaphore(1);
        botellasVino = 0;
        botellasAgua = 0;
        cajas = 0;
    }

    public void producirVino(String embotellador) {

        try {
            System.out.println(embotellador + " esperando para colocar botella de vino");
            semEmbotellarVino.acquire();
            mutexVino.acquire();
            botellasVino++;
            System.out.println(embotellador + " agrega una botella a la caja de vino: " + botellasVino);
            semCajaVino.release();
            mutexVino.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(PlantaEmbotelladora.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void producirAgua(String embotellador) {
        try {
            System.out.println(embotellador + " esperando para colocar botella de agua");
            semEmbotellarAgua.acquire();
            mutexAgua.acquire();
            botellasAgua++;
            System.out.println(embotellador + " agrega una botella a la caja de agua: " + botellasAgua);
            semCajaAgua.release();
            mutexAgua.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(PlantaEmbotelladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cambiarCaja(String tipoBotella) {
        try {
            semEmpaquetar.acquire();
            if (tipoBotella.equals("agua")) {
                semCajaAgua.acquire(CAPACIDAD_CAJA_AGUA);
                mutexAgua.acquire();
                System.out.println("Empaquetador cambia caja de agua por una nueva.");
                botellasAgua = 0; // Vaciar la caja de agua
                mutexAgua.release();
                semEmbotellarAgua.release(CAPACIDAD_CAJA_AGUA);
            } else if (tipoBotella.equals("vino")) {
                semCajaVino.acquire(CAPACIDAD_CAJA_VINO);
                mutexVino.acquire();
                System.out.println("Empaquetador cambia caja de vino por una nueva.");
                botellasVino = 0; // Vaciar la caja de vino
                mutexVino.release();
                semEmbotellarVino.release(CAPACIDAD_CAJA_VINO);
            }

            mutexDeposito.acquire();
            cajas++;
            System.out.println("Cajas en el depósito: " + cajas);
            semCajas.release();

            mutexDeposito.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void repartirCajas() {
        try {

            semChofer.acquire();

            semCajas.acquire(CAPACIDAD_DEPOSITO);
            mutexDeposito.acquire();
            System.out.println("El chofer sale a distribuir las cajas en el camion");
            cajas = 0;
            semEmpaquetar.release(CAPACIDAD_DEPOSITO);
            mutexDeposito.release();

            semChofer.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(PlantaEmbotelladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean estaCajaVinoLlena() {
        return botellasVino == CAPACIDAD_CAJA_VINO;
    }

    public boolean estaCajaAguaLlena() {
        return botellasAgua == CAPACIDAD_CAJA_AGUA;
    }

}
