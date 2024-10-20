/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje5v1;


/**
 *
 * @author Brunot
 */
public class Vendedor extends Thread {
    private Tren tren;

    public Vendedor(String nombre, Tren tren) {
        super(nombre);
        this.tren = tren;
    }

    @Override
    public void run() {
        while (true) {
            tren.entregarTicket(this.getName());  // Entregar tickets indefinidamente
            try {
                Thread.sleep(500);  // Simula el tiempo que tarda en vender un ticket
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}

