<?php
class Basket extends Partido
{
  private $cantInfracciones;
  public function __construct($equipo1,$equipo2,$fecha,$id,$cantG1,$cantG2,$cantJ,$cantInfracciones)
  {
      parent :: __construct($equipo1,$equipo2,$fecha,$id,$cantG1,$cantG2,$cantJ);
      $this->cantInfracciones=$cantInfracciones;
      
  }
  public function coeficientePartido()
  {
      $coef=parent :: coeficientePartido();     
      $coef=$coef-0.75*$this->getCantInfracciones();
      return $coef;
  } 
  public function getCantInfracciones()
  {
    return $this->cantInfracciones;
  }

  public function setCantInfracciones($cantInfracciones)
  {
    $this->cantInfracciones = $cantInfracciones;
  }
  public function __toString()
  {
    $cadena=parent :: __toString();
    $cadena.="\nInfracciones: ".$this->getCantInfracciones(); 
    return $cadena;
  }
}
?>