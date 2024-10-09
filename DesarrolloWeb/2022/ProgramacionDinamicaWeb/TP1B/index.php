<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TP 2 </title>
</head>
<body>
<form method="GET" action="mostrarDatosEstudio.php">
<div class="form-group">  
      <div class="form-control">
      <label for="nombre">Nombre</label>
      <input id="nombre" name="nombre"type="text">
      </div>
      <label for="apellido">Apellido</label>
      <input id="apellido" name="apellido"type="text">
      <label for="edad">Edad</label>
      <input id="edad" name="edad"type="number">
      <select id="tipo_estudio">

          <option value="Secundario">Secundario</opcion>
          <option value="Terciario">Terciario</opcion>
          <option value="Universitario">Universitario</opcion>
    
      </select>
      <label for="sexo">Sexo</label>
      <input id="masculino" type="radio" name="sexo" checked>
      <input id="femenino" type="radio" name="sexo"> 
      <input type="submit" value="Enviar">
      <label for="sexo">Seleccione deportes que practica</label>
      <input type="checkbox" name="deporte" value="Futbol">Futbol<br>      
      <input type="checkbox" name="deporte" value="Basket">Basket<br>      
      <input type="checkbox" name="deporte" value="Tennis">Tennis<br>      
        <!-- 
            https://www.baulphp.com/procesar-multiple-checkbox-seleccionados/
            https://www.ardepizando.com/que-es-vanilla-js/
        -->
      <input type="submit" value="Enviar">
</div>
    </form>  
</body>
</html>