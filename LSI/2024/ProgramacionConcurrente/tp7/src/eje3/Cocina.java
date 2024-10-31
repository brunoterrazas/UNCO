/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class Cocina {

    private int cantidadCarne;
    private int cantidadVerdura;
    private int cantidadPasta;
    private final Lock mutex;
    private final Condition CECocineroCarne;
    private final Condition CECocineroVerdura;
    private final Condition CECocineroPasta;

    public Cocina(int cantCarne, int cantVerdura, int cantPasta) {
        cantidadCarne = cantCarne;
        cantidadVerdura = cantVerdura;
        cantidadPasta = cantPasta;
        mutex = new ReentrantLock();
        CECocineroCarne = mutex.newCondition();
        CECocineroVerdura = mutex.newCondition();
        CECocineroPasta = mutex.newCondition();
    }

    public void prepararReceta(int cocinero, String nombre) {
        switch (cocinero) {
            case 1: //CocineroCarne
                try {
               mutex.lock();
                while (cantidadPasta <= 0 ||cantidadVerdura <= 0) {
                    
                        CECocineroCarne.await();
                    
                }
                
                    System.out.println(nombre+" prepara carne a la parrilla acompañada de pastas con un colchón de vegetales");
                    cantidadPasta--;
                    cantidadVerdura--;
                 
                } catch (InterruptedException ex) {
                        Logger.getLogger(Cocina.class.getName()).log(Level.SEVERE, null, ex);
                    }
                finally{
                   mutex.unlock();
                 }
                   
                break;
            case 2://Cocinero Verdura
                  try {
               mutex.lock();
                while (cantidadPasta <= 0 || cantidadCarne <= 0) {
                    
                        CECocineroCarne.await();
                    
                }
                
                    System.out.println(nombre+" prepara carne a la parrilla acompañada de pastas con un colchón de vegetales");
                    cantidadPasta--;
                    cantidadCarne--;
                 
                } catch (InterruptedException ex) {
                        Logger.getLogger(Cocina.class.getName()).log(Level.SEVERE, null, ex);
                    }
                finally{
                   mutex.unlock();
                 }
                   
                break;
            case 3://Cocinero Pasta
                 
                  try {
               mutex.lock();
                while (cantidadVerdura <= 0 || cantidadCarne <= 0) {
                    
                        CECocineroPasta.await();
                    
                }
                
                    System.out.println(nombre+" prepara carne a la parrilla acompañada de pastas con un colchón de vegetales");
                    cantidadVerdura--;
                    cantidadCarne--;
                 
                } catch (InterruptedException ex) {
                        Logger.getLogger(Cocina.class.getName()).log(Level.SEVERE, null, ex);
                    }
                finally{
                   mutex.unlock();
                 }
                break;

        }
    }
      public void terminarReceta(int cocinero, String nombre) {
        mutex.lock(); 
        try{
          switch (cocinero) {
             
            case 1: //Cocinero Carne
                    cantidadPasta++;
                    cantidadVerdura++;
                    
                break;
            case 2://Cocinero Verdura
                    cantidadPasta++;
                    cantidadCarne++;
                break;
            case 3://Cocinero Pasta
                    cantidadCarne++;
                    cantidadVerdura++;
                    
                break;

        } 
        }
        finally{
             System.out.println(nombre+" termino de preparar su receta");
            avisarCocinero();
        mutex.unlock();
        
        }
      }
        public void avisarCocinero()
        {
          if(cantidadPasta>0&&cantidadCarne>0)
                     {
                       CECocineroVerdura.signal();
                     }
                    else if(cantidadPasta>0&&cantidadVerdura>0)
                    {
                        CECocineroCarne.signal();
                    }
                    else if(cantidadCarne>0&&cantidadVerdura>0)
                    {
                        CECocineroPasta.signal();
                    }
        
    }

}
