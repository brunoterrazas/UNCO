/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje7;

/**
 *
 * @author Usuario
 */
public class testConfiteria {
     public static void main(String[] args) {
       
        int cantEmpleados=5;
        
        Confiteria confiteria = new Confiteria("Pollos hermanos",cantEmpleados);
         System.out.println("*************** Confiteria "+confiteria.getNombre());
            
        Mozo mozoThread = new Mozo("Mozo",confiteria);
        
        
        Empleado[] empleadoThread=new Empleado[cantEmpleados];
        for(int i=0;i<cantEmpleados;i++){
             empleadoThread[i]=new Empleado("Empleado "+(i+1), confiteria);

        }      
        for(int i=0;i<cantEmpleados;i++){
        empleadoThread[i].start();
        }
       
        mozoThread.start();
        }
}
