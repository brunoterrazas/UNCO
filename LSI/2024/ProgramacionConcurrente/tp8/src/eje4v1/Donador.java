/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje4v1;



/**
 *
 * @author Brunot
 */
public class Donador extends Thread{
   private CentroHemoterapia centro;
   private int turno;

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
   public Donador(String nombre,CentroHemoterapia centroh)
   {
     super(nombre);
     centro=centroh;
     turno=0;
   }
   @Override
   public void run()
   {
     centro.donarSangre(getName());
    // centro.contarCantPacientes(getName());
   }
}
