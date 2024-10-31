/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje2;

/**
 *
 * @author Brunot
 */
public class testProgramadores {
public static void main(String[] args)
 {
    RecursoCompartido recurso=new RecursoCompartido(5,5);
    int cantidadProgramadores=20;
    Programador[] programadores=new Programador[cantidadProgramadores];
    for (int i = 0; i < cantidadProgramadores; i++) {
          programadores[i]=new Programador("programador-"+(i+1),recurso);
          programadores[i].start();
     }
 }
}
