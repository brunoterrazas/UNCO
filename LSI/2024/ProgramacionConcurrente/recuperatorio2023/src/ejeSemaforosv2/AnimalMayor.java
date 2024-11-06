/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejeSemaforosv2;



/**
 *
 * @author Brunot
 */
public class AnimalMayor extends Thread{
    private Casa casa;
    public AnimalMayor(Casa casa)
    {
      this.casa=casa;
    }
    @Override
    public void run()
    { 
       while(true)
       {
      casa.servirComida();
       }
    }
    
}
