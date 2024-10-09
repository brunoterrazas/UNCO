/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BarberoDormilonRunnable;

import BarberoDormilonThread.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Cliente extends Persona implements Runnable{
    private Barberia barberia;
    public Cliente(String nombre, Barberia barberia)
    {
      super(nombre);
      this.barberia=barberia;
    }
    private void caminarHastaBarberia()
    {
        System.out.println("Soy "+this.miNombre+" y estoy caminando hacia la barberia");
        try {
            Thread.sleep((int)Math.random()*100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void run()
    {
      this.caminarHastaBarberia();
      if(this.barberia.entrar(this.miNombre))
      {
        this.barberia.solicitarCorte(this.miNombre);
        System.out.println("---------Soy "+this.miNombre+" ya me atendieron");
        this.barberia.salir(this.miNombre);
      }
      else{
          System.out.println("-----Soy "+this.miNombre+", el barbero esta ocupado ");
      }
    }
}
