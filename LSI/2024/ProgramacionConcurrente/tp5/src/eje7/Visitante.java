/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje7;

/**
 *
 * @author Usuario
 */
public class Visitante extends Thread {
    Mirador mirador;
    public Visitante(String nom,Mirador m)
    {
      super(nom);
      mirador=m;
    }
    @Override
    public void run()
    {
      mirador.subirEscalera(getName());
      mirador.bajarTobogan(getName());
    }
}
