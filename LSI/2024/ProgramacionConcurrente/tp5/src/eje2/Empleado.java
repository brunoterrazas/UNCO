/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje2;

/**
 *
 * @author Usuario
 */
public class Empleado extends Thread {
    private Confiteria confiteria;
    public Empleado(String nombre, Confiteria confiteria)
    {
        super(nombre);
        this.confiteria=confiteria;
    }
    @Override
    public void run(){
    String nombre;
    nombre=Thread.currentThread().getName();
    confiteria.sentarse(nombre);
    confiteria.pedirServicio(nombre);
    confiteria.comer(nombre);
    
    }
}
