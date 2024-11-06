/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
class Espacio {
    private Object producto;

    public Espacio() {
        this.producto = null;
    }

    public synchronized void poner(Object item) {
        this.producto = item;
    }

    public synchronized Object quitar() {
        Object temp = this.producto;
        this.producto = null;
        return temp;
    }

    public synchronized boolean hayProducto() {
        return producto != null;
    }
}


