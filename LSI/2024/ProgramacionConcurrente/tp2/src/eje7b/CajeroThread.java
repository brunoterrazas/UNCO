/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje7b;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class CajeroThread extends Thread{

  private Cliente cliente;
    public CajeroThread(String nombre,Cliente cliente) {
      super(nombre);
      this.cliente=cliente;
    }
    @Override
    public void run()
    {
    
      long initialTime = System.currentTimeMillis();
       this.procesarCompra(initialTime);
    }


    public void procesarCompra(long timeStamp) {
        System.out.println("El cajero " + this.getName()
                + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + this.cliente.getNombre() + " EN ELTIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
        for (int i = 0; i < this.cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(this.cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1)
                    + "->Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
            System.out.println("El cajero " + this.getName() + " HA TERMINADO DE PROCESAR " +this.cliente.getNombre() + " EN EL TIEMPO: "
                    + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
        }

    }
    public void esperarXsegundos(int segundos){
        segundos=segundos*1000;
        try {
            Thread.sleep(segundos);
        } catch (InterruptedException ex) {
            Logger.getLogger(CajeroThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
