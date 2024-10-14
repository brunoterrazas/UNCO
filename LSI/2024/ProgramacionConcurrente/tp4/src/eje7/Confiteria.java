/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje7;

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
    private Semaphore semServir;
    private Semaphore semComer;
    private int contador=0;
    private int cantidad;

    public Confiteria(String nom, int cantidad)
    {
        this.nombre=nom;
        semSillaLibre=new Semaphore(1);
        semServir=new Semaphore(0);
        semComer=new Semaphore(0);
        this.cantidad=cantidad;
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
    public void sentarse(String empleado)
    {
        try {
            System.out.println(empleado+" esta intentando sentarse");
            semSillaLibre.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Confiteria.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    public void pedirServicio(String empleado)
    {
        System.out.println(empleado+" le pide al mozo que lo atienda");
      semServir.release();
    }
    
    public void tomarPedido()
    {
        try {
            semServir.acquire();
            System.out.println("El mozo toma el pedido");
            
            Thread.sleep(2000);
             this.contador++;
        } catch (InterruptedException ex) {
            Logger.getLogger(Confiteria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public void servirPedido()
      {
          System.out.println("El mozo sirve el pedido");
       semComer.release();
      }
      public void comer(String empleado)
      {
        try {
            semComer.acquire();
            System.out.println(empleado+" esta comiendo.....");
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Confiteria.class.getName()).log(Level.SEVERE, null, ex);
        }
          System.out.println(empleado+" terminó de comer y vuelve a trabajar");
        semSillaLibre.release();
         
      }
}
