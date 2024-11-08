/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje2Semaforos;


/**
 *
 * @author Brunot
 */
public class testMain {
 public static void main(String[] args)
 {
    Observatorio observatorio=new Observatorio(50); 
    Persona[] visitantes=new Persona[40];
     for (int i = 0; i < 40; i++) {
         visitantes[i]=new Persona("Visitante-"+(i+1),"Visitante",observatorio);
         visitantes[i].start();
     }
     Persona[] investigadores=new Persona[10];
     for (int i = 0; i < 10; i++) {
         investigadores[i]=new Persona("Investigador-"+(i+1),"Investigador",observatorio);
         investigadores[i].start();
     }
     Persona[] mantenimiento=new Persona[10];
     for (int i = 0; i < 10; i++) {
         mantenimiento[i]=new Persona("Mantenimiento-"+(i+1),"Mantenimiento",observatorio);
         mantenimiento[i].start();
     }
     Persona sillaRuedas=new Persona("Silla Ruedas 1","SillaRuedas",observatorio);
     sillaRuedas.start(); 
 }
}
