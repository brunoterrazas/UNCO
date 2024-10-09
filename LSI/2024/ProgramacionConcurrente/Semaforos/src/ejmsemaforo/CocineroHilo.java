/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejmsemaforo;
import java.util.concurrent.Semaphore;
/**
 *
 * @author Usuario
 */
public class CocineroHilo extends Thread {
    private Comida comida;
    public CocineroHilo(String nombre,Comida comida){
        super(nombre);
        this.comida=comida;
    }
    public void run()
 { 
     while(true)
   {
     this.comida.esperarPedido();
     this.comida.prepararComida();
     this.comida.entregarPedido();
   }
 }

}
