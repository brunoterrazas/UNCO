/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje8b;



/**
 *
 * @author Usuario
 */
public class TestMainBabuinos {
      public static void main(String[] args) {
        Cuerda cuerda = new Cuerda(10,15);  // Cuerda que soporta hasta 5 babuinos
        String[] lado = {"Izquierdo", "Derecho"};
        int cantidadBabuinos=15;
        Babuino[] babuinos=new Babuino[cantidadBabuinos];
       for (int i = 0; i < cantidadBabuinos; i++) {
           babuinos[i]=new Babuino("Babuino ",lado[1], cuerda);
           babuinos[i].start();
        }
       
    }
     public static int valorRandom(int max) {
        return (int) (Math.random() * max + 1);
    
      
      }
}
