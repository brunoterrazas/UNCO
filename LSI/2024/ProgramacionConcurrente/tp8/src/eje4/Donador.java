/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje4;

/**
 *
 * @author Brunot
 */
public class Donador extends Thread{
   private CentroHemoterapia centro;
   public Donador(String nombre,CentroHemoterapia centroh)
   {
     super(nombre);
     centro=centroh;
   }
   @Override
   public void run()
   {
     centro.donarSangre(getName());
   }
}
