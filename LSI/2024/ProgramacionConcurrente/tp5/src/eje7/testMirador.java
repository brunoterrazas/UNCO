/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje7;

/**
 *
 * @author Brunot
 */
public class testMirador {
    public static void main(String[] args) {
        Mirador mirador=new Mirador(50);
        int cantVisitantes=50;
        Visitante[] visitante=new Visitante[cantVisitantes];
        for (int i = 0; i < cantVisitantes; i++) {
            visitante[i]=new Visitante("visitante-"+(i+1),mirador);
             visitante[i].start();
        }
    }
    
}
