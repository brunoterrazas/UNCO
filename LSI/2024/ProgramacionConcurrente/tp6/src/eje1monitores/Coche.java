package eje1monitores;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Coche extends Thread {
    private GestionaTrafico gestor;
    private String direccion;

    public Coche(String nombre, String direccion, GestionaTrafico gestor) {
        super(nombre);
        this.direccion = direccion;
        this.gestor = gestor;
    }

    @Override
    public void run() {
        
        
         try { 
              if (direccion.equals("Norte")) {
            gestor.EntrarCocheDelNorte(getName());
           Thread.sleep(2000);
            gestor.SalirCocheDelNorte(getName());
        } else {
            gestor.EntrarCocheDelSur(getName());
            Thread.sleep(2000);
            gestor.SalirCocheDelSur(getName());
        }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Coche.class.getName()).log(Level.SEVERE, null, ex);
            }
       
    }
}
