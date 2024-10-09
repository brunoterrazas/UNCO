/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje4;

import eje3.*;

/**
 *
 * @author Usuario
 */
public class RunnableEjemplo implements Runnable {
String nombre="";
public RunnableEjemplo(String str) {
nombre=str;
}
public String getNombre()
{
    return this.nombre;
}
public void run() {
for (int i = 0; i < 10 ; i++)
  System.out.println(i + " " + getNombre());
  System.out.println("Termina thread " + getNombre());
}
public static void main (String [] args) {
  RunnableEjemplo HiloMariaJose=new RunnableEjemplo("Maria Jose");
  RunnableEjemplo HiloJoseMaria=new RunnableEjemplo("Jose Maria");
  
  Thread hilo1 = new Thread(HiloMariaJose);
        Thread hilo2 = new Thread(HiloJoseMaria);

        hilo1.start();
        hilo2.start();
  System.out.println("Termina thread main");
}
}
