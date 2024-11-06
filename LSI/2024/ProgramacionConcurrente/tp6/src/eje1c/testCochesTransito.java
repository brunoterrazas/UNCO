/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje1c;



/**
 *
 * @author Brunot
 */
public class testCochesTransito {
public static void main(String[] args) {
        GestionaTrafico puente = new GestionaTrafico();
        int cantCoches=30;
        Coche[] coches = new Coche[cantCoches];
       String[] direccion = {"Norte", "Sur"};
        for (int i = 0; i< 15; i++) {
            String dir=direccion[0];
            coches[i] = new Coche("Coche"+dir+"-" + (i + 1),dir , puente);
            coches[i].start();
        }
        for (int i = 15; i < coches.length; i++) {
            String dir=direccion[1];
            coches[i] = new Coche("Coche"+dir+"-" + (i + 1),dir , puente);
            coches[i].start();
        }

    }
}
