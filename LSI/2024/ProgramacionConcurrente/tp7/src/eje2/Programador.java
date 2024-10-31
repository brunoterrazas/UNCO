/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class Programador extends Thread {
    private final RecursoCompartido recursoCompartido;
    public Programador(String name,RecursoCompartido recurso)
    {
      super(name);
      recursoCompartido=recurso;
    }
    @Override
    public void run()
    {
        try {
                
            recursoCompartido.trabajar(getName());
            Thread.sleep(4000);
            recursoCompartido.dejarDeTrabajar(getName());
        } catch (InterruptedException ex) {
            Logger.getLogger(Programador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
