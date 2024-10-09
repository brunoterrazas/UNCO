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
public class Taxista extends Persona implements Runnable {
    private Taxi taxi;
    private int cantViajes;
    public Taxista(String nombre, Taxi taxi,int cantViajes)
    {
        super(nombre);
        this.taxi=taxi;
        this.cantViajes=cantViajes;
    }
    @Override
    public void run()
    {
       
        taxi.conducir(miNombre,cantViajes);
       
    }
    public void conducir()
    {
     System.out.println("Taxista descansando");
        
    }
}
