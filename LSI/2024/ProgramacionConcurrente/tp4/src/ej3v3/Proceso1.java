/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej3v3;


/**
 *
 * @author Acer
 */
class Proceso1 extends Proceso implements Runnable  {
    

    public Proceso1(String nombre, RecursoCompartido recurso) {
      super(nombre,recurso);
    }

    @Override
    public void run() {
        while(true)
        {     
              recurso.p1(this.getNombre());
              System.out.println(this.getNombre() + " ha liberado sem2");
        }
    }

}