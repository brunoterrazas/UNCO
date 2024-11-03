/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje4v1;


import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CentroHemoterapia {

    private int cantidadCamillas;
    private int cantidadEnCamilla;
    private Semaphore semCamilla;
    private int cantidadRevistas;
    private int cantidadConRevista;
    private Semaphore semRevista;
    private Semaphore mutexCamilla;
    private Semaphore mutexRevista;
    private Semaphore semTelevisor;
   private Semaphore ingresar=new Semaphore(1);
private Semaphore mutex=new Semaphore(1);
private int cantPacientes=0;
    public CentroHemoterapia(int camillas, int revistas) {
        cantidadCamillas = camillas;
        cantidadEnCamilla = 0;
        semCamilla = new Semaphore(cantidadCamillas, true);
        cantidadRevistas = revistas;
        semRevista = new Semaphore(cantidadRevistas, true);
        cantidadConRevista=0;    
        semTelevisor = new Semaphore(0);
        mutexCamilla = new Semaphore(1);
        mutexRevista = new Semaphore(1);
    }

    public void donarSangre(String donador) {
        try {
            if (cantidadEnCamilla < cantidadCamillas) {//toma una camilla
                semCamilla.acquire();
                this.cantPacientes = this.cantPacientes + 1;
                 System.out.println("Ingresante " + donador + " registrado. Total: " + cantPacientes);

                System.out.println(donador + " ocupa una camilla para que le extraigan sangre");
                mutexCamilla.acquire();
                cantidadEnCamilla++;
                mutexCamilla.release();
                System.out.println(donador + " esta siendo atendido en su camilla");
                Thread.sleep(4000);
                mutexCamilla.acquire();
                cantidadEnCamilla--;
                mutexCamilla.release();
                semCamilla.release();
            } else {
                if (cantidadConRevista < cantidadRevistas) {
                    semRevista.acquire();
                    System.out.println(donador + "  agarra una revista, espera hasta que lo llamen");
                     mutexRevista.acquire();
                    cantidadConRevista++;
                    mutexRevista.release();
                    semCamilla.acquire();
                     mutexRevista.acquire();
                    cantidadConRevista--;
                    mutexRevista.release();
                    
                    semRevista.release();
                    semTelevisor.release();//le da su revista a otro que mira la tv
                    System.out.println(donador + " ocupa una camilla para que le extraigan sangre");
                    mutexCamilla.acquire();
                    this.cantPacientes = this.cantPacientes + 1;
                         System.out.println("Ingresante " + donador + " registrado. Total: " + cantPacientes);
                    cantidadEnCamilla++;
                    mutexCamilla.release();
                    System.out.println(donador + " esta siendo atendido en su camilla");
                    Thread.sleep(4000);
                    mutexCamilla.acquire();
                    cantidadEnCamilla--;
                    mutexCamilla.release();
                    semCamilla.release();

                } else {
                    semTelevisor.acquire();
                    System.out.println(donador+" mira la television");
                    semRevista.acquire();
                    System.out.println(donador + "  agarra una revista, espera hasta que lo llamen");
                    semRevista.release();
                         semCamilla.acquire();
                System.out.println(donador + " ocupa una camilla para que le extraigan sangre");
                mutexCamilla.acquire();
                this.cantPacientes = this.cantPacientes + 1;
                     System.out.println("Ingresante " + donador + " registrado. Total: " + cantPacientes);
                cantidadEnCamilla++;
                mutexCamilla.release();
                System.out.println(donador + " esta siendo atendido en su camilla");
                Thread.sleep(4000);
                mutexCamilla.acquire();
                cantidadEnCamilla--;
                mutexCamilla.release();
                semCamilla.release();
                }

            }

        } catch (InterruptedException ex) {
            Logger.getLogger(CentroHemoterapia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public void contarCantPacientes(String nombre) {
        try {
            ingresar.acquire();
            
            this.cantPacientes = this.cantPacientes + 1;
            System.out.println("Ingresante " + nombre + " registrado. Total: " + cantPacientes);

         
            ingresar.release();
        } catch (InterruptedException ex) {
        }

    }
    public void tomarCamilla(String donador)
    {
        try {
            semCamilla.acquire();
            System.out.println(donador + " ocupa una camilla para que le extraigan sangre");
            mutexCamilla.acquire();
            cantidadEnCamilla++;
            mutexCamilla.release();
            System.out.println(donador + " esta siendo atendido en su camilla");
            Thread.sleep(2000);
            mutexCamilla.acquire();
            cantidadEnCamilla--;
            mutexCamilla.release();
            semCamilla.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(CentroHemoterapia.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}