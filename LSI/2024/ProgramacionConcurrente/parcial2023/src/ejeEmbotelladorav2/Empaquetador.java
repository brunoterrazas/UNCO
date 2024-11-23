/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejeEmbotelladorav2;

/**
 *
 * @author Brunot
 */
public class Empaquetador extends Thread {

    private PlantaEmbotelladora planta;

    public Empaquetador(String nom, PlantaEmbotelladora plantaEmb) {
        super(nom);
        planta = plantaEmb;

    }

    @Override
    public void run() {

        while (true) {
            if (planta.estaCajaAguaLlena()) {
                planta.cambiarCaja("agua");
            }
            if (planta.estaCajaVinoLlena()) {
                planta.cambiarCaja("vino");
            }
        }
    }
}
