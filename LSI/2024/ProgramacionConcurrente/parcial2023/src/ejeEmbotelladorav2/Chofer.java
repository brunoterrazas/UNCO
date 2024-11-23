/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejeEmbotelladorav2;



/**
 *
 * @author Brunot
 */
public class Chofer extends Thread {
  private PlantaEmbotelladora planta;
  
  public Chofer(String nom,PlantaEmbotelladora plantaEmb)
  {
    super(nom);  
    planta=plantaEmb;
   
  }
  @Override
  public void run()
  {
    while(true)
    {  
        planta.repartirCajas();
    }
  }
}
