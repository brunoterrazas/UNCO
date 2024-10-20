/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje5v1;

/**
 *
 * @author Brunot
 */
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tren {

    private int pasajerosEnEspera = 0;  // Número de pasajeros esperando para subir al tren
    private int pasajerosEnTren = 0;    // Número de pasajeros que ya subieron al tren
    private Semaphore semTicket = new Semaphore(0, true);  // Para entregar tickets
    private Semaphore semMutex = new Semaphore(1);  // Exclusión mutua para acceso a los contadores
    private Semaphore semPartir = new Semaphore(1);
    private Semaphore semPasajerosEsperando = new Semaphore(0);
    private Semaphore pasajerosTren;  // Para controlar cuántos pasajeros pueden subir al tren
    private int capacidadTren;

    public Tren(int capacidadTren) {
        this.capacidadTren = capacidadTren;
        this.pasajerosTren = new Semaphore(0, true);  // Inicialmente no hay espacio hasta que se libere
    }

    // Pasajeros compran tickets
    public void comprarTicket(String pasajero) {
        try {
            System.out.println(pasajero + " quiere comprar su ticket");
             semPasajerosEsperando.release();
            semTicket.acquire();  // Esperar a que el vendedor le dé el ticket
        } catch (InterruptedException ex) {
            Logger.getLogger(Tren.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Vendedor entrega tickets a los pasajeros
    public void entregarTicket(String vendedor) {
        try { 
            semPasajerosEsperando.acquire();
        System.out.println(vendedor + " entrega un ticket a un pasajero");
        semTicket.release();  // Libera un ticket para que lo tome un pasajero
        } catch (InterruptedException ex) {
            Logger.getLogger(Tren.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        
    }

    // Pasajeros suben al tren
public void subir(String pasajero) {
    try {
        System.out.println(pasajero + " está esperando para subir al tren");
        
        semMutex.acquire();  // Proteger la modificación del contador
        pasajerosEnEspera++;
        
        if (pasajerosEnEspera == capacidadTren) {
            semPartir.release(); // Permite que el tren parta cuando esté lleno
        }
        
        semMutex.release();
        pasajerosTren.acquire();  // Esperar a que haya espacio en el tren
        
        semMutex.acquire();
        pasajerosEnTren++;
        pasajerosEnEspera--;
        System.out.println(pasajero + " subió al tren. Pasajeros en el tren: " + pasajerosEnTren);
        
        semMutex.release();
    } catch (InterruptedException ex) {
        Logger.getLogger(Tren.class.getName()).log(Level.SEVERE, null, ex);
    }
}

// El tren parte cuando está lleno
public void partir() {
    try {
        semPartir.acquire(); // Esperar a que el tren esté lleno

        semMutex.acquire();
        System.out.println("El tren está lleno. Va a partir con " + capacidadTren + " pasajeros");
         // Permite que los pasajeros suban
        pasajerosTren.release(capacidadTren); 
        Thread.sleep(2000);  
        
        pasajerosEnTren = 0;  // El tren llega a destino y se vacía
        semMutex.release();
    } catch (InterruptedException ex) {
        Logger.getLogger(Tren.class.getName()).log(Level.SEVERE, null, ex);
    }
}


}
