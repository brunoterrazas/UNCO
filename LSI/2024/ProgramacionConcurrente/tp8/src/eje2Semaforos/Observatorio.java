/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje2Semaforos;

import java.util.concurrent.Semaphore;
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
    private int capacidadActual, permisosReducidos;
    private Semaphore mutex;
    private int visitanteEnEspera, sillaRuedasEnEspera, investigadorEnEspera, mantenimientoEnEspera;
    private int visitantesIngresados, mantenimientoIngresados;
    private Semaphore semIngresar;
    private Semaphore semVisitante;
    private Semaphore semSillaRuedas;
    private Semaphore semInvestigador;
    private Semaphore semMantenimiento;

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
        mutex = new Semaphore(1);
        semIngresar = new Semaphore(capacidadActual);
        semVisitante = new Semaphore(0);
        semSillaRuedas = new Semaphore(0);
        semInvestigador = new Semaphore(0);
        semMantenimiento = new Semaphore(0);;
    }

    public void ingresar(String nombre, String tipo) {

        try {
            semIngresar.acquire();

            switch (tipo) {
                case "SillaRuedas":
                    while (!hayEspacio(1) || visitantesIngresados > 0 || mantenimientoIngresados > 0 || investigadorEnEspera > 0) {
                        sillaRuedasEnEspera++;
                        semSillaRuedas.acquire();
                        sillaRuedasEnEspera--;
                    }
                    mutex.acquire();
                    ingresados++;
                    visitantesIngresados++;
                    capacidadActual = 30; // Reducción de capacidad
                    permisosReducidos = capacidadMaxima - capacidadActual;
                    semIngresar.acquire(permisosReducidos);
                    mutex.release();
                    break;
                case "Visitante":
                    while (!hayEspacio(1) || investigadorEnEspera > 0 || sillaRuedasEnEspera > 0) {
                        visitanteEnEspera++;
                        semVisitante.acquire();
                        visitanteEnEspera--;
                    }
                    mutex.acquire();
                    ingresados++;
                    visitantesIngresados++;
                    mutex.release();
                    break;
                case "Investigador":
                    while (ingresados > 0) {

                        investigadorEnEspera++;
                        semInvestigador.acquire();
                        investigadorEnEspera--;
                    }
                    mutex.acquire();
                    ingresados++;
                    mutex.release();
                    break;
                case "Mantenimiento":
                    while (!hayEspacio(1) || visitantesIngresados > 0 || sillaRuedasEnEspera > 0 || investigadorEnEspera > 0) {
                        mantenimientoEnEspera++;
                        semMantenimiento.acquire();
                        mantenimientoEnEspera--;
                    }
                    mutex.acquire();
                    ingresados++;
                    mantenimientoIngresados++;
                    mutex.release();
                    break;
            }
            System.out.println(nombre + " ingresó");
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            Logger.getLogger(Observatorio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mutex.release();
        }
    }

    public boolean hayEspacio(int cantidad) {
        return ingresados + cantidad <= capacidadActual;
    }

    public void salir(String nombre, String tipo) {

        try {
            mutex.acquire();
            switch (tipo) {
                case "SillaRuedas":
                    visitantesIngresados--;

                    System.out.println("capacidadActual: " + capacidadActual + ", capacidad maxima: " + capacidadMaxima);

                    this.capacidadActual = capacidadMaxima;
                    semIngresar.release(permisosReducidos);
                    permisosReducidos = 0;
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
        } catch (InterruptedException ex) {
            Logger.getLogger(Observatorio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            ingresados--;
            mutex.release();
        }
        semIngresar.release();
        System.out.println(nombre + " salió");

    }

    public void notificar() {

        try {
            mutex.acquire();
            if (investigadorEnEspera > 0) {
                semInvestigador.release();
            } else if (sillaRuedasEnEspera > 0) {
                semSillaRuedas.release();
            } else if (mantenimientoEnEspera > 0) {
                semMantenimiento.release();
            } else if (visitanteEnEspera > 0) {
                semVisitante.release();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Observatorio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mutex.release();
        }
    }

}
