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
 * @author Acer
 */
class RecursoCompartido {
    
    public Semaphore sem1;
    public Semaphore sem2;
    public Semaphore sem3;
    public Semaphore sem4;

    public RecursoCompartido() {
        sem1 = new Semaphore(0); // Inicialmente bloqueado
        sem2 = new Semaphore(1); // Inicialmente desbloqueado
        sem3 = new Semaphore(0); // Inicialmente bloqueado
        sem4 = new Semaphore(0); // Inicialmente bloqueado
    }
    public void Operacion_P1(){
    System.out.println(Thread.currentThread().getName() + " está ejecutando operaciones_P1");
        try {
            Thread.sleep(1000); // Simulando operaciones
        } catch (InterruptedException ex) {
            Logger.getLogger(RecursoCompartido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void Operacion_P2(){
    System.out.println(Thread.currentThread().getName() + " está ejecutando operaciones_P2");
        try {
            Thread.sleep(1000); // Simulando operaciones
        } catch (InterruptedException ex) {
            Logger.getLogger(RecursoCompartido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void Operacion_P3(){
    System.out.println(Thread.currentThread().getName() + " está ejecutando operaciones_P3");
        try {
            Thread.sleep(1000); // Simulando operaciones
        } catch (InterruptedException ex) {
            Logger.getLogger(RecursoCompartido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void Operacion_P4(){
    System.out.println(Thread.currentThread().getName() + " está ejecutando operaciones_P4");
        try {
            Thread.sleep(1000); // Simulando operaciones
        } catch (InterruptedException ex) {
            Logger.getLogger(RecursoCompartido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
