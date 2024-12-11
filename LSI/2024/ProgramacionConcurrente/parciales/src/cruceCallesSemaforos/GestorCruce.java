/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruceCallesSemaforos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class GestorCruce {

    private Semaphore semNorte;
    private Semaphore semOeste;
    private Semaphore semMutexCambio;
    private boolean esTurnoNorte;

    public GestorCruce() {
        semNorte = new Semaphore(1);
        esTurnoNorte = true;
        semOeste = new Semaphore(0);
        semMutexCambio = new Semaphore(1);
    }

    public void llegaNorte(String coche) {
        try {
            semNorte.acquire();
            System.out.println("circula "+coche);
            semNorte.release();
        } catch (InterruptedException ex) {
        }
    }

    public void llegaOeste(String coche) {
        try {
            semOeste.acquire();
             System.out.println("circula "+coche);
            semOeste.release();
        } catch (InterruptedException ex) {
        }
    }

    public void sale(String coche, String lado) {
        System.out.println("Sale  " + coche + " del lado " + lado);

    }
        public void cambiarSemaforos() {
        try {
            semMutexCambio.acquire();

            if (esTurnoNorte) {
                semNorte.acquire();
                this.esTurnoNorte = false;
                semOeste.release();        
            } else {
                semOeste.acquire();
                this.esTurnoNorte = true;
                semNorte.release();       

            }
            System.out.println("Cambiando a semaforo: " + (esTurnoNorte == false ? "Norte" : "Oeste"));
        } catch (InterruptedException ex) {

        } finally {
            semMutexCambio.release();  
        }

    }
}
