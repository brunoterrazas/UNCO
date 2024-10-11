/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lockslimitado;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
/**
 *
 * @author bruno.terrazas
 */
public class MainLockproductorConsumidor {

    public static void main(String[] args) {
        Buffer buf = new Buffer(5);
        Scanner lectura = new Scanner (System.in);
       // System.out.println("Ingrese cantidad de productores: ");

///int numeroProductores = lectura.nextInt();
int numeroProductores =1;
//   System.out.println("Ingrese cantidad de consumidores: ");
int numeroConsumidores =10;
//int numeroConsumidores = lectura.nextInt();
        
        Thread[] consumidor = new Thread[numeroProductores];
        Thread[] productor = new Thread[numeroConsumidores];
       
        for (int i = 0; i < numeroProductores; i++) {
            productor[i] = new Thread(new Productor(buf, (i+1)));
    
            productor[i].start();
  

        }

        for (int i = 0; i < numeroConsumidores; i++) {
            consumidor[i] = new Thread(new Consumidor(buf, (i+1)));
            consumidor[i].start();
         
        }

    }
}
