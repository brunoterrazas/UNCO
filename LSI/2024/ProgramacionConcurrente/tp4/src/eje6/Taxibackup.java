/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje6;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Taxibackup {
    private Semaphore semTaxiDisponible;
    private Semaphore semLlegadaDestino;
    private String pasajeroActual;  

    public Taxibackup() {
        this.semTaxiDisponible = new Semaphore(0);
        this.semLlegadaDestino = new Semaphore(0);
    }

    public void pedirTaxi(String pasajero) {
        this.pasajeroActual = pasajero; 
        semTaxiDisponible.release();
        System.out.println(pasajero + " pide taxi");
    }

    public void conducir(String taxista) {
        System.out.println(taxista + " descansando.......");
        try {
            semTaxiDisponible.acquire();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxibackup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void viajando(String taxista) {
        try {
            System.out.println(taxista+" llevando a " + pasajeroActual + " ........");
            Thread.sleep(2000);  
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxibackup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dejarPasajero(String taxista) {
        semLlegadaDestino.release();
        System.out.println(taxista + " avisa a " + pasajeroActual + " que ha llegado al destino");
    }

    public void pagar(String pasajero) {
        try {
            semLlegadaDestino.acquire();
            System.out.println(pasajero + " le paga al taxista");
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxibackup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
