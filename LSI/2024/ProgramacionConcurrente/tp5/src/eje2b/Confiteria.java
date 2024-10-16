/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje2b;

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
    private Semaphore semServirComida;
    private Semaphore semComer;
    private Semaphore semComidaLista;
    private int contador = 0;
    private int cantidad;

    public Confiteria(String nombre, int cantidad) {
        this.nombre = nombre;
        semSillaLibre = new Semaphore(2); // Dos empleados pueden sentarse
        semServirBebida = new Semaphore(0);
        semBeber = new Semaphore(0);
        semServirComida = new Semaphore(0);
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

    // Empleados intentan sentarse
    public boolean sentarse(String empleado) {
        boolean asientoLibre = semSillaLibre.tryAcquire();  // Ver si hay asientos libres
        if (asientoLibre) {
            this.contador++;
            System.out.println(empleado + " se sienta");
        }
        return asientoLibre;
    }

    public void pedirBebida(String empleado) {
        System.out.println(empleado + " le pide una bebida al mozo");
        semServirBebida.release(); 
    }

    public void beber(String empleado) {
        try {
            semBeber.acquire();  
            System.out.println(empleado + " está bebiendo...");
            Thread.sleep(100);  
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void pedirComida(String empleado) {
        System.out.println(empleado + " le pide comida al cocinero");
        semServirComida.release();  
    }

    public void comer(String empleado) {
        try {
            semComer.acquire(); 
            System.out.println(empleado+" comienza a comer...");
            Thread.sleep(200);  
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void dejarAsiento(String empleado) {
        System.out.println(empleado + " agradece y se vuelve a trabajar");
        semSillaLibre.release();  
    }

    public void servirBebida() {
        try {
            semServirBebida.acquire();  
            System.out.println("El mozo toma el pedido de bebida");
            Thread.sleep(100);  
            semBeber.release();  //el mozo entrega la bebida
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void prepararComida() {
        try {
            semServirComida.acquire(); 
            System.out.println("El cocinero prepara la comida....");
            Thread.sleep(500);  
              System.out.println("El cocinero le entrega la comida");
            semComer.release();  // le avisa que esta lista la comida
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
