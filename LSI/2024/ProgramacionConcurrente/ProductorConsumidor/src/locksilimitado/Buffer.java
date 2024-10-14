package locksilimitado;

import lockslimitado.*;
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
 * @author Grupo L
 */
public class Buffer {

    private int cantidad; // mantiene la cantidad de elementos                               en el buffer
    private final int tamanio;  // tamaño del buffer
//para exclusión mutua y tener las condiciones asociadas
    private final Lock mutex = new ReentrantLock();
//para sincronizar los bolsaProd sobre mutex
    private final Condition bolsaProd;//esta lleno para el productor
//para sincronizar los bolsaCons sobre     mutex 
    private final Condition bolsaCons;//hay productos para el consumidor

    public Buffer(int tam) {
        this.cantidad = 0;
        this.tamanio = tam;
        this.bolsaProd = mutex.newCondition();
        this.bolsaCons = mutex.newCondition();
    }
    
    public Buffer() {
        this.cantidad = 0;
        this.tamanio=-1;
        this.bolsaProd = mutex.newCondition();
        this.bolsaCons = mutex.newCondition();
    }

    public void agregar(int id) throws InterruptedException {
        mutex.lock();
        try {
            if(this.tamanio!=-1)
            {
            //obtiene el lock
            //mientras la cantidad sea igual a la cantidad maxima
            while (cantidad == tamanio) {
                System.out.println("PRODUCTOR-" +id+" A ESPERAR!!!" );
                bolsaProd.await();  //espera bloqueado
            }
            }
            System.out.println("Productor-"+id + " pone un producto");
            //agrega un producto
            cantidad++;
            bolsaCons.signal();  //notifica a un consumidor que hay productos
          
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
                bolsaCons.await();  //espera bloqueado
            }
            cantidad--;
            System.out.println("Consumidor-"+id + " saco un producto");
            bolsaProd.signal(); //notifica a un productor para que agregue producto 
        } finally {
            mutex.unlock();
        }
    }
}
