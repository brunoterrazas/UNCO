/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje2;

/**
 *
 * @author Brunot
 */
public class Mesa {
    private String nombre;
    private boolean disponible;
    public Mesa(String nom)
    {
       nombre=nom;
       disponible=true;
    }
    public synchronized void ocuparMesa()
    {
        disponible=false;
    }
    public synchronized void dejarMesa()
    {
        disponible=true;
    }
    
}
