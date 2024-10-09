<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calcular horas de PWD</title>
</head>
<body>
<?php /*
Crear una página php que contenga un formulario HTML que permita ingresar las horas
de cursada, de la materia Programación Web Dinámica, por cada día de la semana.
Enviar los datos del formulario por el método Get a otra página php que los reciba y
complete un array unidimensional. Visualizar por pantalla la cantidad total de horas que
se cursan por semana.*/
?>
    
      <form method="GET" action="mostrarHoras.php">
      <label for="lunes">Cantidad horas Lunes:</label>
      <input id="lunes"name="lunes" type="number" value="0"/>
      </br>
      <label for="martes">Cantidad horas Martes:</label>
      <input id="martes"name="martes" type="number"value="0"/>
      </br>
      <label for="miercoles">Cantidad horas Miercoles:</label>
      <input id="miercoles"name="miercoles" type="number"value="0"/>
      </br>
      <label for="jueves">Cantidad horas Jueves:</label>
      <input id="jueves"name="jueves" type="number"value="0"/>
      </br>
      <label for="viernes">Cantidad horas Viernes:</label>
      <input id="viernes"name="viernes" type="number"value="0"/>
      </br>
      <input type="submit" value="Enviar">
    </form>  
</body>
</html>
