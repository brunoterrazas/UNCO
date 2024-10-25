package eje1monitores;

public class Coche extends Thread {
    private GestionaTrafico gestor;
    private String direccion;

    public Coche(String nombre, String direccion, GestionaTrafico gestor) {
        super(nombre);
        this.direccion = direccion;
        this.gestor = gestor;
    }

    @Override
    public void run() {
        if (direccion.equals("norte")) {
            gestor.EntrarCocheDelNorte(getName());
            gestor.SalirCocheDelNorte(getName());
        } else {
            gestor.EntrarCocheDelSur(getName());
            gestor.SalirCocheDelSur(getName());
        }
    }
}
