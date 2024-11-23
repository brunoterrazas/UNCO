/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejeEmbotelladora;

/**
 *
 * @author Brunot
 */
public class Embotellador extends Thread {
  private PlantaEmbotelladora planta;
  private String tipoBotella;  
  public Embotellador(String nom,PlantaEmbotelladora plantaEmb,String tipo)
  {
    super(nom);  
    planta=plantaEmb;
    tipoBotella=tipo;
  }
  @Override
  public void run()
  {
    while(true)
    {
        if(tipoBotella.equals("agua"))
        {
         planta.producirAgua(this.getName());
        }
        else{
         planta.producirVino(this.getName());
        
        }
    }
  }
}
