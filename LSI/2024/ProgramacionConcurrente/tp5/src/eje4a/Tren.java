/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje4a;

/**
 *
 * @author Usuario
 */
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tren {
    private int cantPasajeros;
    private int pasajerosAtendidos = 0;  
    private int pasajerosEnEspera = 0;   
    private int pasajerosEnTren = 0;   
    private Semaphore semTicket = new Semaphore(1, true);    
    private Semaphore semMutex = new Semaphore(1, true);  
    private Semaphore semPartida = new Semaphore(0); 
    private int maxEspacios;

    public Tren(int max, int cantP) {
        this.maxEspacios = max;
        this.cantPasajeros = cantP;
    }

    public boolean todosAtendidos() {
        return pasajerosAtendidos >= cantPasajeros;
    }

    public void comprarTicket(String pasajero) {
        try {
            semTicket.acquire();  
            System.out.println(pasajero + " ha comprado su ticket");
            semTicket.release();  
        } catch (InterruptedException ex) {
            Logger.getLogger(Tren.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void entregarTicket(String vendedor) {
        try {
            semMutex.acquire();  
            if (pasajerosAtendidos < cantPasajeros) {
                System.out.println(vendedor + " entrega un ticket");
                pasajerosAtendidos++;
                semTicket.release();  
            }
            semMutex.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Tren.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void subir(String pasajero) {
        try {
            semMutex.acquire();
            pasajerosEnEspera++;  
            System.out.println(pasajero + " esperando para subir al tren");

            if (pasajerosEnEspera == maxEspacios) {
                System.out.println("El tren está lleno. Va a partir.");
                Thread.sleep(2000);
                System.out.println("Tren viajando");
                semPartida.release(maxEspacios); 
                System.out.println("Bajan los pasajeros");
            }
            semMutex.release();

            semPartida.acquire();  

            semMutex.acquire();
            pasajerosEnTren++;
            pasajerosEnEspera--;
            System.out.println(pasajero + " subió y está viajando en el tren");
            semMutex.release();
             
           System.out.println("termina su proceso :"+pasajero);
        } catch (InterruptedException ex) {
            Logger.getLogger(Tren.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void partir() {
        try {
            semMutex.acquire();
            if (pasajerosEnTren == maxEspacios) {
                System.out.println("El tren parte con " + maxEspacios + " pasajeros.");
                Thread.sleep(3000);  
                pasajerosEnTren = 0;  
            }
            semMutex.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Tren.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
