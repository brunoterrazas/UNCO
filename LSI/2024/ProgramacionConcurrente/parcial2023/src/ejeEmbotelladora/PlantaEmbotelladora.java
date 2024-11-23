/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejeEmbotelladora;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class PlantaEmbotelladora {

    private int cajas, botellasVino, botellasAgua;
    private final int CAPACIDAD_CAJA_VINO = 10;
    private final int CAPACIDAD_CAJA_AGUA = 10;
    private final int CAPACIDAD_DEPOSITO = 100;
    private Semaphore semEmbotellarVino, semEmbotellarAgua, semEmpaquetar,semRepartir,semCajaVino, semCajaAgua, semChofer,
            mutexVino, mutexAgua;

    public PlantaEmbotelladora() {
        semEmbotellarVino = new Semaphore(1);
        semEmbotellarAgua = new Semaphore(1);
        semEmpaquetar = new Semaphore(0);
        semRepartir = new Semaphore(0);
        semChofer = new Semaphore(0);
        semCajaVino = new Semaphore(0);
        semCajaAgua = new Semaphore(0);
        cajas = 0;
        mutexVino=new Semaphore(1);
        mutexAgua=new Semaphore(1);
        botellasVino = 0;
        botellasAgua = 0;

    }

    public void producirVino(String embotellador) {

        try {
            System.out.println(embotellador + " esperando para colocar botella de vino");
            semEmbotellarVino.acquire();
            while (botellasVino >= CAPACIDAD_CAJA_VINO) {
                //avisamos al empaquetador para que cambie la caja de vino
                semEmpaquetar.release();
                semCajaVino.acquire();
            }
            mutexVino.acquire();
            botellasVino++;
            System.out.println(embotellador+" agrega una botella a la caja de vino: "+botellasVino);
            mutexVino.release();
            semEmbotellarVino.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(PlantaEmbotelladora.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void producirAgua(String embotellador) {
        try {
            System.out.println(embotellador + " esperando para colocar botella de agua");
            semEmbotellarAgua.acquire();
            while (botellasAgua >= CAPACIDAD_CAJA_AGUA) {
                //avisamos al empaquetador para que cambie la caja de agua
                semEmpaquetar.release();
                semCajaAgua.acquire();
            }
            mutexAgua.acquire();
            botellasAgua++;
            System.out.println(embotellador+" agrega una botella a la caja de agua: "+botellasAgua);
            mutexAgua.release();
            semEmbotellarAgua.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(PlantaEmbotelladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cambiarCaja() {
        try {
            
            semEmpaquetar.acquire();
            while (cajas >= CAPACIDAD_DEPOSITO) {
                semChofer.release();
                semRepartir.acquire();
            }
            if (botellasAgua == CAPACIDAD_CAJA_AGUA) {
                System.out.println("cambia la caja de agua por una caja vacia");
                mutexAgua.acquire();
                botellasAgua = 0;
                mutexAgua.release();
                semCajaAgua.release();
            } else {
                if (botellasVino == CAPACIDAD_CAJA_VINO) {
                    System.out.println("cambia la caja de vino por una caja vacia");
                    mutexVino.acquire();
                    botellasVino = 0;
                    mutexVino.release();
                    semCajaVino.release();
                }
            }
            cajas++;
            semEmpaquetar.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(PlantaEmbotelladora.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void repartirCajas() {
        try {
             System.out.println("El chofer esperando en el camion");
            semChofer.acquire();
            System.out.println("El chofer sale a distribuir las cajas en el camion");
            cajas = 0;
            semRepartir.release();
           
        } catch (InterruptedException ex) {
            Logger.getLogger(PlantaEmbotelladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
