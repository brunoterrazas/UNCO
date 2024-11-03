/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje3;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public final class Pasteleria {

    private int pesoMaximo;
    private int pesoCajaActual;
    private Semaphore semLlenar;
    private Semaphore semCambiarCaja;
    private Semaphore semCajaNueva;
    private Semaphore semMutex;
    private LinkedList<Pastel> pastelesHorneados;

    public Pasteleria(int maximoPeso, int cantidadPasteles) {
        pesoMaximo = maximoPeso;
        pesoCajaActual = 0;//caja vacia
        pastelesHorneados = new LinkedList<>();
        semLlenar = new Semaphore(1);
        semMutex=new Semaphore(1);
        semCajaNueva = new Semaphore(0);
        semCambiarCaja = new Semaphore(0);
        //Horneando pasteles
        for (int i = 0; i < cantidadPasteles; i++) {
            int tipo = valorRandom(1, 3);
            switch (tipo) {
                case 1:
                    pastelesHorneados.add(new Pastel("Pastel A-" + (i + 1), 6));
                    break;
                case 2:
                    pastelesHorneados.add(new Pastel("Pastel B-" + (i + 1), 4));

                    break;
                case 3:
                    pastelesHorneados.add(new Pastel("Pastel C-" + (i + 1), 3));

                    break;
            }
        }
    }

    public LinkedList<Pastel> getPastelesHorneados() {
        return pastelesHorneados;
    }

    /*hace que el proceso que lo invoca quede bloqueado hasta que la caja que estaba
siendo llenada es retirada por el brazo auxiliar . Requiere que haya una caja en la zona de
relleno.*/
    public void retirarCaja()//brazo
    {
        try {
            System.out.println("El brazo mecanico espera para cambiar la caja");

            semCambiarCaja.acquire();
           
        } catch (InterruptedException ex) {
            Logger.getLogger(Pasteleria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
 hace que el proceso que lo invoca quede bloqueado hasta que el brazo auxiliar
coloque una caja vacía en el área de relleno. No debe haber ninguna caja en la zona de
rellenado.
     */
    public void reponerCaja()//brazo
    {
        System.out.println("El peso actual de la caja :" + pesoCajaActual);
        System.out.println("Se cambia la caja por una vacia");
        pesoCajaActual = 0;
        semCajaNueva.release();
       
    }

    /*
 provoca que el proceso que lo invoca quede bloqueado hasta que
el empaquetador toma el pastel más cercano al mostrador, indicando Peso el peso del mismo.
     */
    public int tomarPastel(String nombre)//Empaquetador
    {
        int peso = 0;
        try //Empaquetador
        {
            System.out.println(nombre + ", esperando para agregar un pastel a la caja");
            semLlenar.acquire();
           
            //toma un pastel
           // Verifica si hay pasteles disponibles antes de intentar tomar uno
         semMutex.acquire();
         if (!pastelesHorneados.isEmpty()) {
            // Toma el peso del primer pastel en la lista
          peso = pastelesHorneados.getFirst().getPeso();
        } else {
            System.out.println("No hay más pasteles disponibles para empaquetar.");
            peso = -1;  // Devuelve un valor especial si no hay pasteles
        }
         semMutex.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Pasteleria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return peso;
    }

    /*
 provoca que el proceso que lo invoca quede bloqueado hasta que el
empaquetador suelte el pastel que acaba de tomar en la caja del área de relleno. Es necesario
que haya una caja en el área de rellenado, que el robot empaquetador en cuestión tenga un
pastel y que la inclusión de ese pastel en la caja no haga sobrepasar el peso máximo permitido.
     */
    public void soltarPastel(int pesoPastel) {//empaquetador
        try {
            semMutex.acquire();
            //agrega el pastel a la caja
            if ((pesoCajaActual + pesoPastel) > this.pesoMaximo) {
               
                    System.out.println("El peso del pastel "+pesoPastel+",sobrepaso el peso maximo"+this.pesoMaximo);
                    semCambiarCaja.release();
                    semCajaNueva.acquire();
               
            }
            
             if (!pastelesHorneados.isEmpty()) {
            pastelesHorneados.removeFirst();//quita el pastel del mostrador
            pesoCajaActual += pesoPastel;
            System.out.println("Agregando pastel, peso actual de la caja:"+pesoCajaActual);
             }
            semMutex.release();
            semLlenar.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Pasteleria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int valorRandom(int min, int max) {
        int randomNum = (int) (Math.random() * (max - min + 1)) + min;
        return randomNum;
    }
}
