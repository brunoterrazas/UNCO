/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje5;

/**
 *
 * @author Acer
 */
public class Vendedor  extends Thread{
       private Tren tren;
   public Vendedor(String nombre,Tren tren){
     super(nombre);
     this.tren=tren;
   } 
       @Override
   public void run()
   {
       while (tren.todosAtendidos()) {
            try {
                
                tren.partir();
                Thread.sleep(2000);  // Simula el tiempo de espera entre viajes
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("ControlTren ha terminado su operación.");
   }
}
