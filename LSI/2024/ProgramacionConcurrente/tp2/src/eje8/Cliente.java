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
public class Cliente {
    private String nombre;
    private int[] carritoCompra;

    public Cliente(String nombre, int[] carritoCompra) {
        this.nombre = nombre;
        this.carritoCompra = carritoCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[] getCarroCompra() {
        return carritoCompra;
    }

    public void setCarroCompra(int[] carritoCompra) {
        this.carritoCompra = carritoCompra;
    }
    
}
