/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejeSemaforosv2;


/**
 *
 * @author Usuario
 */
public class testAnimales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Casa casa=new Casa(4);
        AnimalMayor animalMayor=new AnimalMayor(casa);
        animalMayor.start();
        int cantidadPequenios=15;
        AnimalPequenio[] animalitos=new AnimalPequenio[cantidadPequenios];
        for (int i = 0; i <cantidadPequenios; i++) {
            animalitos[i]=new AnimalPequenio("animalito-"+i,casa);
            animalitos[i].start();
        }
        
    }
    
}
