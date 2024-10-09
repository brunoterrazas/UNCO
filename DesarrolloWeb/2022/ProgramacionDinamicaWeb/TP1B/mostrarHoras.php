
<?php 

if($_GET)
{
   $arre=[];
   $arre[0]=$_GET["lunes"];
   $arre[1]=$_GET["martes"];
   $arre[2]=$_GET["miercoles"];
   $arre[3]=$_GET["jueves"];
   $arre[4]=$_GET["viernes"];
   echo "La cantidad de horas de PWD es ".sumarArray($arre);
  }
function sumarArray($arre)
{
    
    $suma=0;
   for($i=0;$i<count($arre);$i++)
   {
        $suma=$suma+$arre[$i]; 
   }
   return $suma;
}

?>