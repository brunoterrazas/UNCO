/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejeSalaBaile;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class SalaBaile {

    private Semaphore semFila1, semFila2, semBailar;
    private Queue<Persona> fila1, fila2;
    private int turnoF1, turnoF2;
    private int cantF1, cantF2;

    public SalaBaile() {
        semFila1 = new Semaphore(1);
        semFila2 = new Semaphore(1);
        semBailar = new Semaphore(1);
        turnoF1 = 1;
        turnoF2 = 1;
        cantF1 = 0;
        cantF2 = 0;
        fila1 = new LinkedList<>();
        fila2 = new LinkedList<>();
    }

    public void ingresaFila1(Persona p) {
        try {
            semFila1.acquire();
            fila1.add(p);
            p.setTurno(turnoF1);
            cantF1++;
            System.out.println(p.getName() + " (f) ingresa a fila 1, turno: " + p.getTurno());
            turnoF1++;

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            semFila1.release();
        }

        formarPareja();
    }

    public void ingresaFila2(Persona p) {
        try {
            semFila2.acquire();
            fila2.add(p);
            p.setTurno(turnoF2);
            System.out.println(p.getName() + " (m) ingresa a fila 2, turno: " + p.getTurno());
            cantF2++;
            turnoF2++;
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            semFila2.release();
        }

        formarPareja();
    }

    private void formarPareja() {
        try {
            semBailar.acquire();

            if (!fila1.isEmpty() && !fila2.isEmpty() && cantF1 > 0 && cantF2 > 0) {
                // Emparejar a las primeras personas de cada fila
                Persona persona1 = fila1.poll();
                Persona persona2 = fila2.poll();
                System.out.println(persona1.getName() + " (" + persona1.getSexo() + ") baila con " + persona2.getName() + " (" + persona2.getSexo() + ")");
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            semBailar.release();
        }
    }
}
