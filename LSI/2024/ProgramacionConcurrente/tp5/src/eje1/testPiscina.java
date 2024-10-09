/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class testPiscina {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int cantidadPersonas=15;
        int capacidadMax=5;
        GestorPiscina piscina=new GestorPiscina(cantidadPersonas,capacidadMax);
        Persona[] hiloPersona=new Persona[cantidadPersonas];
        for(int i=0;i<cantidadPersonas;i++)
        {
          hiloPersona[i]=new Persona(("persona"+(i+1)),piscina);
        }
        for(int i=0;i<cantidadPersonas;i++)
        {
          hiloPersona[i].start();
         }
        //ingresan uno tras otro
        
        for(int i=0;i<cantidadPersonas;i++)
        {
            try {
                hiloPersona[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(testPiscina.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("total ingresaron a la piscina: "+piscina.getCantIngresados());
    }
     public static void descansar(){
    
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(testPiscina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
