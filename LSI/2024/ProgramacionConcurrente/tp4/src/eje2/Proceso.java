/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje2;

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
        try {
            switch (tipo) {
                case 1: // Proceso P1
                    recurso.sem2.acquire(); // adquirir(sem2)
                    recurso.Operacion_P1();
                    recurso.sem1.release(); // liberar(sem1)
                    System.out.println(this.nombre + " ha liberado sem1");
                    break;
                    
                case 2: // Proceso P2
                    recurso.sem3.acquire(); // adquirir(sem3)
                   recurso.Operacion_P2();
                    recurso.sem2.release(); // liberar(sem2)
                    System.out.println(Thread.currentThread().getName()+ " ha liberado sem2");
                    break;
                    
                case 3: // Proceso P3
                    recurso.sem1.acquire(); // adquirir(sem1)
                   recurso.Operacion_P3();
                    recurso.sem3.release(); // liberar(sem3)
                    System.out.println(Thread.currentThread().getName() + " ha liberado sem3");
                    recurso.sem4.release(); // liberar(sem4)
                    System.out.println(Thread.currentThread().getName()+ " ha liberado sem4");
                    break;
                    
                case 4: // Proceso P4
                    recurso.sem4.acquire(); // adquirir(sem4)
                  recurso.Operacion_P4();
                    break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /*
   ¿Qué sucede si el semáforo sem2 se inicializa en 0?
   ¿Qué sucede si el semáforo sem1 se inicializa en 1?
    
    */
}