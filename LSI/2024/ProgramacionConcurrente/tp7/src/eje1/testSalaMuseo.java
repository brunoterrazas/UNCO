/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje1;

/**
 *
 * @author Brunot
 */
public class testSalaMuseo {
 /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Sala sala=new Sala(20);
        int cantidadPersonas=25;
        int cantidadJubilados=5;
        Persona[] personas=new Persona[cantidadPersonas];
        Jubilado[] jubilados=new Jubilado[cantidadJubilados];
        MedidorTemperatura medidor =new MedidorTemperatura(sala);
      
        for (int i = 0; i < cantidadPersonas; i++) {
            personas[i]=new Persona("Persona-"+i,sala);
            personas[i].start();
        }
          medidor.start();
        for (int i = 0; i < cantidadJubilados; i++) {
            jubilados[i]=new Jubilado("Jubilado-"+i,sala,valorRandom(65,80));
            jubilados[i].start();
        }
    }
    public static int valorRandom(int min, int max) {
        int randomNum = (int) (Math.random() * (max - min + 1)) + min;
        return randomNum;
    }
}
