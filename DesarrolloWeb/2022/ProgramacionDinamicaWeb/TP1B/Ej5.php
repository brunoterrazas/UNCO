<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<link rel="stylesheet" href="css/bootstrap.min.css">

<script src="js/bootstrap.min.js" crossorigin="anonymous"></script>
<body>
<?php 
/*
Modificar el formulario del ejercicio anterior solicitando, tal que usando componentes
“radios buttons” se ingrese el nivel de estudio de la persona: 1-no tiene estudios, 2-
estudios primarios, 3-estudios secundarios. Agregar el componente que crea más
apropiado para solicitar el sexo. En la página que procesa el formulario mostrar además
un mensaje que indique el tipo de estudios que posee y su sexo. */
?>
<form method="GET" action="mostrarDatosEstudio.php">
<div class="form-group">  
      <div class="form-control">
      <label for="nombre">Nombre</label>
      <input id="nombre" name="nombre"type="text">
      </div>
      <label for="apellido">Apellido</label>
      <input id="apellido" name="apellido"type="text">
      <label for="edad">Edad</label>
      <input id="edad" name="edad"type="text">
      <select id="tipo_estudio">

          <option value="Secundario">Secundario</opcion>
          <option value="Terciario">Terciario</opcion>
          <option value="Universitario">Universitario</opcion>
    
      </select>
      <label for="sexo">Sexo</label>
      <input id="masculino" type="radio" name="sexo" checked>
      <input id="femenino" type="radio" name="sexo"> 
      <input type="submit" value="Enviar">
</div>
    </form>  
    
</body>
</html>

