/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje8;

/**
 *
 * @author Acer
 */
public class Main {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cliente 1", new int[]{2, 2, 1, 5,
            2, 3});
        Cliente cliente2 = new Cliente("Cliente 2", new int[]{1, 3, 5, 1,
            1});
        CajeroRunnable cajero1 = new CajeroRunnable("Cajero 1", cliente1);
        CajeroRunnable cajero2 = new CajeroRunnable("Cajero 2", cliente2);
        // Tiempo inicial de referencia
        Thread hilocajero1 = new Thread(cajero1);
        Thread hilocajero2 = new Thread(cajero2);
        hilocajero1.start();
        hilocajero2.start();
    }

    public Cliente[] cargarClientes(int cant_clientes) {

        Cliente clientes[] = new Cliente[cant_clientes];
        for (int i = 0; i < cant_clientes; i++) {
            clientes[i] = new Cliente(("Cliente " + (i + 1)), new int[]{valorRandom(4), valorRandom(5), valorRandom(6), valorRandom(7), valorRandom(8)});
        }
        return clientes;
    }

    public int valorRandom(int max) {
        return (int) (Math.random() * max + 1);
    }
}
