/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class Observatorio {

    private int capacidadMaxima, ingresados;
    private int capacidadActual;
    private Lock mutex;
    private int visitanteEnEspera, sillaRuedasEnEspera, investigadorEnEspera, mantenimientoEnEspera;
    private int visitantesIngresados, mantenimientoIngresados;
    private Condition CEVisitante;
    private Condition CESillaRuedas;
    private Condition CEInvestigador;
    private Condition CEMantenimiento;

    public Observatorio(int maximaCapacidad) {
        capacidadMaxima = maximaCapacidad;
        capacidadActual = maximaCapacidad;
        ingresados = 0;
        visitanteEnEspera = 0;
        sillaRuedasEnEspera = 0;
        investigadorEnEspera = 0;
        mantenimientoEnEspera = 0;
        visitantesIngresados = 0;
        mantenimientoIngresados = 0;
        mutex = new ReentrantLock();
        CEVisitante = mutex.newCondition();
        CESillaRuedas = mutex.newCondition();
        CEInvestigador = mutex.newCondition();
        CEMantenimiento = mutex.newCondition();
    }

    public void ingresar(String nombre, String tipo) {
        mutex.lock();
        try {
            switch (tipo) {
                case "SillaRuedas":
                    while (!hayEspacio(1) || visitantesIngresados > 0 || mantenimientoIngresados > 0 || investigadorEnEspera > 0) {
                        sillaRuedasEnEspera++;
                        CESillaRuedas.await();
                        sillaRuedasEnEspera--;
                    }
                    ingresados++;
                    visitantesIngresados++;
                    capacidadActual = 30; // Reducción de capacidad
                    break;
                case "Visitante":
                    while (!hayEspacio(1) || investigadorEnEspera > 0 || sillaRuedasEnEspera > 0) {
                        visitanteEnEspera++;
                        CEVisitante.await();
                        visitanteEnEspera--;
                    }
                    ingresados++;
                    visitantesIngresados++;
                    break;
                case "Investigador":
                    while (ingresados > 0) {
                        investigadorEnEspera++;
                        CEInvestigador.await();
                        investigadorEnEspera--;
                    }
                    ingresados++;
                    break;
                case "Mantenimiento":
                    while (!hayEspacio(1) || visitantesIngresados > 0 || sillaRuedasEnEspera > 0 || investigadorEnEspera > 0) {
                        mantenimientoEnEspera++;
                        CEMantenimiento.await();
                        mantenimientoEnEspera--;
                    }
                    ingresados++;
                    mantenimientoIngresados++;
                    break;
            }
            System.out.println(nombre + " ingresó");
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            Logger.getLogger(Observatorio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mutex.unlock();
        }
    }

    public boolean hayEspacio(int cantidad) {
        return ingresados + cantidad <= capacidadActual;
    }

    public void salir(String nombre, String tipo) {
        mutex.lock();
        try {
            switch (tipo) {
                case "sillaRuedas":
                    visitantesIngresados--;

                    System.out.println("capacidadActual: " + capacidadActual + ", capacidad maxima: " + capacidadMaxima);
                    this.capacidadActual = capacidadMaxima;

                    break;
                case "Visitante":

                    visitantesIngresados--;

                    break;
                case "Investigador":
                    System.out.println(nombre + " guarda las observaciones en su libro");

                    break;
                case "Mantenimiento":

                    mantenimientoIngresados--;

                    break;

            }
        } finally {
            mutex.unlock();
        }
        ingresados--;
        System.out.println(nombre + " salió");

    }

    public void notificar() {
        mutex.lock();
        try {
            // Adquiere el bloqueo
            if (investigadorEnEspera > 0) {
                CEInvestigador.signal();
            } else if (sillaRuedasEnEspera > 0) {
                CESillaRuedas.signal();
            } else if (mantenimientoEnEspera > 0) {
                CEMantenimiento.signalAll();
            } else {
                CEVisitante.signalAll();
            }
        } finally {
            mutex.unlock();
        }
    }

}
