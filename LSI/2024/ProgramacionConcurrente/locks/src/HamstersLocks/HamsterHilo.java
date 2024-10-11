/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HamstersLocks;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class HamsterHilo extends Thread {
    private PlatoLock plato;
    private RuedaLock rueda;
    public HamsterHilo(String nombre,PlatoLock unPlato,RuedaLock rueda){
    super(nombre);
    this.plato=unPlato;
    this.rueda=rueda;
    
    }
    @Override
    public void run(){
    while(true)
        {
            int opc=valorRandom(2);
            switch(opc){
             
                case 1:
                     this.plato.empezarAComer(this.getName());
            {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(HamsterHilo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            this.plato.terminarDeComer(this.getName());
                    break;
                case 2:
                     this.rueda.rodar(this.getName());
                    break;
             
            }
        
           
           
        }
    
    
    }
    public int valorRandom(int max) {
        return (int) (Math.random() * max + 1);
    }
}
