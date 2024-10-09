/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejmsemaforo;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Comida {

    Semaphore sempedido;
    Semaphore semcomidaLista;

    public Comida() {
        sempedido = new Semaphore(0);
        semcomidaLista = new Semaphore(0);
    }

    public void generarPedido() {
        
              System.out.println(Thread.currentThread().getName()+" recepciona el pedido");
     
       
        
       }

    public void pedirComida() {
        System.out.println("Intenta el pedido");
         this.sempedido.release();
               System.out.println(Thread.currentThread().getName()+" realiza el pedido");
       }

    public void esperarComida() {
        try {
            this.semcomidaLista.acquire();
            System.out.println(Thread.currentThread().getName()+" espera la comida");
        } catch (InterruptedException ex) {
            Logger.getLogger(Comida.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    public void esperarPedido() {
      try {
            this.sempedido.acquire();
            System.out.println(Thread.currentThread().getName()+" esperar su pedido");
        } catch (InterruptedException ex) {
            Logger.getLogger(Comida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void prepararComida() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Comida.class.getName()).log(Level.SEVERE, null, ex);
        }
          System.out.println(Thread.currentThread().getName()+" pide comida");
       
    }
    public void entregarPedido() {
        this.semcomidaLista.release();
        System.out.println(Thread.currentThread().getName()+" entrega la comida");
    }
}
