/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje4a;

/**
 *
 * @author Usuario
 */
public class Vendedor extends Thread {
    private Tren tren;

    public Vendedor(String nombre, Tren tren) {
        super(nombre);
        this.tren = tren;
    }

    @Override
    public void run() {
        while (!tren.todosAtendidos()) {
            tren.entregarTicket(this.getName());
        }
        System.out.println("Vendedor ha terminado su operación.");
    }
}
