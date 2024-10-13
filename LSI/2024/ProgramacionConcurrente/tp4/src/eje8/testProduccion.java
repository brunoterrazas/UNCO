/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje8;

/**
 *
 * @author Usuario
 */
public class testProduccion {
  public static void main(String[] args) {
        ControladorProduccion controlador = new ControladorProduccion();
        int cantElectrico = 10;
        int cantMecanico = 10;

        
        Thread hiloLinea = new Thread(new Linea(controlador));
        hiloLinea.start();

        for (int i = 0; i < cantElectrico; i++) {
            new Thread(new ProductoElectrico("Producto eléctrico " + i, "eléctrica", controlador)).start();
        }

        for (int i = 0; i < cantMecanico; i++) {
            new Thread(new ProductoMecanico("Producto mecánico " + i, "mecánica", controlador)).start();
        }
    }
}
