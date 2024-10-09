<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ej11</title>
</head>
<body>
    
<?php 
 //Incluir aquí la definición de la function divisores($parametro)
$num=20;

echo "Los divisores de $num son: "; foreach(divisores($num) as $divisor)
echo "$divisor <br />";
function divisores($num)
{
    $arre=[];
    $i=0;
    for($x=1;$x<=$num;$x++)
   {//si el resto de dividir num por x es cero
     if($num%$x==0)
     {
      //lo agrego al arreglo
        $arre[$i]=$x;
        $i++;
      }
   } 
 
   return $arre;
}
?>
</body>
</html>