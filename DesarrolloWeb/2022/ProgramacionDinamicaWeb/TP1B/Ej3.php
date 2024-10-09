<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<?php 
/*Crear una página php que contenga un formulario HTML como el que se indica en la
imagen (darle formato con CSS), enviar estos datos por el método Post a otra página php
que los reciba y muestre por pantalla un mensaje como el siguiente: “Hola, yo soy
nombre , apellido tengo edad años y vivo en dirección”, usando la información recibida.
Cambiar el método Post por Get y analizar las diferencias */
?>
<form method="GET" action="mostrarDatos.php">
    <label for="nombre">Nombre</label>
      <input id="nombre" name="nombre"type="text">
      <label for="apellido">Apellido</label>
      <input id="apellido" name="apellido"type="text">
      <label for="edad">Edad</label>
      <input id="edad" name="edad"type="text">
      <label for="direccion">Direccion</label>
      <input id="direccion" name="direccion"type="text">
      <input type="submit" value="Enviar">
</form>    
</body>
</html>
