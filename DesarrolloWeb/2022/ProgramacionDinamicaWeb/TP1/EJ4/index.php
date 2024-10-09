<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="$a-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ej3</title>
</head>
<body>
    
<?php 
 /*
 Realizar un programa que, a partir de tres variables enteras llamadas $a, $b  $c,
  muestre por pantalla el valor de la mayor $b la menor de ellas
 */
$a=15;
$b=94;
$c=73;
$mayor=-9999999;
$menor=9999999;
if($a>$b&&$a>$c)
  {
   $mayor=$a;   
      if($b>$c)
    {
      $menor=$c;
    }
   else
    {
     $menor=$b;
    }
    
  }
 else{
      if($b>$a&&$b>$c)
       {
         $mayor=$b;              
        if($a>$c)
        {
        $menor=$c; 
        } 
        else{
         $menor=$a;  
        }
       }
          
     
  else{
     if($c>$a&&$c>$b)
      {
        $mayor=$c;
       if($a>$b)
        {
        $menor=$b;     
        }
       else{
        $menor=$a;
        }
      }
    }
 }
 echo "El Mayor es ".$mayor."<br>";
 echo "El Menor es ".$menor."<br>";
 ?>
</body>
</html>