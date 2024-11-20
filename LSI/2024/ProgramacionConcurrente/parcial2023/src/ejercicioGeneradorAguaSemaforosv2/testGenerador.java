/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioGeneradorAguaSemaforosv2;



/**
 *
 * @author Usuario
 */
public class testGenerador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Recipiente recipiente=new Recipiente(5);
        int cantidadOListo=10;
        int cantidadHListo=20;
        Oxigeno[] oListos=new Oxigeno[cantidadOListo];
        for (int i = 0; i < cantidadOListo; i++) {
            oListos[i]=new Oxigeno("Oxigeno"+(i+1),recipiente);
            oListos[i].start();
        }
        Hidrogeno[] hListos=new Hidrogeno[cantidadHListo];
        for (int i = 0; i < cantidadHListo; i++) {
            hListos[i]=new Hidrogeno("Hidrogeno"+(i+1),recipiente);
            hListos[i].start();
        }
        
    }
    
}
