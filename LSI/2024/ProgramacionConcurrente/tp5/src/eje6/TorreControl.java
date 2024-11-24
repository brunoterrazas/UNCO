/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje6;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class TorreControl {
    private Semaphore semAterrizar, semAterrizarEspera;
    private Semaphore semDespegar, semDespegarEspera;
    private int avionesAterrizando = 0, avionesDespegando = 0;
    private int avionesAterrizarEnEspera = 0, avionesDespegarEnEspera = 0;
    private boolean turnoDespegar = true;

    public TorreControl() {
        semAterrizar = new Semaphore(1, true);
        semAterrizarEspera = new Semaphore(0, true);
        semDespegar = new Semaphore(1, true);
        semDespegarEspera = new Semaphore(0, true);
    }

    public void solicitarAterrizar(String avion) {
        try {
            semAterrizar.acquire();
            avionesAterrizarEnEspera++;
            while (turnoDespegar || avionesAterrizando >= 10) {
                semAterrizarEspera.acquire();
            }
            System.out.println(avion + " aterrizando en la pista");
            avionesAterrizando++;
            avionesAterrizarEnEspera--;
            if (avionesAterrizando == 10) {
                turnoDespegar = true;
                avionesAterrizando = 0;
                semDespegarEspera.release(avionesDespegarEnEspera);
            }
            semAterrizar.release();

        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void solicitarDespegar(String avion) {
        try {
            semDespegar.acquire();
            avionesDespegarEnEspera++;
            while (!turnoDespegar || avionesDespegando >= 10) {
                semDespegarEspera.acquire();
            }
            System.out.println(avion + " despegando en la pista");
            avionesDespegando++;
            avionesDespegarEnEspera--;
            if (avionesDespegando == 10) {
                turnoDespegar = false;
                avionesDespegando = 0;
                semAterrizarEspera.release(avionesAterrizarEnEspera);
            }
            semDespegar.release();

        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
