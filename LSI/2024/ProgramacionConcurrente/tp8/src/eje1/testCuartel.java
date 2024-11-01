/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje1;

/**
 *
 * @author Usuario
 */
public class testCuartel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int cantSoldados=30;
        ComedorCuartel comedor=new ComedorCuartel();
        Soldado[] soldados=new Soldado[cantSoldados];
        for (int i = 0; i < cantSoldados; i++) {
            soldados[i]=new Soldado("soldado-"+(i+1),comedor);
            soldados[i].start();
        }
        
    }
    
}
