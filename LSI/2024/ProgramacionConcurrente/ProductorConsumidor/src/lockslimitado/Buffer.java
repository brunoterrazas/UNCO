package lockslimitado;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Usuario
 */
public class Buffer {

    private int cantidad; // mantiene la cantidad de elementos                               en el buffer
    private final int tamanio;  // tamaño del buffer
//para exclusión mutua y tener las condiciones asociadas
    private final Lock mutex = new ReentrantLock();
//para sincronizar los noLLeno sobre mutex
    private final Condition noLLeno;//esta lleno para el productor
//para sincronizar los noVacio sobre     mutex 
    private final Condition noVacio;//hay productos para el consumidor

    public Buffer(int tam) {
        this.cantidad = 0;
        this.tamanio = tam;
        this.noLLeno = mutex.newCondition();
        this.noVacio = mutex.newCondition();
    }

    public void agregar(int id) throws InterruptedException {
        mutex.lock();
        try {
            //obtiene el lock
            //mientras la cantidad sea igual a la cantidad maxima
            while (cantidad == tamanio) {
                System.out.println("PRODUCTOR-" +id+" A ESPERAR!!!" );
                noLLeno.await();  //espera bloqueado
            }
            System.out.println("Productor-"+id + " pone un producto");
            //agrega un producto
            cantidad++;
            noVacio.signal();  //notifica a un consumidor que hay productos
          
        } finally {
            mutex.unlock();
        }
    }

    public void sacar(int id) throws InterruptedException {
        mutex.lock();
        try {
            //obtiene el lock
            //mientras no haya productos
            while (cantidad == 0) {
                System.out.println("CONSUMIDOR"+ id+" A ESPERAR!!");
                noVacio.await();  //espera bloqueado
            }
            cantidad--;
            System.out.println("Consumidor-"+id + " saco un producto");
            noLLeno.signal(); //notifica a un productor para que agregue producto 
        } finally {
            mutex.unlock();
        }
    }
}
