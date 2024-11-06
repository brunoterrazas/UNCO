/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje8b;

import eje8.*;

/**
 *
 * @author Brunot
 */
public class testBabuinos {
    public static void main(String[] args) {
        Cuerda cuerda = new Cuerda(10,15);  // Cuerda que soporta hasta 5 babuinos
        String[] lado = {"Izquierdo", "Derecho"};
        int cantidadBabuinos=25;
        Babuino[] babuinos=new Babuino[cantidadBabuinos];
        for (int i = 0; i < 5; i++) {
           babuinos[i]=new Babuino("Babuino " + (i + 1),lado[valorRandom(2)-1], cuerda);
           babuinos[i].start();
        }
       
    }
     public static int valorRandom(int max) {
        return (int) (Math.random() * max + 1);
    }
}
