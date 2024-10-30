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
 * @author Brunot
 */
public class MedidorTemperatura extends Thread {

    private Sala sala;

    public MedidorTemperatura(Sala sala) {
        this.sala = sala;
    }

    @Override
    public void run() {
        try {
            int cont=0;
            while (cont<3) {
                int temperatura = valorRandom(21, 40);
                System.out.println("Temperatura:" + temperatura);
                Thread.sleep(6000);
                sala.notificarTemperatura(temperatura);
                cont++;
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(MedidorTemperatura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int valorRandom(int min, int max) {
        int randomNum = (int) (Math.random() * (max - min + 1)) + min;
        return randomNum;
    }
}
