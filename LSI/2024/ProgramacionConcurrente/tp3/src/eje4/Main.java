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
public class Main {
      public static void main(String[] args)
    {
    

        Area[] areas = {
            new Area("Montaña Rusa", 2),
            new Area("Casa del Terror", 2),
            new Area("Parque Acuático", 4)
        };

        Parque parque = new Parque(areas);

  Visitante visitante1 = new Visitante(parque, "Visitante 1", "Montaña Rusa");
        Visitante visitante2 = new Visitante(parque, "Visitante 2", "Montaña Rusa");
        Visitante visitante3 = new Visitante(parque, "Visitante 3", "Casa del Terror");
        Visitante visitante4 = new Visitante(parque, "Visitante 4", "Montaña Rusa");
        Visitante visitante5 = new Visitante(parque, "Visitante 5", "Parque Acuático");
        Visitante visitante6 = new Visitante(parque, "Visitante 6", "Parque Acuático");

        // Iniciar los hilos de los visitantes
        visitante1.start();
        visitante2.start();
        visitante3.start();
        visitante4.start();
        visitante5.start();
        visitante6.start();
      
        try {
            visitante1.join();
            visitante2.join();
            visitante3.join();
            visitante4.join();
            visitante5.join();
            visitante6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       
        parque.mostrarEstado();
    }
    
    
    
}
