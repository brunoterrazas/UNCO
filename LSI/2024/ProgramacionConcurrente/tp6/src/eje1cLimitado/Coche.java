/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje1cLimitado;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class Coche extends Thread {

    private GestionaTrafico gestor;
    private String direccion;

    public Coche(String nombre, String direccion, GestionaTrafico gestor) {
        super(nombre);
        this.direccion = direccion;
        this.gestor = gestor;
    }

    @Override
    public void run() {
        try {

            if (direccion.equals("Norte")) {
                gestor.entrarCocheDelNorte(getName(),this.direccion);
                Thread.sleep(150); // Simula el tiempo en el puente
                gestor.salirCocheDelNorte(getName());

            } else {
                if (direccion.equals("Sur")) {
                    gestor.entrarCocheDelSur(getName(),this.direccion);
                    Thread.sleep(150); // Simula el tiempo en el puente
                    gestor.salirCocheDelSur(getName());
                }
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Coche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
