/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioGeneradorAguav4;


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
    private Semaphore semListo;
    private Semaphore mutexH;
    private Semaphore mutexO;
    private Semaphore Hidrogeno;
    private Semaphore Oxigeno;
    private int cantOxigeno = 0;
    private int cantHidrogeno = 0;
    private int cantAgua = 0;

    public Recipiente(int capacidad) {
        capacidadMaxima = capacidad;
        semOxigeno = new Semaphore(1);
        semHidrogeno = new Semaphore(2);
        semListo = new Semaphore(1);
        mutexH = new Semaphore(1);
        mutexO = new Semaphore(1);
        Hidrogeno = new Semaphore(0);
        Oxigeno = new Semaphore(0);
   
    }

    public void oListo(String oxigeno) {
        try {
            System.out.println(oxigeno + ",esperando para formar Agua");
            semOxigeno.acquire();

            System.out.println(oxigeno + " listo para forma agua");
            mutexO.acquire();
            Oxigeno.release();
            cantOxigeno++;
            mutexO.release();

   
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
            Hidrogeno.release(2);
            cantHidrogeno++;
            mutexH.release();

           

        } catch (InterruptedException ex) {
            Logger.getLogger(Recipiente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
    public void hacerAgua() {
         try {
            
        if (cantOxigeno == 1 && cantHidrogeno == 2) {
           
                if (cantAgua >= capacidadMaxima) {
                    System.out.println("Sobrepaso la capacidad del recipiente, hay " + cantAgua);
                    System.out.println("Cambia de recipiente por uno vacio.");
                    cantAgua = 0;  // Vaciar el recipiente al sobrepasar la capacidad
                }

                
                // Reiniciar los contadores de átomos para permitir otra combinación
                mutexH.acquire();
                Hidrogeno.acquire(2);  // Reducir 2 hidrógenos usados
                   cantHidrogeno-=2;
                mutexH.release();

                mutexO.acquire();
                Oxigeno.acquire(); 
                   cantOxigeno--;// Reducir 1 oxígeno usado
                mutexO.release();

                // Liberar permisos para que otros hilos de hidrógeno y oxígeno puedan formar agua
                semHidrogeno.release(2);
                semOxigeno.release(1);
                semListo.release(3);
        }
        semListo.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(Recipiente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    

}
