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
 * @author Usuario
 */
public class ProductoMecanico extends Producto implements Runnable {
   public ProductoMecanico(String nombre,String tipo,ControladorProduccion controlador)
    {
     super(nombre,tipo,controlador);
    }
    @Override
    public void run(){
       
           this.controladorProduccion.llegaMecanico();
             try {
                 this.controladorProduccion.sale(nombre,tipo);
                Thread.sleep(400);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProductoElectrico.class.getName()).log(Level.SEVERE, null, ex);
            }
       
           
        
    } 
}
