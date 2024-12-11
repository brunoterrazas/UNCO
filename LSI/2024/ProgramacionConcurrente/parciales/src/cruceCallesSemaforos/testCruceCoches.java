/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruceCallesSemaforos;

/**
 *
 * @author Usuario
 */
public class testCruceCoches {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GestorCruce gestor=new GestorCruce();
        int cantAutosNorte,cantAutosOeste;
        cantAutosNorte=10;
        Control control=new Control("Control",gestor);
        control.start();
        Coche[] cochesN=new Coche[cantAutosNorte];
        for (int i = 0; i < cochesN.length; i++) {
            cochesN[i]=new Coche("coche N-"+(i+1),"Norte",gestor);
            cochesN[i].start();
        }
        
        
        cantAutosOeste=10;
         Coche[] cochesO=new Coche[cantAutosOeste];
        for (int i = 0; i < cochesN.length; i++) {
            cochesO[i]=new Coche("coche O-"+(i+1),"Oeste",gestor);
            cochesO[i].start();
        }
        
    }
    
}
