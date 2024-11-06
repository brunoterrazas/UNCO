/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje2b;


/**
 *
 * @author Acer
 */
public class Cocinero extends Thread {
    private Confiteria confiteria;

    public Cocinero(String nombre, Confiteria confiteria) {
        super(nombre);
        this.confiteria = confiteria;
    }

    @Override
    public void run() {
        while (confiteria.getContador()<confiteria.getCantidad()) {
            System.out.println("El cocinero está descansando, inventando recetas");
            confiteria.prepararComida();  
         
        }
           //System.out.println("el cocinero termino de atender);
    }
}

