/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejmsemaforo;

/**
 *
 * @author Usuario
 */
public class MozoHilo extends Thread{
    private Comida comida;
    public MozoHilo(String nombre,Comida comida)
    {
        super(nombre);
        this.comida=comida;
    }
 public void run()
 {
   while(true)
   {
     this.comida.generarPedido();
     this.comida.pedirComida();
     this.comida.esperarComida();
   }
 }

    
}
