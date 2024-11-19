/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje1Semaforosv2;


/**
 *
 * @author Usuario
 */
public class testMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Fabrica fabrica= new Fabrica(10,10,5);
        EquipoProduccion equipoRuedas= new EquipoProduccion(fabrica,"ruedas");
        EquipoProduccion equipoPuertas= new EquipoProduccion(fabrica,"puertas");
        EquipoProduccion equipoCarrocerias= new EquipoProduccion(fabrica,"carrocerias");
        EquipoEnsamblaje equipoEnsamblaje=new EquipoEnsamblaje(fabrica);
        equipoRuedas.start();
        equipoPuertas.start();
        equipoCarrocerias.start();
        equipoEnsamblaje.start();
        
    }
    
}
