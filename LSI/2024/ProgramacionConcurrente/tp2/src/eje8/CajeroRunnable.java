/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje8;



import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class CajeroRunnable  implements Runnable{

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
  private String nombre;
  private Cliente cliente;
    public CajeroRunnable(String nombre,Cliente cliente) {
     this.nombre=nombre;
      this.cliente=cliente;
    }
    @Override
    public void run()
    {
    
      long initialTime = System.currentTimeMillis();
       this.procesarCompra(initialTime);
    }


    public void procesarCompra(long timeStamp) {
        if(this.cliente!=null)
        {
        System.out.println("El cajero " + this.getNombre()
                + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + this.cliente.getNombre() + " EN ELTIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
        for (int i = 0; i < this.cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(this.cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1)
                    + "->Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
            System.out.println("El cajero " + this.getNombre() + " HA TERMINADO DE PROCESAR " +this.cliente.getNombre() + " EN EL TIEMPO: "
                    + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
        }
        this.cliente=null;
        
        }else System.out.println("No hay ningun cliente");

    }
    public void esperarXsegundos(int segundos){
        segundos=segundos*1000;
        try {
            Thread.sleep(segundos);
        } catch (InterruptedException ex) {
            Logger.getLogger(CajeroRunnable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
