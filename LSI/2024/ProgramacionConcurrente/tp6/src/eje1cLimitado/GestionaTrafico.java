/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje1cLimitado;


import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class GestionaTrafico {

    private int cochesNorte = 0;
    private int cochesSur = 0;
    private Semaphore semNorte;
    private Semaphore semSur;
    private Semaphore semMutex;
    private boolean turnoLibre;
    private int limiteCoches;
    private int cochesCruzando=0;
    
    public GestionaTrafico() {
        semNorte = new Semaphore(0, true);
        semSur = new Semaphore(0, true);
        semMutex = new Semaphore(1);
        turnoLibre = true;   
        limiteCoches=5;
    }

    public void entrarCocheDelNorte(String nombre, String direccion) {
        try {
            semMutex.acquire();
            if(turnoLibre)
            definirTurno(semNorte,direccion);
            
             cochesNorte++;
             cochesCruzando++;
            
             System.out.println("Coches cruzando"+cochesCruzando+"");
            semMutex.release();
            semNorte.acquire();  // Espera su turno para cruzar desde el norte
            
            Thread.sleep(150);
            System.out.println("Cruzando desde  el norte, " + nombre);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void salirCocheDelNorte(String nombre) {
        try {
            semMutex.acquire();
            cochesNorte--;
            semMutex.release();
            System.out.println(nombre + " ha salido del puente desde el norte.");
            if (cochesNorte == 0) {  // Cambia prioridad al sur después de 10 cruces
                if (cochesSur > 0) {
                    semSur.release();
                }// Permitir a coches del sur cruzar
            } else {
                semNorte.release();  // Permitir al siguiente coche del norte cruzar
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void entrarCocheDelSur(String nombre, String direccion) {
        try {
            semMutex.acquire();
            if(turnoLibre)
            definirTurno(semSur,direccion);
            
            cochesSur++;
            cochesCruzando++;
            /*if(cochesCruzando==limiteCoches)
            {
              definirTurno(semNorte,direccion);
              cochesCruzando=0;
            }
            */
            semMutex.release();
            semSur.acquire();  // Espera su turno para cruzar desde el sur
            Thread.sleep(150);
            System.out.println("Cruzando desde el sur, " + nombre);
        } catch (InterruptedException ex) {
            Logger.getLogger(GestionaTrafico.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void definirTurno(Semaphore sem, String direccion)
    {
            if (turnoLibre) {
                turnoLibre = false;
                sem.release();
                System.out.println("Ingresan los coches del "+direccion);
            }
      
    }

    public void salirCocheDelSur(String nombre) {

        try {
            semMutex.acquire();
            cochesSur--;
            semMutex.release();
            System.out.println(nombre + " ha salido del puente desde el sur.");
            if (cochesSur == 0) {
                if (cochesNorte > 0) {
                    semNorte.release();
                }  // Permitir a coches del norte cruzar
            } else {
                semSur.release();  // Permitir a más coches del sur cruzar
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(GestionaTrafico.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
