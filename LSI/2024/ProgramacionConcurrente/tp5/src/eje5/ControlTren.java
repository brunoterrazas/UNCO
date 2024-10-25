/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje5;

/**
 *
 * @author Acer
 */
public class ControlTren extends Thread {
    private Tren tren;
    public ControlTren(String nombre,Tren tren)
    {
      super(nombre);
      this.tren=tren;
    }
    @Override
    public void run()
    {
        boolean cortar=false;
        while(tren.todosAtendidos()&&!cortar)
        { 
            try {
                Thread.sleep(2000);  // Simula el tiempo del recorrido
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("cantEspera"+tren.getPasajerosEnEspera());
            if(tren.getPasajerosEnEspera()<tren.getMaxEspacios()&&tren.getPasajerosEnEspera()==0)
            {
              cortar=true;
            }    
            else{ 
            System.out.println("Esperando que llene para que el tren pueda partir");
            tren.partir();
            }
        }
    
    }
}
