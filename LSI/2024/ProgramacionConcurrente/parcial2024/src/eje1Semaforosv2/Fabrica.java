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

    Semaphore semRueda, semPuerta, semCarroceria, semEnsamblador, puertas, ruedas, carroceria;
    int cantRuedas, cantPuertas, cantCarrocerias, capacidadRuedas, capacidadPuertas, capacidadCarroceria;
    int cantAutos;
    private final Semaphore puertasEspera;
    private final Semaphore ruedasEspera;
    private final Semaphore carroceriaEspera;
    private Semaphore mutexPuertas;
    private Semaphore mutexRuedas;
    private Semaphore mutexCarrocerias;

    public Fabrica(int capacidadRuedas, int capacidadPuertas, int capacidadCarroceria) {

        this.capacidadCarroceria = capacidadCarroceria;
        this.capacidadPuertas = capacidadPuertas;
        this.capacidadRuedas = capacidadRuedas;

        this.semCarroceria = new Semaphore(1);
        this.semRueda = new Semaphore(1);
        this.semPuerta = new Semaphore(1);
        this.semEnsamblador = new Semaphore(1);
        this.mutexCarrocerias = new Semaphore(1);
        this.mutexRuedas = new Semaphore(1);
        this.mutexPuertas = new Semaphore(1);
        this.puertas = new Semaphore(0);
        this.ruedas = new Semaphore(0);
        this.carroceria = new Semaphore(0);
        cantPuertas = 0;
        cantRuedas = 0;
        cantCarrocerias = 0;
        cantAutos = 0;
        this.puertasEspera = new Semaphore(0);
        this.ruedasEspera = new Semaphore(0);
        this.carroceriaEspera = new Semaphore(0);

    }

    public void producirPuertas(String equipo) {
        try {
            this.semPuerta.acquire();
            while (cantPuertas >= capacidadPuertas) {

                System.out.println(equipo + " llenó la caja de puertas");

                puertasEspera.acquire();

            }
            mutexPuertas.acquire();
            cantPuertas++;
            this.puertas.release();
            mutexPuertas.release();
            
            this.semPuerta.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Fabrica.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void producirRuedas(String equipo) {
        try {
            this.semRueda.acquire();
            while (cantRuedas >= capacidadRuedas) {
                System.out.println(equipo + " llenó la caja de ruedas");

                ruedasEspera.acquire();

            }
            mutexRuedas.acquire();
            cantRuedas++;
            this.ruedas.release();
            mutexRuedas.release();
            System.out.println("cantidad de ruedas en metodoRuedas " + cantRuedas);
           
            this.semRueda.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Fabrica.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void producirCarrocerias(String equipo) {
        try {
            this.semCarroceria.acquire();
            while (cantCarrocerias >= capacidadCarroceria) {
                System.out.println(equipo + " llenó la caja de carrocerias");
                carroceriaEspera.acquire();

            }
            mutexCarrocerias.acquire();
            cantCarrocerias++;
             this.carroceria.release();
            mutexCarrocerias.release();
           
            this.semCarroceria.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Fabrica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ensamblarAutomovil(String equipo) {
        try {
            this.semEnsamblador.acquire();
            if (cantAutos == 5) {

                System.out.println(equipo + " empaqueta vehiculos producidos a , autos:" + cantAutos);
                Thread.sleep(200);
                cantAutos = 0;

            }
             this.ruedas.acquire(4);
            mutexRuedas.acquire();
            
            cantRuedas = cantRuedas - 4;
            mutexRuedas.release();
            System.out.println("cantidad de ruedas despues de restar -4 => " + cantRuedas);

            if (cantRuedas < capacidadRuedas) {
                puertasEspera.release();
            }

            System.out.println(equipo + " autos producidos: " + cantAutos);
            this.puertas.acquire(2);
            mutexPuertas.acquire();
            cantPuertas = cantPuertas - 2;
            mutexPuertas.release();
            if (cantPuertas < this.capacidadPuertas) {
                puertasEspera.release();
            }
            this.carroceria.acquire(1);
            mutexCarrocerias.acquire();
            cantCarrocerias--;
            mutexCarrocerias.release();

            if (cantCarrocerias < capacidadCarroceria) {
                carroceriaEspera.release();
            }
            System.out.println("Un vehiculo producido ");

            cantAutos++;
            this.semEnsamblador.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Fabrica.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
