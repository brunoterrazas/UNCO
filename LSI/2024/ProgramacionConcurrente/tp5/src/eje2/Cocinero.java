/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje2;

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
            //cocinar
               System.out.println("Descansando, inventando recetas");
            confiteria.prepararComida();
            System.out.println("El cocinero prepara la comida");

            //entregar comida
            confiteria.servirComida();
            System.out.println("El cocinero entrega la comida");
        }
    }

}
