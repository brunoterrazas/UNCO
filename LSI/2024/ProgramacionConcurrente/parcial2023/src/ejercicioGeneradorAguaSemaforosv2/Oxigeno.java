/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejercicioGeneradorAguaSemaforosv2;



/**
 *
 * @author Brunot
 */
public class Oxigeno extends Thread {
 private Recipiente recipiente; 
 public Oxigeno(String id, Recipiente recipiente)
  { 
    super(id);
    this.recipiente=recipiente;
  }
 @Override 
  public void run()
  {
     recipiente.oListo(getName());
     recipiente.hacerAgua();
      System.out.println("termino"+getName());
  }
}
