/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package montaniaRusaSemaforos;

/**
 *
 * @author Brunot
 */
public class testMontaniaRusa {
    public static void main(String[] args) {
        
        MontaniaRusa carro=new MontaniaRusa(10,4);
        Control control=new Control("Control",carro);
        control.start();
     int cantidadPasajero=50;
     Pasajero[] pasajero=new Pasajero[cantidadPasajero];
        for (int i = 0; i < pasajero.length; i++) {
            pasajero[i]=new Pasajero("pasajero -"+(i+1),carro);
            pasajero[i].start();
        }
    
    }
   
}
