/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejeSalaBaile;

/**
 *
 * @author Brunot
 */
public class Persona extends Thread {
 private int turno;
 private char sexo;
  private SalaBaile sala;

    public char getSexo() {
        return sexo;
    }
    public Persona(String nom,char sexo,SalaBaile s) {
        super(nom);
        this.sexo = sexo;
        turno=0;
        sala=s;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
 @Override
    public void run()
    {
      if(sexo=='f')
      {
       sala.ingresaFila1(this);
      }
      else{
          
       sala.ingresaFila2(this);
    
      }
    }
    
 
}
