<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ej9</title>
</head>
<body>
    
<?php 
 /*
 Dado un array enumerativo de 10 elementos de números enteros (sin coma decimal),  
 encontrar  el  máximo  de  todos  esos  números 
 usando  una  estructura  iterativa  y mostrarlo por pantalla.
 */
include "../funciones.php";
$arre=generarArrayEntero(10);
mostrarArray($arre);
echo "El Mayor es: ".maxArray($arre);

function maxArray($arre)
{
 $max=-99999999;
  for($i=0;$i<count($arre);$i++)
  {
    if($arre[$i]>$max)
    {
     $max=$arre[$i];
    }
  }
  return $max;
}

function generarArrayEntero($cant)
{
    for($i=0;$i<$cant;$i++)
    {
        $valAleatorio=rand(0, 10000);
        $arreEnteros[$i]=$valAleatorio;
    }
    return $arreEnteros;
}

?>
</body>
</html>