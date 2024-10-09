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
public class Taxi {
    private Semaphore semTaxiDisponible;
    private Semaphore semLlegadaDestino;
    private Semaphore mutex;
    private String pasajeroActual;  
    private int contador=0;
    private int cantViajes;
    public Taxi() {
        this.semTaxiDisponible = new Semaphore(0);
        this.semLlegadaDestino = new Semaphore(0);
        this.mutex=new Semaphore(1);
    }

    public void pedirTaxi(String pasajero) {
        try {
            this.mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.pasajeroActual = pasajero; 
        semTaxiDisponible.release();  
        System.out.println(pasajero + " pide taxi");
      
    }

    public void conducir(String taxista, int cantViajes) {
        while (contador<cantViajes) { 
            try {
                System.out.println(taxista + " descansando.......");
                semTaxiDisponible.acquire();  
               viajando(taxista);
                dejarPasajero(taxista);
            } catch (InterruptedException ex) {
                Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            contador++;
           
        }
    }

    public void viajando(String taxista) {
        try {
            System.out.println(taxista+" viajando con " + pasajeroActual + " ........");
            Thread.sleep(2000);  // Simula el tiempo de viaje
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dejarPasajero(String taxista) {
        
        System.out.println(taxista + " avisa a " + pasajeroActual + " que ha llegado al destino");
        semLlegadaDestino.release();  
    }

    public void pagar(String pasajero) {
        try {
            semLlegadaDestino.acquire();  
            System.out.println(pasajero + " le paga al taxista");
          this.mutex.release();    
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    
}
