<?php
$dir='../archivos/';
if($_FILES['archivoTexto']['error']<=0)
{
echo "Nombre:".$_FILES['archivoTexto']['name']."</br>";

echo "Tipo:".$_FILES['archivoTexto']['type']."</br>";

echo "Tamaño:".$_FILES['archivoTexto']['size']."</br>";


echo "Carpeta temporal:".$_FILES['archivoTexto']['tmp_name']."</br>";

if(!copy($_FILES['archivoTexto']['tmp_name'],$dir.$_FILES['archivoTexto']['name']))
{
  echo "Error: no se pudo cargar el archivo";
}
else{
    echo "El archivo ".$_FILES["archivoTexto"]["name"]." se ha copiado con &eacute;xito </br>";
}

}
else{

    echo "Error: no se pudon cargar el archivo. No se pudo acceder el archivo temporal";
}

?>