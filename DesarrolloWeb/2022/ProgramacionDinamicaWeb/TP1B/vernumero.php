<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>VER NUMERO</title>
</head>
<body>
<?php

if(($_POST)&&isset($_POST["valor"])&&$_POST["valor"]!="")
{
    $numero=  $_POST["valor"];

    if($numero==0)
    {
        echo "El numero $numero es igual a 0";
    }
    else{
     if($numero>0)
      {
          echo "El numero $numero es positivo";

      }
      else
          echo "El numero $numero es negativo";
        
   }
}
else{
    
header('Location: Ej1.php?error');

exit;
}
?>   
<a href="Ej1.php">volver</a>
</body>
</html>