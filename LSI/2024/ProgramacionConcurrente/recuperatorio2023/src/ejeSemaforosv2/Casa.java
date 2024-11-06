/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejeSemaforosv2;


import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class Casa {
  private Semaphore semComer;
  private Semaphore semServirComida;
  private Semaphore semMutex;
  private Semaphore semSentarse;
  private int cantidadBanquitos;
  private int cantSentados;
    public Casa(int banquitos)
  {
    semSentarse=new Semaphore(banquitos);
    semComer=new Semaphore(banquitos);//libero la misma cantidad para que coman al mismo tiempo
    semServirComida=new Semaphore(0);
    semMutex=new Semaphore(1);
    cantidadBanquitos=banquitos;
    cantSentados=0;
  
  }
    public void sentarse(String animal)
    {
      try {
          semSentarse.acquire();
          System.out.println(animal+" se sienta para comer");
          this.pedirComida(animal);
      } catch (InterruptedException ex) {
          Logger.getLogger(Casa.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    public void pedirComida(String animal)
    {  
      try {
          semServirComida.release();
          System.out.println(animal+" avisa al animalMayor para que le sirva la comida");
          semMutex.acquire();
          cantSentados++;
          semMutex.release();
          semComer.acquire();
          
      } catch (InterruptedException ex) {
          Logger.getLogger(Casa.class.getName()).log(Level.SEVERE, null, ex);
      }
      
    }
    public void servirComida()
    {
      try {
          semServirComida.acquire();
          System.out.println("Le sirve la comida y el avisa que puede comer");         
          semComer.release();
          System.out.println("cantidad sentados: "+cantSentados);
      } catch (InterruptedException ex) {
          Logger.getLogger(Casa.class.getName()).log(Level.SEVERE, null, ex);
      }
        
    }
    
    public void terminarComer(String animal)
    {
      try {
          semSentarse.release();
          semMutex.acquire();
          cantSentados--;
          semMutex.release();
          System.out.println(animal+" terminó de comer");
      } catch (InterruptedException ex) {
          Logger.getLogger(Casa.class.getName()).log(Level.SEVERE, null, ex);
      }
      
    }
    
     
}
