package eje1monitores;

public class GestionaTrafico {

    private int cantCochesNorte;
    private int cantCochesSur;

    public GestionaTrafico() {
        cantCochesNorte = 0;
        cantCochesSur = 0;
    }

    public synchronized void EntrarCocheDelNorte(String nombre) {
        while (cantCochesSur > 0) {
            try {
                //Espera bloqueado,mientras ingresan los coches del sur
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cantCochesNorte++;
        System.out.println(nombre + " está cruzando el puente");
    }

    public synchronized void SalirCocheDelNorte(String nombre) {
        cantCochesNorte--;
        System.out.println(nombre + " ha salido del puente");
        if (cantCochesNorte == 0) {
            //Despierta a los coches que estan en espera
            notifyAll();
        }
    }

    public synchronized void EntrarCocheDelSur(String nombre) {
        while (cantCochesNorte > 0) {
            try {
                //Espera bloqueado,mientras ingresan los coches del norte
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cantCochesSur++;
        System.out.println(nombre + " está cruzando el puente");
    }

    public synchronized void SalirCocheDelSur(String nombre) {
        cantCochesSur--;
        System.out.println(nombre + " ha salido del puente");
        if (cantCochesSur == 0) {
            //Despierta a los coches que estan en espera
            notifyAll();
        }
    }
}
