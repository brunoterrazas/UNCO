/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class ConductorFerry extends Thread {

    private Ferry ferry;

    public ConductorFerry(Ferry ferry) {
        this.ferry = ferry;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(7000);
                System.out.println("Esperando que terminen de abordar el Ferry");
                ferry.empezarViaje();
                System.out.println("............Viajando...........");
                Thread.sleep(7000);
                ferry.terminarViaje();

            } catch (InterruptedException ex) {
                Logger.getLogger(ConductorFerry.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
