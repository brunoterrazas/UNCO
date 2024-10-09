<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ej7</title>
</head>
<body>
    
<?php 
 /*
 Dado un array de 20 elementos que consiste en números reales (con coma decimal) 
 y que cada elemento representa la venta del día de un comercio. 
 Calcular el promedio de ventas utilizando alguna estructura iterativa.
 */

  for($i=0;$i<20;$i++)
  {
    $r = 1000000000 / rand(10000, 100000);
    $valDecimal = sprintf('%.2f', $r);
    $arreNumReales[$i]=$valDecimal;
  }
  print_r($arreNumReales);
  echo "<br/>El promedio es:".calcularPromedio($arreNumReales);
  echo "<br>";
  $arreEntero=[90,70,100];
  print_r($arreEntero);
  echo "<br/>El promedio es:".calcularPromedio($arreEntero);
  
   /**
    * int $i,$cant
    * double $cant_pasajero
    * @param String $apellido
    * @return Double
    */
  function calcularPromedio($arre)
  {
    $sum=0;
    $cant=count($arre);
    for($i=0;$i<$cant;$i++)
    {
      $sum=$sum+$arre[$i];
    }
    $promedio=$sum/$cant;
   return sprintf('%.2f', $promedio);;
  }
 /*Fuente:
 https://desarrolloweb.com/faq/542.php
https://www.delftstack.com/es/howto/php/how-to-show-a-number-to-two-decimal-places-in-php/*/
 ?>
</body>
</html>