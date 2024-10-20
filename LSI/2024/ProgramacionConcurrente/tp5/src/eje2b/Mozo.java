/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje2b;



/**
 *
 * @author Usuario
 */
public class Mozo extends Thread {
    private Confiteria confiteria;

    public Mozo(String nombre, Confiteria confiteria) {
        super(nombre);
        this.confiteria = confiteria;
    }

    @Override
    public void run() {
        while (confiteria.getContador()<confiteria.getCantidad()) {
            System.out.println("El mozo está descansando");
            confiteria.servirBebida();  // Sirve bebidas cuando los empleados lo solicitan
        }
        System.out.println("mozo me fui");
    }
}

