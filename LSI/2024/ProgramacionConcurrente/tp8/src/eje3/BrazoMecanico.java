/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje3;

/**
 *
 * @author Brunot
 */
public class BrazoMecanico extends Thread {

    private Pasteleria pasteleria;

    public BrazoMecanico(String nom, Pasteleria past) {
        super(nom);
        pasteleria = past;

    }

    @Override
    public void run() {
        while (true) {
            pasteleria.retirarCaja();
            
            pasteleria.reponerCaja();
        }
    }

}
