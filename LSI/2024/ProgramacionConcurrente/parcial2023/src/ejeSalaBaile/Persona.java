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
public class Persona {
 private int turno;
 private char sexo;

    public Persona(char sexo) {
        this.sexo = sexo;
        turno=0;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
    
 
}
