<?php

function mostrarArray($arre)
{
   for($i=0;$i<count($arre);$i++)
   {
       echo $arre[$i]."<br/>";
   }
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
?>