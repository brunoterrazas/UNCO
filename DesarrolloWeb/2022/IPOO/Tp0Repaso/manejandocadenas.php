<?php 
//1
/**
     * Retorna la cantidad de caracteres de 
     * una cadena cada vez que termina en punto
     * String cadena
     * INT $cont
     * BOOLEAN $encontrado
     * @param $cadena,$caracter
     * @return Int
     */ 
    
     function cantCaracteres($cadena,$caracter)
     {
        // Recorremos cada carácter de la cadena
        $i=0;
        $cont=0;
        $salir=false;
        $tam_cad=strlen($cadena);
        while(($i<$tam_cad)&&!$salir)
        {
            $val=$cadena[$i];
            if($val!=$caracter)
            {
                if(trim($val))
                $cont++;
            }
            else{
                
                $salir=true;
            }
            $i++;
            if($tam_cad==$i)
            $salir=true;
        }
       return $cont;
     }
     /*$cadena="la web del programador.";
     $cant=cantCaracteres($cadena,".");
     echo $cant;*/
//2
/**
     * Dado un texto terminado en / y un caracter, determina cuántas
     * veces aparece ese caracter en la cadena.
     * String cadena
     * INT $cont
     * BOOLEAN $encontrado
     * @param $cadena,$caracter
     * @return Int
     */ 
    
    function contCaracter($cadena,$limite,$caracter)
    {
       // Recorremos cada carácter de la cadena
       $i=0;
       $cont=0;
       $tam_cad=$limite;
       while($i<$tam_cad)
       {
           $val=$cadena[$i];
           if($val==$caracter)
           {
               
               $cont++;
           }
           
           $i++;
    
       }
      return $cont;
    }
    function cantRepeticiones($cadena,$caracter)
    {
// Recorremos cada carácter de la cadena
$i=0;
$cont=0;
$salir=false;
$tam_cad=strlen($cadena);

while(($i<$tam_cad)&&!$salir)
{
    $val=$cadena[$i];
    
    if($i>0)
    $val_anterior=$cadena[($i-1)];
    
    if($val==$caracter)
    {
        $cont=contCaracter($cadena,$i,$val_anterior);
        $salir=true;
    }
   
    if($tam_cad==$i)
    $salir=true;

    $i++;

}

  return $cont;
    }
    /*
    $cadena="la web del progre/amadora.";
    echo $cadena;
    $cant= cantRepeticiones($cadena,"/");
    echo "se repite ".$cant." veces";

    */

?>