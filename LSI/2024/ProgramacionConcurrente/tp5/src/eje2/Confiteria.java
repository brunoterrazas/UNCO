/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Confiteria {

    private String nombre;
    private Semaphore semSillaLibre;
    private Semaphore semServirBebida;
    private Semaphore semBeber;
    private Semaphore semComer;
    private Semaphore semComidaLista;
    private int contador = 0;
    private int cantidad;

    public Confiteria(String nom, int cantidad) {
        this.nombre = nom;
        semSillaLibre = new Semaphore(2);
        semServirBebida = new Semaphore(0);
        semBeber = new Semaphore(0);
        semComer = new Semaphore(0);
        semComidaLista = new Semaphore(0);
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getContador() {
        return contador;
    }

    public int getCantidad() {
        return cantidad;
    }

    public boolean sentarse(String empleado) {
      boolean hayEspacio=semSillaLibre.tryAcquire();
      
      this.contador++;
       
       return hayEspacio;
    }

    public void pedirBebida(String empleado) {
        semServirBebida.release();
    }
    public void pedirComida(String empleado) {
        semComidaLista.release();
    }

    public void tomarPedido() {
        try {
            semServirBebida.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Confiteria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void prepararComida() {
        try {
            // System.out.println(empleado+" le pide al mozo que lo atienda");
            semComidaLista.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Confiteria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void servirComida() {
        semComer.release();
    }
      public void servirBebida() {
  
        semBeber.release();
    }


    public void comer(String empleado) {
        try {
            semComer.acquire();
            System.out.println(empleado+" esta comiendo");  
            Thread.sleep(200);
              
        } catch (InterruptedException ex) {
            Logger.getLogger(Confiteria.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

    public void beber(String empleado) {
        try {
            semBeber.acquire();
            
            System.out.println(empleado+" esta bebiendo");  
            Thread.sleep(200);
          } catch (InterruptedException ex) {
            Logger.getLogger(Confiteria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dejarAsiento(String nombre) {
        System.out.println(nombre+"agradece la atencion, termina de comer y vuelve a trabajar");
        semSillaLibre.release();

    }
}
