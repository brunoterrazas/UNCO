/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Usuario
 */
public class SemaphoreControlado extends Semaphore{
    private final int maxPermisos; 
    public SemaphoreControlado(int i,int max, boolean orden) {
        super(i, orden);
        this.maxPermisos=max;
    }
    public SemaphoreControlado(int i,int max) {
        super(i);
        this.maxPermisos=max;
    }
    
    // Sobrescribir el método release para controlar que no se exceda el máximo de permisos
    @Override
    public void release() {
        try {
            if (this.availablePermits() < maxPermisos) {
                super.release();  // Solo libera si no se excede el límite máximo
               // System.out.println("Permiso liberado. Permisos disponibles: " + this.availablePermits());
            } else {
                System.out.println(Thread.currentThread().getName()+" no pudo ingresar a la piscina porque no hay espacio, esperando que salga alguien..");
             //   System.out.println("No se puede liberar más permisos. Permisos disponibles: " + this.availablePermits());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para liberar una cantidad específica de permisos (sobreescrito)
    @Override
    public void release(int permits) {
        try {
            if (this.availablePermits() + permits <= maxPermisos) {
                super.release(permits);  // Solo libera si no se excede el límite máximo
               // System.out.println(permits + " permisos liberados. Permisos disponibles: " + this.availablePermits());
            } else {
                System.out.println(Thread.currentThread().getName()+" no pudo ingresar a la piscina porque no hay espacio, esperando que salga alguien..");
           
                // System.out.println("No se pueden liberar " + permits + " permisos. Límite máximo de permisos excedido.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
