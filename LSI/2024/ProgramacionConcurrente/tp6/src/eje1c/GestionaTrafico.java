package eje1c;

/**
 *
 * @author Brunot
 */
public class GestionaTrafico {

    private int cantCochesNorte;
    private int cantCochesSur;
    private int limiteCoches;
    private int cochesCruzando;
    private boolean turnoNorte;

    
    public GestionaTrafico() {
        cantCochesNorte = 0;
        cantCochesSur = 0;
        limiteCoches=10;//cantidad de coches antes de cambiar de direccion
        cochesCruzando=0;
        turnoNorte=true;
    }
    public synchronized void EntrarCocheDelNorte(String nombre) {
        while ((!turnoNorte||cochesCruzando>=limiteCoches)) {
            try {
                //Espera bloqueado,mientras ingresan los coches del sur
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        cantCochesNorte++;
        cochesCruzando++;
        
        System.out.println(nombre + " está cruzando el puente desde el norte");
    }
   
    public synchronized void SalirCocheDelNorte(String nombre) {
        cantCochesNorte--;
       
        
         if(cochesCruzando==limiteCoches+1|| (cantCochesNorte == 0))
        {//si es el ultimo coche que puede pasar antes de cambiar de turno
         //si terminaron de cruzar 10 coches
         turnoNorte=false;
         cochesCruzando=0;
         //Despierta a los coches que estan en espera
            notifyAll();
        }   
         
        System.out.println(nombre + " ha salido del puente desde el norte");
    }

    public synchronized void EntrarCocheDelSur(String nombre) {
        while ((turnoNorte||cochesCruzando>=limiteCoches)) {
            try {
                //Espera bloqueado,mientras ingresan los coches del norte
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cantCochesSur++;
        cochesCruzando++;
        System.out.println(nombre + " está cruzando el puente desde el sur");
    }

    public synchronized void SalirCocheDelSur(String nombre) {
        cantCochesSur--;
        System.out.println(nombre + " ha salido del puente desde el sur");
        
            if(cochesCruzando==limiteCoches+1 || cantCochesSur == 0)
            {//si es el ultimo coche que puede pasar antes de cambiar de turno
         //si terminaron de cruzar 10 coches
             
              turnoNorte=true;
              cochesCruzando=0;
               //Despierta a los coches que estan en espera
            notifyAll();
            }  
    }
}
