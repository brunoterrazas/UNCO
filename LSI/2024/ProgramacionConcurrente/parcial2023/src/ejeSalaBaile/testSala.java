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
public class testSala {
   public static void main(String[] args)
   {
       SalaBaile sala=new SalaBaile();
     int cantVarones=5;
       Persona[] varones=new Persona[cantVarones];
       for (int i = 0; i < cantVarones; i++) {
             varones[i]=new Persona("Varon-"+(i+1),'m',sala);
             varones[i].start();      
       }
       int cantParejas=10;//deber ser numero par
       Persona[] personas=new Persona[cantParejas];
       int cont=1;
       for (int i = 0; i < cantParejas; i+=2) {
             personas[i]=new Persona("Pareja-"+cont,'f',sala);
             personas[i].start();
             personas[i+1]=new Persona("Pareja-"+cont,'m',sala);
             personas[i+1].start();
             cont++;
       }
     
      
         int cantMujeres=5;
       Persona[] mujeres=new Persona[cantMujeres];
       for (int i = 0; i < cantMujeres; i++) {
             mujeres[i]=new Persona("Mujer-"+(i+1),'f',sala);
        mujeres[i].start();
       }
   }
}
