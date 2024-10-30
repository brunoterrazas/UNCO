/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Sala {

    private int capacidadMaxima;
    private int capacidadActual;
    private int personasIngresadas;
    private int cantidadJubilados=0;
    private int tUmbral = 30;//temperatura normal
    private final Lock mutex = new ReentrantLock(true);
    private final Condition CEPersonas;
    private final Condition CEJubilados;
    
    public Sala(int maxCapacidad) {
        capacidadMaxima = maxCapacidad;
        capacidadActual = maxCapacidad;
        CEPersonas = mutex.newCondition();
        CEJubilados = mutex.newCondition();
       
    }

    public void entrarSala(String persona) {
        mutex.lock();
        try {
            System.out.println(persona+", esperando para entrar a la sala");   
            while (personasIngresadas > capacidadActual||cantidadJubilados>0) {
              CEPersonas.await();
            }
            System.out.println(persona+", ingresó a la sala");
            personasIngresadas++;
        } catch (InterruptedException ex) {
            Logger.getLogger(Sala.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        mutex.unlock();
        }
        
    }

    public void entrarSalaJubilado(String jubilado) {
         mutex.lock();
        try {
             cantidadJubilados++;        
            while (personasIngresadas > capacidadActual) {
              CEJubilados.await();
            }
             personasIngresadas++;
        } catch (InterruptedException ex) {
            Logger.getLogger(Sala.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
             
        mutex.unlock();
        }
      
    }

    public void salirSala(String persona,boolean esJubilado) {
      mutex.lock();
        try {
            if(esJubilado)
                cantidadJubilados--;
            
            personasIngresadas--;
            System.out.println(persona+", se va de la sala");
            if(cantidadJubilados>0)
            {
              CEJubilados.signal();
            }
            else{
             CEPersonas.signalAll();
            }
            
        } finally {
            mutex.unlock();
        }
    }

    public void notificarTemperatura(int temperatura) {
        mutex.lock();
        try {
            if (temperatura> this.tUmbral) {
                capacidadActual = 35;
            } else {
                capacidadActual = capacidadMaxima;
            }
            System.out.println("Cantidad de personas"+personasIngresadas);
            System.out.println("Cantidad de jubilados"+cantidadJubilados);
            System.out.println("**Temperatura actual:"+temperatura);
              CEPersonas.signalAll();
            CEJubilados.signalAll();
        } finally {
            mutex.unlock();
        }
    }

}
