package eje8;

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
    private final Semaphore semLadoIzquierdo;
    private final Semaphore semLadoDerecho;   
    private final Semaphore semCruzar;        
    private final Semaphore semMutex;        
   

    public Cuerda(int max, int cantMontosI, int cantMonosD) {
        maximo = 5;                           // Máximo de babuinos en la cuerda
        semLadoIzquierdo = new Semaphore(1);  
        semLadoDerecho = new Semaphore(0);   
        semCruzar = new Semaphore(max);       
        semMutex = new Semaphore(1);         
        cantidadLadoIzq = cantMontosI;
        cantidadLadoDer = cantMonosD;
    }

    public void intentarCruzar(String lado, String nombre) {
        if ("Izquierdo".equals(lado)) {
            cruzarLadoIzquierdo(nombre);
           dejarCuerdaLadoIzquierdo(nombre);
        } else {
            cruzarLadoDerecho(nombre);
           dejarCuerdaLadoDerecho(nombre);
        }
    }

    /* Método para que los babuinos crucen al lado izquierdo */
    public void cruzarLadoIzquierdo(String nombre) {
        try {
            System.out.println(nombre + " esperando para cruzar al lado izquierdo");
            semLadoIzquierdo.acquire();  // Espera su turno para cruzar
            semCruzar.acquire();         // Asegura que no haya más de 5 babuinos en la cuerda a la vez
            semMutex.acquire();          // Mutex para modificar el contador

            cantidadLadoIzq--;
            System.out.println(nombre + " cruzando al lado izquierdo... Babuinos que quedan: " + cantidadLadoIzq);
            semMutex.release();
           

        } catch (InterruptedException ex) {
            Logger.getLogger(Cuerda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dejarCuerdaLadoDerecho(String nombre) {
        try {

            semMutex.acquire();
            System.out.println(nombre + " llegó al lado derecho");

            if (cantidadLadoDer == 0) {
                // Si todos los babuinos del lado derecho han cruzado, liberar al lado izquierdo
                semLadoIzquierdo.release();  // Despierta a los del lado derecho

            } else {
                // Si aún quedan babuinos del lado derecho, permitirles cruzar
                semLadoDerecho.release();
            }
            semMutex.release();
            semCruzar.release(); // Libera un lugar en la cuerda para otro babuino

        } catch (InterruptedException ex) {
            Logger.getLogger(Cuerda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dejarCuerdaLadoIzquierdo(String nombre) {

        try {
            semMutex.acquire();
            System.out.println(nombre + " llegó al lado izquierdo");
            if (cantidadLadoIzq == 0) {
                // Si todos los babuinos del lado izquierdo han cruzado, liberar al lado derecho
                semLadoDerecho.release();  // Despierta a los del lado derecho

            } else {
                // Si aún quedan babuinos del lado izquierdo, permitirles cruzar
                semLadoIzquierdo.release();
            }
            semMutex.release();
            semCruzar.release(); // Libera un lugar en la cuerda para otro babuino

        } catch (InterruptedException ex) {
            Logger.getLogger(Cuerda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* Método para que los babuinos crucen al lado derecho */
    public void cruzarLadoDerecho(String nombre) {
        try {
            System.out.println(nombre + " esperando para cruzar al lado derecho");
            semLadoDerecho.acquire();   // Espera su turno para cruzar
            semCruzar.acquire();        // Asegura que no haya más de 5 babuinos en la cuerda a la vez
            semMutex.acquire();      

            cantidadLadoDer--;
            System.out.println(nombre + " cruzando al lado derecho... Babuinos que quedan: " + cantidadLadoDer);
            semMutex.release();         
           
           
           

        } catch (InterruptedException ex) {
            Logger.getLogger(Cuerda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
