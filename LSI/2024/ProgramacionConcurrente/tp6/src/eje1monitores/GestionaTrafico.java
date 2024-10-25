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
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cantCochesNorte++;
        System.out.println(nombre + " está cruzando el puente desde el norte");
    }

    public synchronized void SalirCocheDelNorte(String nombre) {
        cantCochesNorte--;
        System.out.println(nombre + " ha salido del puente desde el norte");
        if (cantCochesNorte == 0) {
            notifyAll();
        }
    }

    public synchronized void EntrarCocheDelSur(String nombre) {
        while (cantCochesNorte > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cantCochesSur++;
        System.out.println(nombre + " está cruzando el puente desde el sur");
    }

    public synchronized void SalirCocheDelSur(String nombre) {
        cantCochesSur--;
        System.out.println(nombre + " ha salido del puente desde el sur");
        if (cantCochesSur == 0) {
            notifyAll();
        }
    }
}
