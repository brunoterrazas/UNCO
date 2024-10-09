/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ThreadHamster extends Thread {
    private Hamaca hamaca;
    private Plato plato;
    private Rueda rueda;
    ThreadHamster(String nombre,Hamaca hamaca,Plato plato,Rueda rueda)
    {
        super(nombre);
        this.hamaca=hamaca;
        this.plato=plato;
        this.rueda=rueda;
    }
    public void run(){
       
        while(true)
        {
            int opc=valorRandom(3);
            switch(opc){
                case 1:
                        this.hamaca.descansar(this.getName());
                    break;
                case 2:
                     this.plato.comer(this.getName());
                    break;
                case 3:
                     this.rueda.correr(this.getName());
                    break;
             
            }
        
           
           
        }
    
    }
       public int valorRandom(int max) {
        return (int) (Math.random() * max + 1);
    }
}
