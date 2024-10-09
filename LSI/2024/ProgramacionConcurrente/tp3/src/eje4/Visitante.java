/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje4;

/**
 *
 * @author Acer
 */
public class Visitante extends Thread {
    private final Parque parque;
    private final String area_solicitada;
  

    public Visitante(Parque parque, String nombre,String area) {
           super(nombre); 
           this.parque = parque;
           this.area_solicitada = area;
   
    }

    @Override
    public void run() {
        parque.reservarArea(area_solicitada);
    }
    
}
