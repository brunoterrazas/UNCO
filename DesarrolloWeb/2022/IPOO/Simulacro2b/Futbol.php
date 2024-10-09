<?php 
class Futbol extends Partido
{
   
   public function __construct($equipo1,$equipo2,$fecha,$id,$cantG1,$cantG2,$cantJ)
   {
       parent :: __construct($equipo1,$equipo2,$fecha,$id,$cantG1,$cantG2,$cantJ);
   }
   public function coeficientePartido()
   {
       $coef=parent :: coeficientePartido();
       //Asumiento que ambos equipos son de la misma categoria
       $coefCat=($this->getObjEquipo1()->getCategoria())->getCoeficiente();
       $coef=$coef*$coefCat;
       return $coef;
   } 
   
}

?>