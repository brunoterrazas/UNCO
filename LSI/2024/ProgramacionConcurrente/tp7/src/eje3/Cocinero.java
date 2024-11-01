/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class Cocinero extends Thread {

    private Cocina cocina;
    private String especialidad;

    public Cocinero(String nom,String especialidad,Cocina cocina) {
        super(nom);
        this.especialidad=especialidad;
        this.cocina=cocina;
    }
    @Override
    public void run()
    {
    try {
            
                    cocina.prepararReceta(especialidad, getName());
                    System.out.println(getName() + " cocinando....");
                    Thread.sleep(4000);
                    cocina.terminarReceta(especialidad, getName());
                 
        } catch (InterruptedException ex) {
            Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
