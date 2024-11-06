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
public class testCentroHemoterapia {
     public static void main(String[] args)
     {
        CentroHemoterapia centro=new CentroHemoterapia(4,9);
        int cantidadDonantes=20;
        Donador[] donadores=new Donador[cantidadDonantes];
        for (int i = 0; i < cantidadDonantes; i++) {
             donadores[i]=new Donador("Donador-"+(i+1),centro);
             donadores[i].start();  
        }
     }
}
