/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BarberoDormilonThread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class TestBarberiaThread {
    public static void main(String[] args){
    Barberia unaBarberia=new Barberia("BARBERIA EL DORMILON");
    Barbero unBarbero=new Barbero("fulgencio",unaBarberia);
    unBarbero.start();
    Cliente[] hiloCliente= new Cliente[15];
        for (int i = 0; i < hiloCliente.length; i++) {
            hiloCliente[i]=new Cliente(("Cliente-"+i),unaBarberia);
            hiloCliente[i].start();
        try {
            Thread.sleep((int)Math.random()*550);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestBarberiaThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
    
    }
    
}
