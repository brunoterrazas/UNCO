/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje3;

/**
 *
 * @author Brunot
 */
public class testPasteleria {
  public static void main(String args[])
  {
    Pasteleria pasteleria=new Pasteleria(20,10);
    Empaquetador empaquetador1=new Empaquetador("Empaquetador 1",pasteleria);
    Empaquetador empaquetador2=new Empaquetador("Empaquetador 2",pasteleria);
    BrazoMecanico brazo=new BrazoMecanico("Brazo",pasteleria);
    empaquetador1.start();
    empaquetador2.start();
    brazo.start();
  }
}
