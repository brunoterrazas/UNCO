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
  public ControladorProduccion()
  {
    semElectrico=new Semaphore(1);
    semMecanico=new Semaphore(0);
  }
  public void llegaElectrico()
  {
      try {
          semElectrico.acquire();
      } catch (InterruptedException ex) {
          Logger.getLogger(ControladorProduccion.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  public void llegaMecanico()
  {
      try {
          semMecanico.acquire();
      } catch (InterruptedException ex) {
          Logger.getLogger(ControladorProduccion.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  public void sale()
  {
  
  }
  public void cambiarLineas()
  {
  
  }
}
