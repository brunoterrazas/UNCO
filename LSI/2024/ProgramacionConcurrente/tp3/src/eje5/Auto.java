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
public class Auto extends Vehiculo implements Runnable {
   int nivelReserva;
   Surtidor surtidor;

    public int getNivelReserva() {
        return nivelReserva;
    }

    public void setNivelReserva(int nivelReserva) {
        this.nivelReserva = nivelReserva;
    }

    public Auto(String marca, String patente, String modelo, int km, int capacidadTanque,int nivelreserva,Surtidor unSurtidor) {
        super(marca, patente, modelo, km, capacidadTanque);
        this.nivelReserva= nivelreserva;
        this.surtidor=unSurtidor;
    }
     @Override
    public void run() {
       this.moverse(valorRandom(20));
    }
   public void moverse(int unkm){
     if((this.getCapacidadTanque()-this.getCombustibleCosumido())>=this.getNivelReserva()){
         //Sigue en movimiento
     }
     else{
     //sino debe cargar combustible
      this.surtidor.cargarCombustible(this.patente,this.capacidadTanque-this.combustibleCosumido);
     }
   }
  public int valorRandom(int max) {
        return (int) (Math.random() * max + 1);
    }
    
}
