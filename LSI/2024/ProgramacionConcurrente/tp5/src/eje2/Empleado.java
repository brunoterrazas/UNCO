/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Empleado extends Thread {

    private Confiteria confiteria;

    public Empleado(String nombre, Confiteria confiteria) {
        super(nombre);
        this.confiteria = confiteria;
    }

    @Override
    public void run() {
        String nombre;
        nombre = this.getName();
        System.out.println(nombre + " esta intentando sentarse");
        if (confiteria.sentarse(nombre)) {
            
            int opcion = valorRandom(3); //1,2 o 3
            switch (opcion) {
                case 1://solo beber
                  System.out.println(nombre+" le pide al mozo solo una bebida");
     
                    confiteria.pedirBebida(nombre);
                    confiteria.beber(nombre);
                    break;
                case 2://solo comer
                    
                  System.out.println(nombre+" le pide al cocinero solo la comida");
                    confiteria.pedirComida(nombre);
                    confiteria.comer(nombre);
                    break;
                case 3://beber y comer
                    System.out.println(nombre+" le pide una bebida al mozo, luego le sirven la comida");
                    confiteria.pedirBebida(nombre);
                  
                    confiteria.comer(nombre);
                    
             
                    break;
            }

        } else {
            System.out.println(nombre + " no pudo conseguir lugar");
        }
         confiteria.dejarAsiento(nombre);
                  
    }

    public int valorRandom(int max) {
        return (int) (Math.random() * max + 1);
    }
}
