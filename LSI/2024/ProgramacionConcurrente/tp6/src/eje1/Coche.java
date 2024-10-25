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

        if (direccion.equals("Norte")) {
            gestor.entrarCocheDelNorte(getName(), this.direccion);

            gestor.salirCocheDelNorte(getName());

        } else {
            if (direccion.equals("Sur")) {
                gestor.entrarCocheDelSur(getName(), this.direccion);

                gestor.salirCocheDelSur(getName());
            }
        }

    }
}
