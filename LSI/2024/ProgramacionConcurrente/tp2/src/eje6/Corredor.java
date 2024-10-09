/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje6;

/**
 *
 * @author Usuario
 */
public class Corredor implements Runnable {

    private String nombre;
    private int distancia_recorrida;

    @Override
    public void run() {
        System.out.println("Inicia el hilo " + getNombre());

        for (int i = 1; i <= 25; i++) {
            this.darPaso(i);
        

        try {

            Thread.sleep(600);
            System.out.println("Descansa " + getNombre());
        } catch (InterruptedException exc) {
            System.out.println("Hay una interrupcion");
        }
        }
    }

    Corredor(String nombre) {
        this.nombre = nombre;
        this.distancia_recorrida = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDistancia_recorrida() {
        return distancia_recorrida;
    }

    public void setDistancia_recorrida(int distancia_recorrida) {
        this.distancia_recorrida = distancia_recorrida;
    }

    public void darPaso(int i) {

        this.setDistancia_recorrida(this.getDistancia_recorrida() + (int) (Math.random() * 10 + 1));
        System.out.println(this.getNombre() + " avanza un paso " + i + " , su distancia recorrida: " + getDistancia_recorrida());
    }

}
