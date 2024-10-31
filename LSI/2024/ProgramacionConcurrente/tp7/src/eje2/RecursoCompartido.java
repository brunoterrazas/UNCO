/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class RecursoCompartido {
   private int cantidadNotebooks;
    private int cantidadLibros;
    private Lock mutex;
    private Condition CEProgramadores;
  public RecursoCompartido(int cantNotebooks,int cantLibros)
  {
     cantidadNotebooks=cantNotebooks;
     cantidadLibros=cantLibros;
     mutex=new ReentrantLock(true);
     CEProgramadores=mutex.newCondition();
  }
  public void trabajar(String nombre)
  {
      mutex.lock();
       try {
           System.out.println(nombre+ " espera para tomar una notebook y un libro");
           while(cantidadLibros<=0||cantidadNotebooks<=0)
           {
             CEProgramadores.await();        
           }
           System.out.println(nombre+" toma una notebook y un libro");
            cantidadNotebooks--;
            cantidadLibros--;
       } catch (InterruptedException ex) {
           Logger.getLogger(RecursoCompartido.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
           mutex.unlock();
       }
  }
  public void dejarDeTrabajar(String nombre)
  {
     mutex.lock();
       try {
           System.out.println(nombre+" devuelve la notebook y el libro");
           cantidadNotebooks++;
           cantidadLibros++;
           CEProgramadores.signal();
       } finally {
           mutex.unlock();
       }
  }
}
