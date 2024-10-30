/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje5;

/**
 *
 * @author Brunot
 */
public class Automovil extends Thread {
     private Ferry ferry;
    public Automovil(String nombre,Ferry ferry)
    {
       super(nombre);
       this.ferry=ferry;
    }
    @Override
    public void run()
    {
       ferry.subir(6,getName());
    }
}