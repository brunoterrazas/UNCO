/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje2v;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Brunot
 */
public class Sala {

   
    private int cantidadMesas;

    public Sala(int cantMesas) {
        this.cantidadMesas = cantMesas;
       

    }

    public  synchronized void tomarMesa(String nombre) {
        
        System.out.println(nombre+"Intenta conseguir una mesa"); 
    //Verifico si hay una mesa disponible
      while(!hayMesaLibre())
      {//si no hay mesa libre
          try {
              wait(); //espera hasta que desocupen una mesa
          } catch (InterruptedException ex) {
              Logger.getLogger(Sala.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      // si hay una mesa disponible-> ocupo la mesa
      this.cantidadMesas--;
        System.out.println(nombre+" ocupa una mesa");      
    }
    public synchronized boolean hayMesaLibre()
    {
     return cantidadMesas>0;
    }
    public synchronized void dejarMesa(String nombre)
    {
        System.out.println(nombre+" deja la mesa, y se va");
      this.cantidadMesas++;
      //notifica que hay una mesa disponible
      notify();
    }
}
