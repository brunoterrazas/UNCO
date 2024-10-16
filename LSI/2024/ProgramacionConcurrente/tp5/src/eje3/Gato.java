/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje3;

/**
 *
 * @author Usuario
 */
public class Gato extends Thread {
    private Comedor comedor;
    public Gato(String nombre,Comedor com)
    {
      super(nombre);
      this.comedor=com;
    }
    @Override
    public void run()
    {
    
    }
}
