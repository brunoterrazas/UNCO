/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje8;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ControladorProduccion {
  private Semaphore semElectrico;
  private Semaphore semMecanico;
  private Semaphore semMutexCambio;
  private boolean lineaElectricaActiva;
  private int turno;//1 electrico, 2 mecanico

    public int getTurno() {
        return turno;
    }
  public ControladorProduccion()
  {
      int randomNum = valorRandom(1,2);//(max-min+1)+min   
    semElectrico=new Semaphore(1);
    lineaElectricaActiva=true;
    semMecanico=new Semaphore(0);
    semMutexCambio=new Semaphore(1);  
        
    
    turno=1;//1 o 2
  }
  public void llegaElectrico()
  {
      try {
          semElectrico.acquire();
          semElectrico.release();
      } catch (InterruptedException ex) {
          Logger.getLogger(ControladorProduccion.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  public void llegaMecanico()
  {
      try {
          semMecanico.acquire();
           
           semMecanico.release();
      } catch (InterruptedException ex) {
          Logger.getLogger(ControladorProduccion.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  public void sale(String prod,String tipo)
  {
      System.out.println("Sale del area de ensamblado "+prod+" de la linea"+tipo);
  
  }
  //1 electrico, 2 mecanico
  public void cambiarLineas()
  {
        try {
            semMutexCambio.acquire();  // Exclusión mutua para cambiar las líneas
           
            if(lineaElectricaActiva)
            {
              semElectrico.acquire();// Bloquear la línea eléctrica
              this.lineaElectricaActiva=false;
                semMecanico.release();        // Activar la línea mecánica
            }else{
               semMecanico.acquire();// Bloquear la línea mecánica
              this.lineaElectricaActiva=true;
               semElectrico.release();       // Activar la línea eléctrica

            }
            System.out.println("Cambiando a la línea: " + (turno == 1 ? "eléctrica" : "mecánica"));
        } catch (InterruptedException ex) {
            Logger.getLogger(ControladorProduccion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            semMutexCambio.release();  // Liberar el control del cambio de líneas
        }
    
  }
  public int valorRandom(int min, int max)
  {
  int randomNum = (int)(Math.random() * (max - min + 1)) +min;
  return randomNum;
  }
}
