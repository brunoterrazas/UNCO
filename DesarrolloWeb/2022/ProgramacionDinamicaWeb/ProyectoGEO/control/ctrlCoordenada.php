<?php
class CtrlCoordenada
{
function validarCoordenada($arreCordenada)
{
    $res=true;
    $i=0;
    $tamanioArre=count($arreCordenada);
  while($i<$tamanioArre&&$res)
   {
      $lat=$arreCordenada[$i]["latitud"];
      $lon=$arreCordenada[$i]["longitud"];

      if(($lat>=-90&&$lat<=90)&&($lon>=-180&&$lon<=180))
      {
        $res=true;
      }
      else{
        $res=false;
      }
      $i++;
   }
   return $res;
}

}

?>