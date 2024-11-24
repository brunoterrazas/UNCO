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


public class Cuerda {

private final int maximo; // Máximo de babuinos en la cuerda
    private int cantCruzando = 0;
    private int cantEsperandoIzq = 0, cantEsperandoDer = 0;
    private boolean turnoIzq = true;

    private final Semaphore semMutex;     
    private final Semaphore semEsperarIzq; //babuinos esperando en el lado izquierdo
    private final Semaphore semEsperarDer; //babuinos esperando en el lado derecho

    public Cuerda(int max) {
        this.maximo = max;
        this.semMutex = new Semaphore(1);
        this.semEsperarIzq = new Semaphore(0);
        this.semEsperarDer = new Semaphore(0);
    }

    public void cruzarLadoIzquierdo(String nombre) {
        try {
            semMutex.acquire();
            cantEsperandoIzq++;
            while (!turnoIzq || cantCruzando >= maximo) {
                semMutex.release();
                semEsperarIzq.acquire();
                semMutex.acquire();
            }
            cantEsperandoIzq--;
            cantCruzando++;
            System.out.println(nombre + " está cruzando al lado derecho. (Babuinos en la cuerda: " + cantCruzando + ")");
            semMutex.release();

            Thread.sleep(1000);

            semMutex.acquire();
            cantCruzando--;

            // Cambia el turno si no hay más babuinos cruzando y no hay más esperando
            if (cantCruzando == 0 && (cantEsperandoIzq == 0 || cantEsperandoDer > 0)) {
                turnoIzq = false;
                semEsperarDer.release(cantEsperandoDer); // Despierta babuinos del lado derecho
            }

            semMutex.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cruzarLadoDerecho(String nombre) {
        try {
            semMutex.acquire();
            cantEsperandoDer++;
            while (turnoIzq || cantCruzando >= maximo) {
                semMutex.release();
                semEsperarDer.acquire();
                semMutex.acquire();
            }
            cantEsperandoDer--;
            cantCruzando++;
            System.out.println(nombre + " está cruzando al lado izquierdo. (Babuinos en la cuerda: " + cantCruzando + ")");
            semMutex.release();

            Thread.sleep(1000);

            semMutex.acquire();
            cantCruzando--;

            // Cambia el turno si no hay más babuinos cruzando y no hay más esperando
            if (cantCruzando == 0 && (cantEsperandoDer == 0 || cantEsperandoIzq > 0)) {
                turnoIzq = true;
                semEsperarIzq.release(cantEsperandoIzq); // Despierta babuinos del lado izquierdo
            }

            semMutex.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}