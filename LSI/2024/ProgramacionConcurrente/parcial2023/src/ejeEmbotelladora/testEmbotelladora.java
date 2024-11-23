/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejeEmbotelladora;

/**
 *
 * @author Brunot
 */
public class testEmbotelladora {

    public static void main(String[] args) {
        PlantaEmbotelladora planta = new PlantaEmbotelladora();
        int cantEmbVino = 1;
        Embotellador[] embotelladoresVino = new Embotellador[cantEmbVino];
        Empaquetador empaquetador=new Empaquetador("empaquetador",planta);
        empaquetador.start();
        Chofer chofer=new Chofer("chofer",planta);
        chofer.start();
        for (int i = 0; i < cantEmbVino; i++) {
            embotelladoresVino[i] = new Embotellador("embotellador-" + (i + 1), planta, "vino");
            embotelladoresVino[i].start();
        }

        int cantEmbAgua = 1;
        Embotellador[] embotelladoresAgua = new Embotellador[cantEmbAgua];
        for (int i = 0; i < cantEmbAgua; i++) {

            embotelladoresAgua[i] = new Embotellador("embotellador-" + (i + 1), planta, "agua");
            embotelladoresAgua[i].start();
        }
    }
}
