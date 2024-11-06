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
public class ControlTren extends Thread {
    private Tren tren;

    public ControlTren(String nombre, Tren tren) {
        super(nombre);
        this.tren = tren;
    }

    @Override
    public void run() {
while (!tren.todosAtendidos()) {
            try {
                tren.partir();
                Thread.sleep(2000);  

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("ControlTren ha terminado su operación.");
    }
}
