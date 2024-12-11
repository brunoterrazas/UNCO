/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruceCallesSemaforos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class Coche extends Thread {

    private GestorCruce gestorCruce;
    private String lado;

    public Coche(String nom, String lado, GestorCruce gestor) {
        super(nom);
        gestorCruce = gestor;
        this.lado = lado;
    }

    @Override
    public void run() {
   
            if (lado.equals("Norte")) {

                gestorCruce.llegaNorte(getName());
                
                gestorCruce.sale(getName(), lado);

            } else {
                gestorCruce.llegaOeste(getName());
                
                gestorCruce.sale(getName(), lado);

            }
        

    }
}
