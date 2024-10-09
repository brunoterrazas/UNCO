/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje5;

/**
 *
 * @author Acer
 */
public class Vehiculo {
     protected String marca;
     protected String patente;
     protected String modelo;
     protected int km;
     protected int capacidadTanque;
     protected int combustibleCosumido;

   

    public Vehiculo(String marca, String patente, String modelo, int km, int capacidadTanque) {
        this.marca = marca;
        this.patente = patente;
        this.modelo = modelo;
        this.km = km;
        this.capacidadTanque = capacidadTanque;
    }

    public String getMarca() {
        return marca;
    }
    public String getPatente() {
        return patente;
    }

    public String getModelo() {
        return modelo;
    }

    public int getKm() {
        return km;
    }

    public int getCapacidadTanque() {
        return this.capacidadTanque;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public void setCapacidadTanque(int capacidadTanque) {
        this.capacidadTanque = capacidadTanque;
    }
     public int getCombustibleCosumido() {
        return combustibleCosumido;
    }

    public void setCombustibleCosumido(int combustibleCosumido) {
        this.combustibleCosumido = combustibleCosumido;
    }
    
}
