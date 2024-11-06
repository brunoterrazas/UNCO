/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje5v2;


/**
 *
 * @author Brunot
 */
public class Cocinero extends Thread{
  private Olla olla;
    public Cocinero(Olla olla)
  {
    this.olla=olla;
  }
    @Override
    public void run()
    { while(true)
    {
      olla.cocinar();
    }
    }
}
