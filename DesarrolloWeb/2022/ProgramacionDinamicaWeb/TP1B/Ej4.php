<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EJERCICIO 4</title>
</head>
<body>
<?php 

 /*Modificar el formulario del ejercicio anterior para que usando la edad solicitada, enviar
esos datos a otra página en donde se muestren mensajes distintos dependiendo si la
persona es mayor de edad o no; (si la edad es mayor o igual a 18).
Enviar los datos usando el método GET y luego probar de modificar los datos
directamente en la url para ver los dos posibles mensajes.*/
?>    
<form method="GET" action="mostrarDatos.php">
    <label for="nombre">Nombre</label>
      <input id="nombre" name="nombre"type="text">
      <label for="apellido">Apellido</label>
      <input id="apellido" name="apellido"type="text">
      <label for="edad">Edad</label>
      <input id="edad" name="edad"type="text">
   
      <input type="submit" value="Enviar">
</form>  


</body>
</html>
