/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package montaniaRusaSemaforos;

/**
 *
 * @author Brunot
 */
public class Control extends Thread {
  private MontaniaRusa carro;
    public Control(String nom,MontaniaRusa m)
  {
     super(nom);
     carro=m;
  }
  @Override
    public void run()
    {
    while(true)
     {
         carro.darVuelta();
     }
    }
}