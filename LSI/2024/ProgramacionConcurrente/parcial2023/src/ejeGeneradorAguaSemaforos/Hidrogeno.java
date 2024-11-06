/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejeGeneradorAguaSemaforos;

/**
 *
 * @author Brunot
 */
public class Hidrogeno extends Thread {
 private Recipiente recipiente; 
 public Hidrogeno(String id, Recipiente recipiente)
  { 
    super(id);
    this.recipiente=recipiente;
  }
 @Override 
  public void run()
  {
    recipiente.hListo(getName());
    
      System.out.println("termino"+getName());
  }
}
