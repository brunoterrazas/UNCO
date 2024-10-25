/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje1;


/**
 *
 * @author Acer
 */
public class testGestionTrafico {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        GestionaTrafico puente = new GestionaTrafico();
        Coche[] coches = new Coche[10];

        for (int i = 0; i < 5; i++) {
            coches[i] = new Coche("CocheNorte " + (i + 1), "Norte", puente);
            coches[i + 5] = new Coche("CocheSur " + (i + 1), "Sur", puente);
        }

        for (Coche coche : coches) {
            coche.start();
        }
    }
    
}
