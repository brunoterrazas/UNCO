<?php 
class Nacional extends Torneo{
public function __construct($id,$premio,$colPartidos)
   {
       parent :: __construct($id,$premio,$colPartidos);
   }
   public function obtenerPremioTorneo()
   {
      
      $premio=parent ::obtenerPremioTorneo();
      return $premio*1.10;
   }
}

?>