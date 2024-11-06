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
public class Persona extends Thread {
    private String tipo;
    private Observatorio observatorio;
    public Persona(String nombre,String tipo,Observatorio elObservatorio)
    {
      super(nombre);
      this.tipo=tipo;
      this.observatorio=elObservatorio;
    }
    @Override
    public void run()
    {
        
    }
}
