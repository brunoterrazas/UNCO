/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BarberoDormilonRunnable;

import BarberoDormilonThread.*;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Barberia {
    private Semaphore semSillon;
    private Semaphore semBarbero;
    private Semaphore semCliente;
    String miNombre;
    public Barberia(String nombre){
     this.miNombre=nombre;
     this.semSillon=new Semaphore(1,true);
     this.semBarbero=new Semaphore(0,true);
     this.semCliente=new Semaphore(0,true);
        System.out.println("Bienvenidos a la barberia "+this.miNombre);
    }
    public boolean entrar(String nombreCliente){
        System.out.println("-------------- soy "+nombreCliente+" estoy intentando entrar");
        return this.semSillon.tryAcquire();
    }
    public void solicitarCorte(String nombreCliente)
    {
        System.out.println("--------------soy "+nombreCliente+" estoy solicitando corte");
        this.semBarbero.release();
        try {
            this.semCliente.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Barberia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void esperarCliente(String nombreBarbero){
    
        try {
            this.semBarbero.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Barberia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void terminarAtencion(){
    this.semCliente.release();
    }
     public void salir(String nombre){
   
    this.semSillon.release();
    }
}
