/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej3;

import java.util.logging.Level;
import java.util.logging.Logger;

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
       
        // Iniciar los procesos
        P1.start();
        try {
            P1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        P3.start();
        try {
            P3.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        P2.start();
        try {
            P2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
