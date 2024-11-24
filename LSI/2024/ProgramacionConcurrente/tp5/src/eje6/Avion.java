/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje6;

/**
 *
 * @author Brunot
 */
public class Avion extends Thread {

    private TorreControl pista;
    private String tipoOperacion;

    public Avion(String nombre, String operacion, TorreControl laPista) {
        super(nombre);
        this.tipoOperacion = operacion;
        this.pista = laPista;
    }

    @Override
    public void run() {
        if (tipoOperacion.equals("despegar")) {
            pista.solicitarDespegar(getName());

        } else {
            pista.solicitarAterrizar(getName());

        }

    }
}
