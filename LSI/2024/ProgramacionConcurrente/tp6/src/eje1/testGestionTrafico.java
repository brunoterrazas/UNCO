/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje1;


/**
 *
 * @author Brunot
 */
public class testGestionTrafico {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        GestionaTrafico puente = new GestionaTrafico();
        int cantCoches=10;
        Coche[] coches = new Coche[cantCoches];
       String[] direccion = {"Norte", "Sur"};
        for (int i = 0; i < coches.length; i++) {
            String dir=direccion[valorRandom(2)-1];
            coches[i] = new Coche("Coche"+dir+"-" + (i + 1),dir , puente);
         
        }

        for (Coche coche : coches) {
            coche.start();
        }
    }
      public static int valorRandom(int max) {
        return (int) (Math.random() * max + 1);
    }
    
}
