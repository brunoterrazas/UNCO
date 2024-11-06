/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje5;

/**
 *
 * @author Brunot
 */
public class Canival extends Thread{
  private Olla olla;
  
    public Canival(String nombre,Olla olla)
  {
      super(nombre);
    this.olla=olla;
  }
  @Override
    public void run()
    {
      olla.comer(getName());
    }
}