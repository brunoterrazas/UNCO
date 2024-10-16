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
public class Mozo extends Thread {
    private Confiteria confiteria;
    public Mozo(String nombre, Confiteria confiteria)
    {
        super(nombre);
        this.confiteria=confiteria;
    }
    @Override
    public void run(){
        while(confiteria.getContador()<confiteria.getCantidad())
        {
            System.out.println("El mozo esta descansando, inventando nuevas recetas");
             System.out.println("El mozo toma el pedido");
            confiteria.tomarPedido();
             System.out.println("El mozo sirve la bebida");
           
            confiteria.servirBebida();
        }
       }
}
