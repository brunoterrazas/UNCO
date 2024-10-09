/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje1;

/**
 *
 * @author Usuario
 */
public class Persona extends Thread {
    private GestorPiscina piscina;
    public Persona(String nombre,GestorPiscina piscina)
    {
        super(nombre);
        this.piscina=piscina;
    }
    @Override
    public void run(){
        String nombre=Thread.currentThread().getName();
        piscina.ingresar(nombre);
        piscina.nadar(nombre);
        piscina.salir(nombre);
        
    }
}
