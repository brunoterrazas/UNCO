/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BarberoDormilonThread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Cliente extends Thread{
    private Barberia barberia;
    public Cliente(String nombre, Barberia barberia)
    {
      super(nombre);
      this.barberia=barberia;
    }
    private void caminarHastaBarberia()
    {
        System.out.println("Soy "+Thread.currentThread().getName()+" y estoy caminando hacia la barberia");
        try {
            Thread.sleep((int)Math.random()*100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void run()
    {
      this.caminarHastaBarberia();
      String nombreCliente=Thread.currentThread().getName();
      if(this.barberia.entrar(nombreCliente))
      {
        this.barberia.solicitarCorte(nombreCliente);
        System.out.println("---------Soy "+nombreCliente+" ya me atendieron");
        this.barberia.salir(nombreCliente);
      }
      else{
          System.out.println("-----Soy "+nombreCliente+", el barbero esta ocupado ");
      }
    }
}
