<?php 
//1-.
/**
     * Retorna el factorial de  un numero N
     * INT $fact,$n
     * @param $n
     * @return Int 
     */
 function factorial($n)
 {
    $fact=$n; 
    $n--;
   while($n>=1)
   {
      $fact=$fact*($n);
      $n--;
   }
   echo $fact;

 } 
 //echo factorial(4);
//2-.
/**
     * Dado un numero N, si el numero es par retorna true, sino false
     * INT $n1
     * BOOLEAN $res
     * @param $n1
     * @return Boolean
     */
//echo factorial(4);
 function esPar($n)
 {
   //verifico si es par, si n/2 da como resto 0  
   if($n%2==0)
  { $res=true;   
  }else
   {$res=false;
   }

   return $res;
 }

  //echo esPar(5) ? "true":"false";
 //3-.
/**
     * Dado dos números N y M retornar verdadero si el número N es divisible por M y falso en caso contrario. 
     * INT $n,$m
     * BOOLEAN $res
     * @param $n,$m
     * @return Boolean
     */
    function esDivisible($n,$m)
    {
      //verifico si n/m da como resto 0  
      if($n%$m==0)
     { $res=true;   
     }else
      {$res=false;
      }
   
      return $res;
    }
 //4-. ----------------------------------------------------
/**
     * Dada un arreglo de números enteros, determinar los valores máximo y mínimo
     * y las posiciones en que éstos se encontraban en el arreglo. 
     * ARRAY $arre
     * INT $max,$mix,pos_max,pos_min
     * @param $arre
     * @return void
     */  
     function buscarMaxMin($arre)
    {
      $max=-9999;
      $min=9999;
      $pos_max=-1;
      $pos_min=-1;
      for($key=0;$key<count($arre);$key++)
      {
        $value=$arre[$key];
        //echo $value."y su posicion es $key \n ";
        if($value>=$max)
        {
          $max=$value;
          $pos_max=$key;
        }
        
          
       if ($value<=$min)
        {
          $min=$value;
          $pos_min=$key;
        }
      }
      echo  "La posicion del menor[$min] es $pos_min\ny la posicion de mayor[$max] es $pos_max\n";

    }
    $arre=array(20, 43, 3, 6, 15);
    buscarMaxMin($arre);
//5-. ----------------------------------------------------

/**
     * Retorna un arreglo de nombres,ingresados por teclado
     * ARRAY $arre
     * INT $cantNombres
     * @param $cantNombres
     * @return array
     */
  /*  echo "Metodo para crear un arreglo de nombres\n";  
    
    $cantNombres =validarNumero("la cantidad de nombres:\n");;
    $arre= arregloDeNombres($cantNombres);
   print_r($arre);
*/
 function arregloDeNombres($cantNombres)
 {
  $arre=array();
  for($i=0;$i<$cantNombres;$i++)
  {
    echo "Ingrese nombre\n";
    $nombre = trim(fgets(STDIN));
    $arre[$i]=$nombre;
  }
   return $arre;
 }   
 /**
     * Valida que sea un numero, solo si se cumple, retorna ese valor 
     * FLOAT $valor
     * BOOLEAN $res
     * @param $texto
     * @return Int 
     */
    function validarNumero($texto)
    {

        echo "Ingrese " . $texto . "\n";
        $valor = trim(fgets(STDIN));
        $res = is_numeric($valor);
        while (!$res) {
            echo "¡Error! Ingrese " . $texto . "\n";
            $valor = trim(fgets(STDIN));
            $res = is_numeric($valor);
        }
        return $valor;
    }
  //6-. ----------------------------------------------------
 /**
     * Retorna un arreglo con todos los años bisiestos
     * ARRAY $arre_bisiesto
     * INT $num
     * @param $num
     * @return Array
     */  
 function mostrarAñosBisiestos($num)
 {
   $arre_bisiesto= array();
   for($i=1;$i<=$num;$i++)
   {
   if($i%4==0&&($i%100!=0||$i%400==0))
    {
     $arre_bisiesto[$i-1]=$i;  

    }
  }
  return $arre_bisiesto;
 }
 //$arre=mostrarAñosBisiestos(2400);
// print_r($arre);
//7-. ----------------------------------------------------
 /**
     * Retorna un arreglo conformado por la union de dos arreglos
     * ARRAY $arre_A, $arre_B,$arre_final
     * INT $tamanio
     * @param $arre_A,$arre_B
     * @return Array
     */  
   function unirDosArreglos($arre_A,$arre_B)
   {
     $arreAB=array();
    $tam_N=count($arre_A);
    $tam_M=count($arre_B);
    //Inserto los valores del arreglo A
     for($i=0;$i<$tam_N;$i++)
     {
         $arreAB[$i]=$arre_A[$i];

     }
     
     //Inserto los valores del arreglo B
     for($i=0;$i<$tam_M;$i++)
     {
         $arreAB[$i+$tam_N]=$arre_B[$i];
     }
      return $arreAB;
   }
   $arre1=array(2, 3, 4, 20, 15);
   $arre2=array(20, 43, 5, 6, 17);
 $arre=unirDosArreglos($arre1,$arre2);
 print_r($arre);
//8-. ----------------------------------------------------
 /**
     * Retorna un arreglo con los valores que pertenecen al arreglo A que no pertenecen al arreglo B(A-B)
     * ARRAY $arre_A, $arre_B,$arre_final
     * INT $tamanio
     * @param $arre_A,$arre_B
     * @return Array
     */  
    function restarDosArreglos($arre_A,$arre_B)
    {
      $arreA_B=array();
     $tam_N=count($arre_A);
     $tam_M=count($arre_B);
     //Inserto los valores del arreglo A
     for($i=0;$i<$tam_N;$i++ )
      {
      $elem=$arre_A[$i];
      $cant=verificarElemento($arre_B,$elem);
      }
    return $arreA_B;
  }
    /**
     * retorna la cantidad de veces encuentra
     * un elemento dentro del arreglo
     * ARRAY $arre_A
     * String elem
     * INT $cont
     * @param $arre,$elem
     * @return boolean 
     */  
    function verificarElemento($arre,$elem)
    { 
      $cont=0;
      foreach( $arre as $key => $value ) {
        if($value==$elem)
        {
          $cont++;
        }
      return $cont;
    }

    } 
    $arre1=array(2, 3, 4, 20, 15);
    $arre2=array(20, 43, 5, 6, 17);
  $arre=restarDosArreglos($arre1,$arre2);
  print_r($arre);



//------------------------------------------------------------
?>