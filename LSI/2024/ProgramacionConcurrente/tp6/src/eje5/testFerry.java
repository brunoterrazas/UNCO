/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje5;

/**
 *
 * @author Brunot
 */
public class testFerry {
  public static void main(String[] args)
  {
     int cantAutos=5;
     int cantPasajeros=10;
     Ferry ferry=new Ferry(20);
     ConductorFerry conductor=new ConductorFerry(ferry);
     Automovil[] autos=new Automovil[cantAutos];
     Pasajero[] pasajeros=new Pasajero[cantPasajeros];
      for (int i = 0; i < cantAutos; i++) {
          autos[i]=new Automovil("Automovil-"+(i+1),ferry);
          autos[i].start();
      }   
      for (int i = 0; i < cantPasajeros; i++) {
          pasajeros[i]=new Pasajero("Pasajero-"+(i+1),ferry);
          pasajeros[i].start();
      }
      conductor.start();
  }  
  
  
}
