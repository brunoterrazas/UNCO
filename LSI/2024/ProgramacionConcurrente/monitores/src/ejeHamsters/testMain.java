/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejeHamsters;

/**
 *
 * @author Usuario
 */
public class testMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int maxPlato=3;
        Plato plato=new Plato(maxPlato);
        Rueda rueda=new Rueda();
        Thread[] hamsterHilo=new Thread[10];
        for(int i=0;i<hamsterHilo.length;i++)
        {
            hamsterHilo[i]=new Thread(new HamsterMonitor(plato,rueda,"Hamster"+(i+1)));
            hamsterHilo[i].start();
        }
        /*
        for(int i=0;i<hamsterHilo.length;i++)
        {
            
        }*/

        
    }
    
}
