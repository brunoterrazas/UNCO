/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje5;

/**
 *
 * @author Brunot
 */
public class testCanivales {
    public static void main(String[] args)
    {
      Olla olla=new Olla(10);
      int cantidadCanivales=15;
      Canival[] canivales=new Canival[cantidadCanivales];  
      for (int i = 0; i <cantidadCanivales ; i++) {
            canivales[i]=new Canival("canival-"+(i+1),olla);
            canivales[i].start();
        }
      Cocinero cocinero=new Cocinero(olla);
      cocinero.start();
    }
}
