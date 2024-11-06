package eje8b;

/**
 *
 * @author Brunot
 */

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

// Clase Cuerda
public class Cuerda {

    private final int maximo; // Máximo de babuinos que pueden estar en la cuerda
    private int cantidadLadoIzq;
    private int cantidadLadoDer;
    private final Semaphore semCruzar;        // Limita la cantidad de babuinos en la cuerda
    private final Semaphore semMutex;         // Mutex para proteger la cantidad de babuinos en la cuerda
    private boolean cruzandoIzquierda = true; // Controla la dirección actual que está cruzando

    public Cuerda(int cantIzq, int cantDer) {
        maximo = 5;                           // Máximo de babuinos en la cuerda
        semCruzar = new Semaphore(maximo);    // Permite hasta 5 babuinos a la vez en la cuerda
        semMutex = new Semaphore(1);          // Para proteger el acceso a los contadores
        cantidadLadoIzq = cantIzq;
        cantidadLadoDer = cantDer;
    }

    public void intentarCruzar(String lado, String nombre) {
        if ("Izquierdo".equals(lado)) {
            cruzarLadoIzquierdo(nombre);
            dejarCuerda(nombre, lado);
        } else {
            cruzarLadoDerecho(nombre);
            dejarCuerda(nombre, lado);
        }
    }

    /* Método para que los babuinos crucen al lado izquierdo */
    public void cruzarLadoIzquierdo(String nombre) {
        try {
            semMutex.acquire(); // Proteger acceso a cantidadLadoIzq

            while (!cruzandoIzquierda || cantidadLadoDer > 0) {
                semMutex.release();
                Thread.sleep(100);  // Espera hasta que puedan cruzar los babuinos del lado izquierdo
                semMutex.acquire();
            }

            semCruzar.acquire();  // Asegura que no haya más de 5 babuinos en la cuerda
            cantidadLadoIzq--;
            System.out.println(nombre + " cruzando al lado izquierdo... Babuinos que quedan: " + cantidadLadoIzq);
            
            semMutex.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Cuerda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* Método para que los babuinos crucen al lado derecho */
    public void cruzarLadoDerecho(String nombre) {
        try {
            semMutex.acquire(); // Proteger acceso a cantidadLadoDer

            while (cruzandoIzquierda || cantidadLadoIzq > 0) {
                semMutex.release();
                Thread.sleep(100);  // Espera hasta que puedan cruzar los babuinos del lado derecho
                semMutex.acquire();
            }

            semCruzar.acquire();  // Asegura que no haya más de 5 babuinos en la cuerda
            cantidadLadoDer--;
            System.out.println(nombre + " cruzando al lado derecho... Babuinos que quedan: " + cantidadLadoDer);

            semMutex.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Cuerda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* Método para liberar la cuerda */
    public void dejarCuerda(String nombre, String lado) {
        try {
            semCruzar.release();  // Libera un lugar en la cuerda para otro babuino
            System.out.println(nombre + " ha terminado de cruzar al lado " + lado);

            semMutex.acquire();
            if (cantidadLadoIzq == 0 && cantidadLadoDer == 0) {
                // Si no quedan babuinos cruzando de ninguno de los dos lados, cambiar la dirección
                cruzandoIzquierda = !cruzandoIzquierda;
            }
            semMutex.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Cuerda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
