/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje3;

/**
 *
 * @author Brunot
 */
public class Empaquetador extends Thread {
   private Pasteleria pasteleria;
    public Empaquetador(String nom,Pasteleria past)
   {
      super(nom);
      pasteleria=past;
    
   }
   @Override
 public void run() {
    while (true) {
        int pesoPastel = pasteleria.tomarPastel(getName());
        
        if (pesoPastel == -1) {
            System.out.println(getName() + " ha terminado su trabajo. No hay más pasteles.");
            break;  // Detiene el ciclo si no hay más pasteles
        }

        System.out.println("El peso del pastel empaquetado es " + pesoPastel);
        pasteleria.soltarPastel(pesoPastel);
    }
}
}
