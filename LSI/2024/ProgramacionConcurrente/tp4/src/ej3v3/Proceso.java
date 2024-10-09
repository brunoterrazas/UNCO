/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej3v3;

import ej3.*;

/**
 *
 * @author Acer
 */
class Proceso  {
    protected String nombre;
    protected RecursoCompartido recurso;

    public String getNombre() {
        return nombre;
    }

    public ej3v3.RecursoCompartido getRecurso() {
        return recurso;
    }
    
    public Proceso(String nombre, RecursoCompartido recurso) {
      this.nombre=nombre;
        this.recurso = recurso;
       
    }
}