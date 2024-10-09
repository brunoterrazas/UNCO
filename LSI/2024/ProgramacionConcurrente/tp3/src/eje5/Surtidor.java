/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje5;

/**
 *
 * @author Acer
 */
public class Surtidor {
    
    private int capacidadMaxima;
    private Auto[] autos;

    public Surtidor(int capacidadMaxima, Auto[] autos) {
        this.capacidadMaxima = capacidadMaxima;
        this.autos = autos;
    }
    public synchronized void cargarCombustible(String auto,int litros){
     if(this.verificarLitrosDisponible())
     { this.capacidadMaxima=this.capacidadMaxima-litros;
     
       
     }
     else{
         System.out.println("El "+auto+" no pudo cargar combustible");
     }
    }
    public boolean verificarLitrosDisponible(){
        
        return capacidadMaxima>0;
    }
    
}
