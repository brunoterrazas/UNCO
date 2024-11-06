/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje2;

/**
 *
 * @author Brunot
 */
public class Estudiante extends Thread {
    private Sala sala;
 public Estudiante(String nom, Sala sala)
 {
   super(nom);
   this.sala=sala;
 }
  @Override
  public void run()
  { 
    sala.tomarMesa();
    //simular un tiempo
    sala.dejarMesa();
  }
}
