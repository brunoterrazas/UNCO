/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej3v3;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class TestMain {
    public static void main(String[] args) {
        // Crear el recurso compartido que incluye los semáforos
        RecursoCompartido recurso = new RecursoCompartido();
        // Crear los procesos
        Thread P1 = new Thread(new Proceso1("P1", recurso));
        Thread P2 = new Thread(new Proceso2("P2", recurso));
        Thread P3 = new Thread(new Proceso3("P3", recurso));
        // Iniciar los procesos
        P1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        P3.start();
         try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        P2.start();
         try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
