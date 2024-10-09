<?php 
if($_GET)
{
    $nombre=$_GET["nombre"];
    $apellido=$_GET["apellido"];
    $edad=$_GET["edad"];
    $direccion=$_GET["direccion"];
   echo "Soy $nombre,$apellido tengo $edad años y vivo en $direccion";
}
else{
    echo "error";
}


?>