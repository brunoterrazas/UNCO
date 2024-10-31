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
            switch (especialidad) {
                case "Carne":
                    cocina.prepararReceta(1, getName());
                    System.out.println(getName() + " cocinando....");
                    Thread.sleep(4000);
                    cocina.terminarReceta(1, getName());
                    break;
                case "Verduras":
                    cocina.prepararReceta(2, getName());
                    System.out.println(getName() + " cocinando....");
                    cocina.terminarReceta(2, getName());
                    break;
                case "Pasta":
                    cocina.prepararReceta(3, getName());
                    System.out.println(getName() + " cocinando....");
                    cocina.terminarReceta(3, getName());
                    break;
                default:
                    break;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
