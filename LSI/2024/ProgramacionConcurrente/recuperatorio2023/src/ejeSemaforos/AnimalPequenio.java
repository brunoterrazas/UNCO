/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejeSemaforos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class AnimalPequenio extends Thread{
    private Casa casa;
    public AnimalPequenio(String nombre,Casa casa)
    {
        super(nombre);
        this.casa=casa;
    }
    @Override
    public void run()
    {
        while(true)
        {
        try {
            System.out.println(getName()+" jugando....");
            casa.sentarse(getName());
            System.out.println(getName()+" Comiendo....");
            Thread.sleep(600);
            casa.terminarComer(getName());
        } catch (InterruptedException ex) {
            Logger.getLogger(AnimalPequenio.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
}