/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje2;

/**
 *
 * @author Brunot
 */
public class Sala {

    private Mesa[] mesas;
    private int cantidadMesas;

    public Sala(int cantMesas) {
        this.cantidadMesas = cantMesas;
        mesas = new Mesa[this.cantidadMesas];
        for (int i = 0; i < cantidadMesas; i++) {
            mesas[i] = new Mesa("Mesa-" + i + 1);
        }

    }

    public  synchronized void tomarMesa() {
     //Verifico si hay una mesa disponible
     
     //si no hay mesa disponible me bloqueo
     
     // si hay una mesa disponible-> ocupo la mesa
          
    }
    public synchronized void dejarMesa()
    {
      //dejo la mesa y notifico que hay una mesa disponible (quizas podria avisar cual mesa esta disponible) 
    }
}
