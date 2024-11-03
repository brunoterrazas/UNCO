/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje3;

/**
 *
 * @author Brunot
 */
public class Pastel {
  private int peso;
  private String tipo;
    public Pastel(String tipo,int peso)
    {
        this.tipo=tipo;
       this.peso=peso;
    }    
    public int getPeso() {
        return peso;
    }
}
