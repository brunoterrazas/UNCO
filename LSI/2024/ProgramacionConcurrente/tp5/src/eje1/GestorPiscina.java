/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class GestorPiscina {
    private SemaphoreControlado semIngresar;
    private int cantIngresados=0;

    public int getCantIngresados() {
        return cantIngresados;
    }
    public GestorPiscina(int cant,int max)
    {                                     //(ini,max,orden)    
      semIngresar=new SemaphoreControlado(cant,max,true);
    }
    public void ingresar(String persona){
        try {
            System.out.println(persona + " intentando ingresar a la piscina.");
           
            semIngresar.acquire(); // Bloquea hasta que haya un permiso disponible
            System.out.println(persona + " está dentro de la piscina.");
            cantIngresados++;
        } catch (InterruptedException ex) {
            Logger.getLogger(GestorPiscina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void salir(String persona){
     System.out.println(persona+" salió de la piscina");
        semIngresar.release();
       
    }
    public void nadar(String persona){
        try {
            System.out.println(persona+" nadando en la pileta");
            Thread.sleep(6000);
        } catch (InterruptedException ex) {
            Logger.getLogger(GestorPiscina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
