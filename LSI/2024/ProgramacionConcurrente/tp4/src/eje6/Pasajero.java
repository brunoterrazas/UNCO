/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje6;

/**
 *
 * @author Usuario
 */
public class Pasajero extends Persona implements Runnable{
   private Taxi taxi;
    public Pasajero(String nombre,Taxi taxi)
    {
        super(nombre);
        this.taxi=taxi;
    }
    @Override
    public void run()
    {
        System.out.println(this.miNombre+" caminando");
        taxi.pedirTaxi(miNombre);
        taxi.pagar(miNombre);
        System.out.println("se bajo"+miNombre);
       // return;
       
    }
}
