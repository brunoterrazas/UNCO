/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje2;

/**
 *
 * @author Usuario
 */
public class Sanador extends Personaje {
     public Sanador(String nombre, Energia unaEnergia) {
        super(nombre, unaEnergia);
    }
     @Override
       public void run() {
    }
     public void curar(){
     energia.modificarEnergia(3);
    }
}
