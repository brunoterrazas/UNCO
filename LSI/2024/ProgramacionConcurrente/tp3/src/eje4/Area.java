/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje4;

/**
 *
 * @author Acer
 */
class Area {
    private final String nombre;
    private int espaciosDisponibles;

    public Area(String nombre, int espaciosDisponibles) {
        this.nombre = nombre;
        this.espaciosDisponibles = espaciosDisponibles;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEspaciosDisponibles() {
        return espaciosDisponibles;
    }

    public synchronized boolean reservar(String visitante) {
        if (espaciosDisponibles > 0) {
            espaciosDisponibles--;
            System.out.println(visitante + " ha reservado un espacio en el área: " + nombre);
            return true;
        } else {
            System.out.println(visitante + " no pudo reservar en el área: " + nombre + " (No hay espacios disponibles)");
            return false;
        }
    }

    @Override
    public String toString() {
        return nombre + ": " + espaciosDisponibles + " espacios disponibles";
    }
}
