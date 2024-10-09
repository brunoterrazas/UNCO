/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejeHamsters;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class HamsterMonitor implements Runnable {
    private Plato comida;
    private Rueda ejercicio;
    private String miNombre;
    public HamsterMonitor(Plato comida,Rueda elEjercicio,String nombre)
    {
      this.comida=comida;
      this.ejercicio=elEjercicio;
      this.miNombre=nombre;
    }
    @Override
    public void run(){
       while(true)
       {
        comida.empezarAComer(miNombre);
            try {
                Thread.sleep((long) Math.random()*3500);
            } catch (InterruptedException ex) {
                Logger.getLogger(HamsterMonitor.class.getName()).log(Level.SEVERE, null, ex);
            }
            comida.terminarDeComer(miNombre);
            ejercicio.rodar(miNombre);
       }
    }
}
