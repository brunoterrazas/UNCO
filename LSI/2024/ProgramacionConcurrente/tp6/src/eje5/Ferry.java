/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class Ferry {
    private int capacidad;
    private int espaciosDisponibles;
    private boolean viajando;
    private int espaciosOcupados;
    public Ferry(int capacidadMaxima)
    {
      capacidad=capacidadMaxima;
      espaciosDisponibles=capacidadMaxima;
      viajando=false;
      espaciosOcupados=0;
    }
    public synchronized void subir(int espacio,String nombre) {
            System.out.println(nombre+" esperando para abordar");
       while(espaciosDisponibles<espacio||viajando)
       {
           try {
               wait();//esperar mientras no hay espacio en el ferry
           
           } catch (InterruptedException ex) {
               Logger.getLogger(Ferry.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       espaciosDisponibles-=espacio;
       espaciosOcupados+=espacio;
       System.out.println(nombre+" esta a bordo del ferry, ocupa "+espacio);
          
       
    }
    public synchronized void empezarViaje()
    {
      // Espera hasta que el ferry esté lleno
        while (!viajando && espaciosOcupados < capacidad && espaciosDisponibles > 0) {
            try {
                System.out.println("Esperando que terminen de abordar el Ferry");
                         wait();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

        if (espaciosOcupados > 0) { // Inicia el viaje solo si hay al menos un ocupante
            viajando = true;
            System.out.println("El ferry empieza su viaje");
               System.out.println("Cantidad de espacio disponibles "+espaciosDisponibles);
                System.out.println("Cantidad de espacio ocupados "+espaciosOcupados);
            
        }
    }
    public synchronized void terminarViaje()
    {
        if(viajando)
        {
      espaciosDisponibles=capacidad;
      espaciosOcupados=0;
      viajando=false;
      notifyAll();
        System.out.println("El ferry llega al destino");
        }
        }
}
