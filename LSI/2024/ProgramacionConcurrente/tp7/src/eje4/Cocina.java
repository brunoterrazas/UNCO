/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje4;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class Cocina {


    private final Semaphore semCarne;
    private final Semaphore semVerduras;
    private final Semaphore semPasta;

    public Cocina(int cantCarne, int cantVerdura, int cantPasta) {

        semCarne = new Semaphore(cantCarne);
        semVerduras = new Semaphore(cantVerdura);
        semPasta = new Semaphore(cantPasta);
    }

    public void prepararReceta(String especialidad, String nombre) {

        try {
            System.out.println(nombre + " esperando para preparar su receta");
            switch (especialidad) {
                case "Carne": //CocineroCarne
                    semVerduras.acquire();
                    semPasta.acquire();

                    break;
                case "Verduras"://Cocinero Verdura
                    semCarne.acquire();
                    semPasta.acquire();

                    break;
                case "Pasta"://Cocinero Pasta
                    semCarne.acquire();
                    semVerduras.acquire();

                    break;

            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Cocina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void terminarReceta(String especialidad, String nombre) {

      
        switch (especialidad) {
            case "Carne": //CocineroCarne
                semVerduras.release();
                semPasta.release();

                break;
            case "Verduras"://Cocinero Verdura
                semCarne.release();
                semPasta.release();

                break;
            case "Pasta"://Cocinero Pasta
                semCarne.release();
                semVerduras.release();

                break;

        }
  System.out.println(nombre + " termina de para preparar su receta");
    }

}
