/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje4;



/**
 *
 * @author Brunot
 */
public class testCocina {
  public static void main(String[] args)
  {
    Cocina cocina=new Cocina(1,1,1);
    Cocinero cocineroCarne=new Cocinero("Cocinero Carne","Carne",cocina);
    Cocinero cocineroVerduras=new Cocinero("Cocinero Verduras","Verduras",cocina);
    Cocinero cocineroPasta=new Cocinero("Cocinero Pasta","Pasta",cocina);
    cocineroCarne.start();
    cocineroVerduras.start();
    cocineroPasta.start();
  }
}
