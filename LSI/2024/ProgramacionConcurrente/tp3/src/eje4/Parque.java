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
public class Parque {
    private Area[] areas;

    public Parque(Area[] areas) {
    this.areas=areas;
    }
    public void reservarArea(String area) {
        int i = 0;
        while (i < areas.length) {
            Area a = areas[i];
            if (a.getNombre().equals(area)) {
                a.reservar(Thread.currentThread().getName());
                return; 
            }
            i++;
        }
        // Si se recorrió toda la lista y no se encontró el área
        System.out.println(Thread.currentThread().getName() + " no pudo reservar en el área: " + area);
    }
    public void mostrarEstado() {
        System.out.println("Estado actual de las áreas:");
        for (Area area : areas) {
            System.out.println(area);
        }
    }
}
