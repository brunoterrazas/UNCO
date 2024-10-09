
<?php 
/*Modificar el formulario del ejercicio anterior para que permita seleccionar los diferentes
deportes que practica (futbol, basket, tennis, voley) un alumno. Mostrar en la página
que procesa el formulario la cantidad de deportes que practica. */
?>
<form method="POST" action="mostrarDeportes.php">
<div class="form-group">  
      <div class="form-control">
      <label for="nombre">Nombre</label>
      <input id="nombre" name="nombre"type="text">
      </div>
      <div class="form-group">  
      <label for="apellido">Apellido</label>
      <input id="apellido" name="apellido"type="text">
      <label for="edad">Edad</label>
      <input id="edad" name="edad"type="number">
      </div>
      <div class="form-group">  
      <select id="tipo_estudio">

          <option value="Secundario">Secundario</opcion>
          <option value="Terciario">Terciario</opcion>
          <option value="Universitario">Universitario</opcion>
    
      </select>
      </div>
      <div class="form-group">  
      <label for="sexo">Sexo</label>
      <input id="masculino" type="radio" name="sexo" checked>
      <input id="femenino" type="radio" name="sexo"> 
      
      <label for="deporte">Seleccione deportes que practica</label>
      <input type="checkbox" name="deporte[]" value="Futbol">Futbol<br>      
      <input type="checkbox" name="deporte[]" value="Basket">Basket<br>      
      <input type="checkbox" name="deporte[]" value="Tennis">Tennis<br>      
      
    </div>
      
        <!-- 
            https://www.baulphp.com/procesar-multiple-checkbox-seleccionados/
            https://www.ardepizando.com/que-es-vanilla-js/

            https://codepen.io/juff03/pen/OXaXRG
        -->
      <input name="submit" type="submit" value="Enviar">
</div>
    </form>  
    