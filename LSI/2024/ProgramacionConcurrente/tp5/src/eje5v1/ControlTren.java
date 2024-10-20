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
public class ControlTren extends Thread {
    private Tren tren;

    public ControlTren(String nombre, Tren tren) {
        super(nombre);
        this.tren = tren;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Controlando el tren...");
            tren.partir();  // Verificar si el tren puede partir
            try {
                Thread.sleep(2000);  // Simula el tiempo del recorrido
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
