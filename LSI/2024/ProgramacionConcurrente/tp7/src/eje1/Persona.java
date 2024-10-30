/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class Persona extends Thread{
  protected Sala sala;
  public Persona(String nombre,Sala sala)
  {
    super(nombre);
    this.sala=sala;
  }
  @Override
  public void run()
  {
      try {
          sala.entrarSala(getName());
          Thread.sleep(3000);
          sala.salirSala(getName(), false);
      } catch (InterruptedException ex) {
          Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
}
