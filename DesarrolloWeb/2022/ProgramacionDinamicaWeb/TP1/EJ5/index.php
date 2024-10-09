<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Eje1</title>
</head>
<body>
    
<?php 
 /*
 Mostrar por pantalla la tabla de multiplicar del 2. Emplear el for, luego el while y
 por último el do/while. La salida debe verse con el siguiente formato:
  2 x 1 es 2 2 x 2 es 4……
 */
$num=2;
mostrarTablaDelNumFor($num);
mostrarTablaDelNumWhile($num);
mostrarTablaDelNumDoWhile($num);
 function mostrarTablaDelNumFor($num)
 {
    echo "Tabla del $num con un for<br/>";
   for($i=1;$i<=10;$i++)
   {
     echo $num."x".$i." = ".($num*$i)."<br/>";
   }  
 }
 
 function mostrarTablaDelNumWhile($num)
 {
    echo "Tabla del $num con un while<br/>";
   
    $i=1;
   while($i<=10)
   {
    echo $num."x".$i." = ".($num*$i)."<br/>";
    $i++;
   }
 }
 
 function mostrarTablaDelNumDoWhile($num)
 {
    echo "Tabla del $num con un do while<br/>";
    $i=1;
  do{
  
   echo $num."x".$i." = ".($num*$i)."<br/>";
   $i++;
   }
  while($i<=10);
 }
 ?>
</body>
</html>