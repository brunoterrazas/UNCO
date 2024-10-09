<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ej3</title>
</head>
<body>
    
<?php 
$nombre="Pablo";
$apellido="Cruz";
$edad=21;
$arreAsoc=generarArrayAsoc($nombre,$apellido,$edad);


 foreach($arreAsoc as $key=>$value)
 {
   echo $key." ".$value."<br/>";

 }
 function generarArrayAsoc($nombre,$apellido,$edad)
 {
   $arre=["nombre"=>$nombre,"apellido"=>$apellido,"edad"=>$edad];
   
   return $arre;
 }
 ?>
</body>
</html>