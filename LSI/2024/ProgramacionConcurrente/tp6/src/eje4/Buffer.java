/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje4;

/**
 *
 * @author Brunot
 */
class Buffer {
    private final Espacio[] espacios;  // Arreglo de espacios (cada uno puede contener un producto)
    private int productosActuales;     // Contador de productos actuales en el buffer
    private int posicionAgregar;       // Índice para agregar el próximo producto
    private int posicionQuitar;        // Índice para quitar el próximo producto

    public Buffer(int capacidad) {
        this.espacios = new Espacio[capacidad];
        for (int i = 0; i < capacidad; i++) {
            espacios[i] = new Espacio();
        }
        this.productosActuales = 0;
        this.posicionAgregar = 0;
        this.posicionQuitar = 0;
    }

    // Método sincronizado para que el productor agregue un producto
    public synchronized void agregar(Object item, String productor) {
        while (productosActuales >= espacios.length) { // Espera si el buffer está lleno
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        // Agrega el producto en la posición correspondiente
        espacios[posicionAgregar].poner(item);
        System.out.println(productor + " agrega un item en el espacio " + posicionAgregar);
        posicionAgregar = (posicionAgregar + 1) % espacios.length; // Incrementa y ajusta el índice
        productosActuales++; // Actualiza la cantidad de productos

        notifyAll(); // Notifica a los consumidores que hay un producto disponible
    }

    // Método sincronizado para que el consumidor quite un producto
    public synchronized void sacar(String consumidor) {
        while (productosActuales <= 0) { // Espera si el buffer está vacío
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Quita el producto de la posición correspondiente
        Object item = espacios[posicionQuitar].quitar();
        System.out.println(consumidor + " quita un item del espacio " + posicionQuitar);
        posicionQuitar = (posicionQuitar + 1) % espacios.length; // Incrementa y ajusta el índice
        productosActuales--; // Actualiza la cantidad de productos

        notifyAll(); // Notifica a los productores que hay espacio disponible
    }
}