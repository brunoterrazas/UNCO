/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HamstersLocks;

/**
 *
 * @author Acer
 */
public class testHamsterLock {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PlatoLock plato=new PlatoLock(3);
        RuedaLock rueda=new RuedaLock();
        int max=10;
        HamsterHilo[] hamster=new HamsterHilo[max];
        for(int i=0;i<max;i++)
        {
            hamster[i]=new HamsterHilo("Hamster "+(i+1),plato,rueda);
            hamster[i].start();
        }
    }
    
}
