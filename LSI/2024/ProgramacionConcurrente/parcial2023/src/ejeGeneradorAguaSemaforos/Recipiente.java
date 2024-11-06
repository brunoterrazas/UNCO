/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejeGeneradorAguaSemaforos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class Recipiente {

    private int capacidadMaxima;
    private Semaphore semOxigeno;
    private Semaphore semHidrogeno;
    private Semaphore semAgua;
    private Semaphore mutexH;
    private Semaphore mutexO;
    private int cantOxigeno = 0;
    private int cantHidrogeno = 0;
    private int cantAgua = 0;

    public Recipiente(int capacidad) {
        capacidadMaxima = capacidad;
        semOxigeno = new Semaphore(1);
        semHidrogeno = new Semaphore(2);
        semAgua = new Semaphore(1);
        mutexH = new Semaphore(1);
        mutexO = new Semaphore(1);
    }

    public void oListo(String oxigeno) {
        try {
            System.out.println(oxigeno + ",esperando para formar Agua");
            semOxigeno.acquire();

            System.out.println(oxigeno + " listo para forma agua");
            mutexO.acquire();
            cantOxigeno++;
            mutexO.release();

            // Intentar formar agua si hay suficientes átomos
            intentarFormarAgua();

        } catch (InterruptedException ex) {
            Logger.getLogger(Recipiente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hListo(String hidrogeno) {
        try {
            System.out.println(hidrogeno + ",esperando para formar Agua");
            semHidrogeno.acquire();

            System.out.println(hidrogeno + " listo para forma agua");
            mutexH.acquire();
            cantHidrogeno++;
            mutexH.release();

            // Intentar formar agua si hay suficientes átomos
            intentarFormarAgua();

        } catch (InterruptedException ex) {
            Logger.getLogger(Recipiente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean sePuedeHacerAgua() {
        return cantOxigeno == 1 && cantHidrogeno == 2;
    }

    public void intentarFormarAgua() {
        try {
            semAgua.acquire();
            if (sePuedeHacerAgua()) {
                hacerAgua();
            }
            semAgua.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Recipiente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hacerAgua() {
        try {
            if (cantAgua >= capacidadMaxima) {
                System.out.println("Sobrepaso la capacidad del recipiente, hay " + cantAgua);
                System.out.println("Cambia de recipiente por uno vacio.");
                cantAgua = 0;  // Vaciar el recipiente al sobrepasar la capacidad
            }

            cantAgua++;  // Aumentar la cuenta de agua generada
            System.out.println("Agrega el agua: " + cantAgua);

            // Reiniciar los contadores de átomos para permitir otra combinación
            mutexH.acquire();
            cantHidrogeno -= 2;  // Reducir 2 hidrógenos usados
            mutexH.release();

            mutexO.acquire();
            cantOxigeno--;  // Reducir 1 oxígeno usado
            mutexO.release();

            // Liberar permisos para que otros hilos de hidrógeno y oxígeno puedan formar agua
            semHidrogeno.release(2);
            semOxigeno.release(1);

        } catch (InterruptedException ex) {
            Logger.getLogger(Recipiente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
