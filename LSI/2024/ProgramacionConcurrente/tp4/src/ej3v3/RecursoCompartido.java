/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej3v3;

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


    public RecursoCompartido() {
        sem1 = new Semaphore(1); // Inicialmente debloqueado
        sem2 = new Semaphore(0); // Inicialmente bloqueado
        sem3 = new Semaphore(0); // Inicialmente bloqueado
     
    }
    public void p1(String nombre){
          
            
    try{
        
                // Proceso P1
               
                    sem1.acquire();
                    Operacion_P1(nombre);
                    sem2.release();
              
                     
    }
    catch (InterruptedException e) { e.printStackTrace();
    }
      
    }
       public void p2(String nombre){
         
         try{
                // Proceso P2
         
                    sem3.acquire();
                    Operacion_P2(nombre);
                   sem1.release();
                
         }
        catch (InterruptedException e) { e.printStackTrace();
   
    }
       
        
       }
       public void p3(String nombre)
       {
       try{
                // Proceso P3
                sem2.acquire();
                Operacion_P3(nombre);
                sem3.release();
        }    
    
    catch (InterruptedException e) { e.printStackTrace();
    }
       
       }
        public void Operacion_P1(String nombre){
    System.out.println(nombre + " está ejecutando operaciones_P1");
      
    }
     public void Operacion_P2(String nombre){
    System.out.println(nombre + " está ejecutando operaciones_P2");
      
    }
      public void Operacion_P3(String nombre){
    System.out.println(nombre + " está ejecutando operaciones_P3");
      
    }
      
}
