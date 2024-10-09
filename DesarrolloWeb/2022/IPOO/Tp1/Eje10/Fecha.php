<?php 
class Fecha{
  private $anio;
  private $mes;
  private $dia; 
  
  
  public function  __construct($dia,$mes,$anio)
  {
    // Metodo constructor de la clase Calculadora
    $this->dia = $dia;
    $this->mes = $mes;
    $this->anio = $anio;
}

  /**
   * Get the value of dia
   */
  public function getDia() 
  {
    return $this->dia;
  }

  /**
   * Get the value of mes
   */
  public function getMes() 
  {
    return $this->mes;
  }

  /**
   * Get the value of anio
   */
  public function getAnio() 
  {
    return $this->anio;
  }

  /**
   * Set the value of dia
   */
  public function setDia($dia)
  {
    $this->dia = $dia;

    return $this;
  }
   /**
   * Set the value of mes
   */
  public function setMes($mes)
  {
    $this->mes = $mes;

    return $this;
  }
  /**
   * Set the value of anio
   */
  public function setAnio($anio)
  {
    $this->anio = $anio;

    return $this;
  }

 

}



?>