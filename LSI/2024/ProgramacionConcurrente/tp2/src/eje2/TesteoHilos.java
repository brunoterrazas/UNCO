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
public class TesteoHilos {
  public static void main (String[] args)
  {
   Thread miHilo= new MiEjecucion();
   miHilo.start();
   System.out.println("En el main");
  }  
}
