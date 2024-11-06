/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje4;

/**
 *
 * @author Brunot
 */
public class testProductorConsumidoMM {
  public static void main(String[] args)
  {
      int cantProductores=5;
       int cantConsumidores=5;
      Buffer buffer=new Buffer(10);
      Thread[] hilosProductores=new Thread[cantProductores];
      for (int i = 0; i < cantProductores; i++) {
          hilosProductores[i]=new Thread(new Productor(buffer,"productor-"+(i+1)));
          hilosProductores[i].start();
      }
      Thread[] hilosConsumidores=new Thread[cantProductores];
      for (int i = 0; i < cantProductores; i++) {
          hilosConsumidores[i]=new Thread(new Consumidor(buffer,"consumidor-"+(i+1)));
          hilosConsumidores[i].start();
      }
  }
}
