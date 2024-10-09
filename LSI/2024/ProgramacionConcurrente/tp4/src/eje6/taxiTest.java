/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class taxiTest {

    public static void main(String[] args) {
       
        Taxi taxi = new Taxi();
        int cantPasajeros=10;
        Taxista taxista = new Taxista("Taxista", taxi,cantPasajeros);
        Thread taxistaThread = new Thread(taxista);

        
        Thread[] pasajeroThread=new Thread[cantPasajeros];
        for(int i=0;i<cantPasajeros;i++){
             pasajeroThread[i]=new Thread(new Pasajero("Pasajero "+(i+1), taxi));

        }      
        for(int i=0;i<cantPasajeros;i++){
        pasajeroThread[i].start();
        }
       
        taxistaThread.start();
        }
    public static void descansar(){
    
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(taxiTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
