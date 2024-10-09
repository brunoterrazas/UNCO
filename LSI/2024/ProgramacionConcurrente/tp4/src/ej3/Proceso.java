/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej3;

/**
 *
 * @author Acer
 */
class Proceso extends Thread {
    private String nombre;
    private RecursoCompartido recurso;
    private int tipo; 

    public Proceso(String nombre, RecursoCompartido recurso, int tipo) {
      super(nombre);
        this.recurso = recurso;
        this.tipo = tipo;
    }

    @Override
    public void run() {
    try{
        switch (tipo) {
            case 1:
                // Proceso P1
               
                    recurso.sem1.acquire();
                    recurso.Operacion_P1();
                    recurso.sem2.release();
                    System.out.println(Thread.currentThread().getName() + " ha liberado sem2");
                   break;
            case 2:
                // Proceso P2
              
                    recurso.sem3.acquire();
                    recurso.Operacion_P2();
                    recurso.sem1.release();
                    System.out.println(Thread.currentThread().getName() + " ha liberado sem1");
                      break;
            case 3:
                // Proceso P3
                recurso.sem2.acquire();
                recurso.Operacion_P3();
                recurso.sem3.release();
                       break;
            default:
                break;
        }
    }
    catch (InterruptedException e) { e.printStackTrace();
    }
    }
    /*
   ¿Qué sucede si el semáforo sem2 se inicializa en 0?
   ¿Qué sucede si el semáforo sem1 se inicializa en 1?
    
    */
}