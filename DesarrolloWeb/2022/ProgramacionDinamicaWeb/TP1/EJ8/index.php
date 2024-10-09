<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ej8</title>
</head>
<body>
    
<?php 
 /*Dado el siguiente array: 
 $nombres = array(‘roberto’,’juan’,’marta’,’moria’,’martin’,’jorge’,’miriam’,’nahuel’,’mirta’).
 Realizar un programa en PHP que lo recorra y genere un nuevo array con aquellos nombres
 que comiencen con la letra m.*/ 
 $nombres = array("roberto","juan","marta","moria","martin","jorge","miriam","nahuel","mirta");
 $arre=listarNombreConLaLetra($nombres,"m");
 mostrarArray($arre);
 function listarNombreConLaLetra($arre,$letra)
 {
   $listaNombres=[];
   $j=0;
    for($i=0;$i<count($arre);$i++)
   {
    $nombre=$arre[$i];
     if($nombre[0]==$letra)
     {
       $listaNombres[$j]=$nombre;
       $j++;
     }   
   }
   return $listaNombres;
 }
 function mostrarArray($arre)
 {
    for($i=0;$i<count($arre);$i++)
    {
        echo $arre[$i]."<br/>";
    }
 }
 ?>
</body>
</html>