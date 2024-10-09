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
public class CriaturaOscura extends Personaje{
      public CriaturaOscura(String nombre, Energia unaEnergia) {
        super(nombre, unaEnergia);
    }
    public void drenar(){
    energia.modificarEnergia(-3);
    }
      @Override
      public void run() {
    }
}
