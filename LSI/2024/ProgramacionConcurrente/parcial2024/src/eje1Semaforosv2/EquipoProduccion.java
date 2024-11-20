/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje1Semaforosv2;


/**
 *
 * @author Brunot
 */
public class EquipoProduccion  extends Thread {
    private Fabrica fabrica;
    private String tipo;

    public EquipoProduccion(Fabrica fabrica, String tipo) {
        this.fabrica = fabrica;
        this.tipo = tipo;
    }

    @Override
    public void run() {
        try {
            while (true) {
                switch (tipo) {
                    case "ruedas":
                        fabrica.producirRuedas("Equipo "+tipo);
                        Thread.sleep(100);
                        break;
                    case "puertas":
                        fabrica.producirPuertas("Equipo "+tipo);
                        Thread.sleep(200);
                        break;
                    case "carrocerias":
                        fabrica.producirCarrocerias("Equipo "+tipo);
                        Thread.sleep(300);
                        break;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
