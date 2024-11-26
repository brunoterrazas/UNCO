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
       
          carro.subir(getName());
          //System.out.println(getName()+"termino");
    }
}
