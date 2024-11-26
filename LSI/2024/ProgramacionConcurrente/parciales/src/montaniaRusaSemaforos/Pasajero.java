/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package montaniaRusaSemaforos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class Pasajero extends Thread {
  private MontaniaRusa carro;
    public Pasajero(String nom,MontaniaRusa m)
  {
     super(nom);
     carro=m;
  }
  @Override
    public void run()
    {
        while(true)
        {
          carro.subir(getName());
        }
    }
}
