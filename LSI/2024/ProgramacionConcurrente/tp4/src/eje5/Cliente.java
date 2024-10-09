/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje5;

/**
 *
 * @author Usuario
 */
public class Cliente extends Thread{
     private CentroDeImpresion centro_impresion;
     private String tipoImpresora;
    public Cliente(String nombre,CentroDeImpresion centro,String tipoImpresora)
    {
      super(nombre);
      this.centro_impresion=centro;
      this.tipoImpresora=tipoImpresora;
    }
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ " quiere imprimir en impresora " + tipoImpresora);
        centro_impresion.imprimir(tipoImpresora);
    }
}
