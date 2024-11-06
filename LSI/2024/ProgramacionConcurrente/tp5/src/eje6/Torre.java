/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje6;

/**
 *
 * @author Brunot
 */
public class Torre extends Thread{
    private Pista pista;
    public Torre(String nom,Pista laPista)
    {
     super(nom);
     pista=laPista;
    }
    @Override
    public void run()
    {
    
    }
}
