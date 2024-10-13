/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje8;

/**
 *
 * @author Usuario
 */
public class Producto{
    protected String nombre;
    protected String tipo;
    protected ControladorProduccion controladorProduccion;
    public Producto(String nombre,String tipo,ControladorProduccion controlador)
    {
       this.nombre=nombre;
       this.tipo=tipo;
       this.controladorProduccion=controlador;
    }
}
