/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje3;

/**
 *
 * @author Acer
 */
public class Main {
   public static void main(String[] args)
    {
        
        int max=10;
        ThreadHamster[] hamsters=new ThreadHamster[max];
        Hamaca hamaca=new Hamaca();
        Plato plato=new Plato();
        Rueda rueda=new Rueda();
    for(int i=0;i<max;i++){
        hamsters[i]=new ThreadHamster("Hamster "+(i+1),hamaca,plato,rueda);
    }
    
       for(int i=0;i<hamsters.length;i++){
       hamsters[i].start();
    }
    
   
    
    }  

  
}
