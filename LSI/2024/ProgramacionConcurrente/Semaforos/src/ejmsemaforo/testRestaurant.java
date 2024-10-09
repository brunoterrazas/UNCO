/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejmsemaforo;

/**
 *
 * @author Usuario
 */
public class testRestaurant {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Comida comida = new Comida();

        // Creamos los hilos para el mozo y el cocinero
        MozoHilo mozo = new MozoHilo("mozo 1",comida);
        CocineroHilo cocinero = new CocineroHilo("cocinero 1",comida);

        // Iniciamos los hilos
        mozo.start();
        cocinero.start();
    }
    
}
