/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje2;

/**
 *
 * @author Acer
 */
public class Main {
    public static void main(String[] args) {
        // Crear el recurso compartido que incluye los semáforos
        RecursoCompartido recurso = new RecursoCompartido();

        // Crear los procesos
        Proceso P1 = new Proceso("P1", recurso, 1);
        Proceso P2 = new Proceso("P2", recurso, 2);
        Proceso P3 = new Proceso("P3", recurso, 3);
        Proceso P4 = new Proceso("P4", recurso, 4);

        // Iniciar los procesos
        P1.start();
        P2.start();
        P3.start();
        P4.start();
    }
}
