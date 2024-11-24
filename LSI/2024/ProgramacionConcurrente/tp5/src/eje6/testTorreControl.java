/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje6;

/**
 *
 * @author Brunot
 */
public class testTorreControl {
    public static void main(String[] args) {
        TorreControl pista=new TorreControl();
        int cantAvionesDespegando=30;
        Avion[] avionDespegando=new Avion[cantAvionesDespegando];
        for (int i = 0; i < avionDespegando.length; i++) {
            avionDespegando[i]=new Avion("Avion D-"+i,"despegar",pista);
            avionDespegando[i].start();
        }
        int cantAvionesAterrizando=30;
        Avion[] avionAterrizando=new Avion[cantAvionesAterrizando];
        for (int i = 0; i < avionAterrizando.length; i++) {
            avionAterrizando[i]=new Avion("Avion A-"+i,"aterrizar",pista);
            avionAterrizando[i].start();
        }
    }
}
