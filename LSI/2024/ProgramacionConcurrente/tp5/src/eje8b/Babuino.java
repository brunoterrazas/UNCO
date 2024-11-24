/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje8b;



/**
 *
 * @author Brunot
 */
public class Babuino extends Thread {
    private Cuerda cuerda;
    private String lado;//lado del canion que va
    public Babuino(String nombre,String lado,Cuerda cuerda)
    {
        super(nombre);
        this.lado=lado;
        this.cuerda=cuerda;      
    }
    @Override
    public void run()
    {
        if(lado.equals("izquierdo"))
        {
         cuerda.cruzarLadoIzquierdo(this.getName());
        }else{
        cuerda.cruzarLadoDerecho(this.getName());
    
        }
       
    }
}
