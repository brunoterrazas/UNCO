/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje3;


import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Brunot
 */
public class Sala {

   
    private int cantidadMesas;
    private Semaphore semMesa;
    private Semaphore semMutex;
    private int estudiantes=0;
    public Sala(int cantMesas) {
        this.cantidadMesas = cantMesas;
        semMesa=new Semaphore(cantMesas,true); 
        semMutex=new Semaphore(1); 
    }

    public void tomarMesa(String nombre) {
      
        try {
            System.out.println(nombre+", intenta conseguir una mesa");
         //espera hasta que desocupen una mesa
           semMesa.acquire();
         
           semMutex.acquire();
            this.estudiantes++;
           semMutex.release();
           if(this.estudiantes==cantidadMesas)
           {
               System.out.println("Cant mesas: "+semMesa.availablePermits());
           
           }
       // si hay una mesa disponible-> ocupo la mesa
           System.out.println(nombre+" ocupa una mesa");      
        } catch (InterruptedException ex) {
            Logger.getLogger(Sala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    public void dejarMesa(String nombre)
    {
        System.out.println(nombre+" deja la mesa, y se va");
      this.semMesa.release();
      
     
    }
}
