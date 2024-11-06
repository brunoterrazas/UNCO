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
public class Pasajero extends Thread {
    private Tren tren;

    public Pasajero(String nombre, Tren tren) {
        super(nombre);
        this.tren = tren;
    }

    @Override
    public void run() {
        tren.comprarTicket(this.getName());
        tren.subir(this.getName());
    }
}
