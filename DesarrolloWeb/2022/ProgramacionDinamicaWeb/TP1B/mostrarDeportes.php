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
 
        if(isset($_POST['submit'])){//Validacion de envio de formulario
            if(!empty($_POST['deporte'])){
            // Ciclo para mostrar las casillas checked checkbox.
            foreach($_POST['deporte'] as $selected){
            echo $selected."</br>";// Imprime resultados
            }
            }
            }


    
    ?>
</body>
</html>