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
public class EquipoEnsamblaje extends Thread {
    private Fabrica fabrica;

    public EquipoEnsamblaje(Fabrica fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public void run() {
        try {
            while (true) {
                fabrica.ensamblarAutomovil("Equipo ensamblaje");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
