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
class Proceso2 extends Proceso implements Runnable  {
   

  

    public Proceso2(String nombre, RecursoCompartido recurso) {
      super(nombre,recurso);
    }

    @Override
    public void run() {
          while(true)
        {   
            recurso.p2(this.getNombre());
      System.out.println(this.getNombre() + " ha liberado sem1");
        }
    }
    /*
   ¿Qué sucede si el semáforo sem2 se inicializa en 0?
   ¿Qué sucede si el semáforo sem1 se inicializa en 1?
    
    */
}