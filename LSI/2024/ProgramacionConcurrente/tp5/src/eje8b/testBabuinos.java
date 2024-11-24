/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje8b;



/**
 *
 * @author Brunot
 */
public class testBabuinos {

    public static void main(String[] args) {
        Cuerda cuerda = new Cuerda(5);  // Cuerda que soporta hasta 5 babuinos
        String[] lado = {"Izquierdo", "Derecho"};
        int cantidadBabuinosizq = 10;
        Babuino[] babuinosIzq = new Babuino[cantidadBabuinosizq];
        for (int i = 0; i < babuinosIzq.length; i++) {
            babuinosIzq[i] = new Babuino("Babuino I-" + (i + 1), "izquierdo", cuerda);
            babuinosIzq[i].start();
        }
        int cantidadBabuinosDer = 11;
        Babuino[] babuinosDer = new Babuino[cantidadBabuinosDer];
        for (int i = 0; i < babuinosDer.length; i++) {
            babuinosDer[i] = new Babuino("Babuino D-" + (i + 1), "derecho", cuerda);
            babuinosDer[i].start();
        }

    }

}
