/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class Observatorio {

    private int capacidadMaxima, ingresados;
    private int capacidadActual;
    private Lock mutex;
    private int visitanteEnEspera, sillaRuedasEnEspera, investigadorEnEspera, mantenimientoEnEspera;
    private Condition CEVisitante;
    private Condition CESillaRuedas;
    private Condition CEInvestigador;
    private Condition CEMantenimiento;

    public Observatorio(int maximaCapacidad) {
        capacidadMaxima = maximaCapacidad;
        capacidadActual = maximaCapacidad;
        ingresados = 0;
        visitanteEnEspera = 0;
        sillaRuedasEnEspera = 0;
        investigadorEnEspera = 0;
        mantenimientoEnEspera = 0;
        mutex = new ReentrantLock();
        CEVisitante = mutex.newCondition();
        CESillaRuedas = mutex.newCondition();
        CEInvestigador = mutex.newCondition();
        CEMantenimiento = mutex.newCondition();
    }

    public void ingresar(String nombre, String tipo) {
       mutex.lock();
        switch (tipo) {
            case "sillaRuedas":
              while(hayEspacio(1))
              {
                try {
                this.sillaRuedasEnEspera++;
                CESillaRuedas.await();
                this.sillaRuedasEnEspera--;
                   } catch (InterruptedException ex) {
                Logger.getLogger(Observatorio.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
              ingresados++;
              this.capacidadActual=30;
                break;
            case "Visitante":
                break;
            case "Investigador":
                break;
            case "Mantenimiento":
                break;

        }

    }

    public boolean hayEspacio(int cantidad) {
        return ingresados+cantidad > capacidadActual;
    }

}
