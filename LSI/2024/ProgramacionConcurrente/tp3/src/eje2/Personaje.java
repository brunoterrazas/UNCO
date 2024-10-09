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
public class Personaje implements Runnable {
    String nombre;
    Energia energia;
    Personaje(String nombre,Energia unaEnergia) {
        this.nombre=nombre;
        this.energia=unaEnergia;
    }
    public void run() {
        
    }
   
}
/*

    public void curar(){
     energia.modificarEnergia(3);
    }

*/