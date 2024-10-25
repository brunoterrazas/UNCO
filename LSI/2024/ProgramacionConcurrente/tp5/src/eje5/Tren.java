/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje5;

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
    private Semaphore semPasajeros = new Semaphore(0,true);
    private Semaphore semPartida = new Semaphore(0);
    private int capacidadTren;

    public Tren(int max, int cantP) {
        this.capacidadTren = max;
        this.cantPasajeros = cantP;
    }

    public int getPasajerosEnEspera() {
        return pasajerosEnEspera;
    }

    public int getMaxEspacios() {
        return capacidadTren;
    }

    public boolean todosAtendidos() {
        return pasajerosAtendidos < cantPasajeros;
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
            semTicket.release();
            pasajerosAtendidos++;
            semMutex.release();
            System.out.println(vendedor + " entrega un ticket");
            
           
        } catch (InterruptedException ex) {
            Logger.getLogger(Tren.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void subir(String pasajero) {
        try {
            System.out.println(pasajero + " esperando para subir al tren");
            semMutex.acquire();
            pasajerosEnEspera++;
            if (pasajerosEnEspera == capacidadTren) {
              semPartida.release();
            }
            semMutex.release();
         
            
           
            semPasajeros.acquire();

            semMutex.acquire();
            pasajerosEnTren++;
            semMutex.release();
          
            semMutex.acquire();

            pasajerosEnEspera--;
            System.out.println(pasajero + " subió y está viajando en el tren");
              System.out.println("termina su recorrido:" + pasajero);
            semMutex.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Tren.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void partir() {
        try {
            semPartida.acquire();
            semMutex.acquire();
           
            if (pasajerosEnTren == capacidadTren) {
           
                System.out.println("El tren está lleno. Va a partir.");
                semPasajeros.release(capacidadTren);
           
                System.out.println("El tren parte con " + capacidadTren + " pasajeros.");
                Thread.sleep(3000);
                pasajerosEnTren = 0;
            }
            semMutex.release();
            semPartida.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Tren.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
