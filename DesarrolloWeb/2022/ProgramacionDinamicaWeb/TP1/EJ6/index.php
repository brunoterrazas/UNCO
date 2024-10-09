<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ej6</title>
</head>
<body>
    
<?php 
 /*
 Crear un programa en php en el que generen un array bidimensional asociativo que contenga
 los key para cada día de la semana la materia que cursan junto con la carga horaria de la misma.
 Luego recorrer el array usando una estructura foreach que muestre por pantalla la información 
 contenida.
 */
 $arre[0]["materia"]="Diseño Grafico";
 $arre[0]["cargaHoraria"]=120;
 $arre[1]["materia"]="Programacion Web Dinamica";
 $arre[1]["cargaHoraria"]=240;
 $arre[2]["materia"]="Arquitectura y seguridad de computadoras";
 $arre[2]["cargaHoraria"]=240;

 print_r($arre);
 function mostrarArrayMultidimensionalMat()
 {


 }
   /** 
     * Retorna el dia como texto
     * STRING $dia
     * @param Int $indice
     * @return String 
     */
    function diaEnTexto($indice)
    {
        $dia = "";
        switch ($indice) {
            case 0:
                $dia = "Enero";
                break;
            case 1:
                $dia = "Febrero";
                break;
            case 2:
                $dia = "Marzo";
                break;
            case 3:
                $dia = "Abril";
                break;
            case 4:
                $dia = "Mayo";
                break;
            case 5:
                $dia = "Junio";
                break;
            case 6:
                $dia = "Julio";
                break;
            case 7:
                $dia = "Agosto";
                break;
            default:
            $dia="error";
            break;
           
        }
        return $dia;
    }
 ?>
</body>
</html>