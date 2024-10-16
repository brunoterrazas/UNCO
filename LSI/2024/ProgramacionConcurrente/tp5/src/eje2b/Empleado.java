/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje2b;


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
        String nombre = this.getName();
        if (confiteria.sentarse(nombre)) {
            int opcion = valorRandom(3);  // 1: solo bebida, 2: solo comida, 3: ambas
            switch (opcion) {
                case 1:
                    confiteria.pedirBebida(nombre);
                    confiteria.beber(nombre);
                    break;
                case 2:
                    confiteria.pedirComida(nombre);
                    confiteria.comer(nombre);
                    break;
                case 3:
                      System.out.println(nombre + " pide que le sirvan bebida y comida");
                    confiteria.pedirBebida(nombre);
                    confiteria.beber(nombre);
                    confiteria.pedirComida(nombre);
                    confiteria.comer(nombre);
                    break;
            }
            confiteria.dejarAsiento(nombre);  // Al terminar, libera el asiento
        } else {
            System.out.println(nombre + " no pudo conseguir asiento");
        }
    }

    public int valorRandom(int max) {
        return (int) (Math.random() * max + 1);
    }
}
