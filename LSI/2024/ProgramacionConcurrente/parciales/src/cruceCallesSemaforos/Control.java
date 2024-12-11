/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cruceCallesSemaforos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class Control extends Thread {
   private GestorCruce gestorCruce;
    public Control(String nom,GestorCruce gestor)
    {
      super(nom);
      gestorCruce=gestor;
    }
   @Override
    public void run()
    {
      while(true)
      {
          try {
              Thread.sleep(400);
              gestorCruce.cambiarSemaforos();
              
          } catch (InterruptedException ex) {
              Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    } 
}

