/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montaniaRusaSemaforos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brunot
 */
public class MontaniaRusa {

    private Semaphore semSubir, semPartir, mutex, semTerminarVuelta;
    private int recorridos, maxRecorridos, maxCapacidad,pasajerosABordo, pasajerosEnEspera, cantViajes;
    private boolean activo, estaCerrado;

    public MontaniaRusa(int capacidad, int cantRecorridos) {
        semSubir = new Semaphore(capacidad, true);
        semPartir = new Semaphore(0);
        maxCapacidad = capacidad;
        maxRecorridos = cantRecorridos;
        mutex = new Semaphore(1, true);
        semTerminarVuelta = new Semaphore(0, true);
       pasajerosABordo = 0;
        pasajerosEnEspera = 0;
        recorridos = 0;
        cantViajes = 0;
        activo = true;
       }

    public void subir(String pasajero) {
        try {
			
            while (activo) {
                mutex.acquire();
                pasajerosEnEspera++;
                mutex.release();
                semSubir.acquire();
                mutex.acquire();
                //Verificamos si esta activo el carro 
                if (!activo) {/* System.out.println(pasajero+" no pudo subir al carro, 
                   porque esta cerrado porque alcanzo el limite de recorridos"); */
                    mutex.release();
                    break;
                }
               pasajerosABordo++;
                pasajerosEnEspera--;
                System.out.println(pasajero + " subió al carro");
                cantViajes++;
                mutex.release();
                if (pasajerosABordo== maxCapacidad) {
                    semPartir.release();
                }
                semTerminarVuelta.acquire();
                System.out.println(pasajero + " terminó de dar la vuelta");
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(MontaniaRusa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void darVuelta() {
        try {
            while (activo||(recorridos < maxRecorridos)) {

                if (!activo) {
                    break;//el hilo control termina su ejecucion
                }
                if (recorridos < maxRecorridos) {
                    semPartir.acquire();
                    System.out.println(".......Tren viajando........");
                    Thread.sleep(2000);
                    semTerminarVuelta.release(maxCapacidad);
                    System.out.println("....Pasajeros bajando....");
                    Thread.sleep(1000);
                    mutex.acquire();
                   pasajerosABordo = 0;
                    mutex.release();
                    recorridos++;
                    System.out.println("Capacidad Carro "+maxCapacidad+" Cantidad de recorridos: " + recorridos);
                    semSubir.release(maxCapacidad);
                } else {
                    // Si ya se alcanzó el máximo de recorridos, libera a los pasajeros que no pudieron subir
	            mutex.acquire();
                    activo = false;
                    System.out.println("Pasajeros que no pudieron entrar: " + pasajerosEnEspera+ ", viajes en total: "+getTotal()+"");
                    semSubir.release(pasajerosEnEspera);
                    mutex.release();
                    semPartir.release();//libero el permiso para que vuelva a entrar y pueda terminar su ejecucion
                    break;
                }
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(MontaniaRusa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean isActivo() {
        return activo;
    }

    public int getCantViajes() {
        return cantViajes;
    }

    public int getTotal() {
        return maxCapacidad * maxRecorridos;
    }

    public int getRecorridos() {
        return recorridos;
    }

    public int getMaxRecorridos() {
        return maxRecorridos;
    }

}
