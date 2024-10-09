<?php 
class Equipo
{
  private $nombre;
  private $nombreCapitan;
  private $objCategoria;
  private $cantJugadores;
  public function __construct($nom,$nomCapitan,$refCategoria,$cantJ)
  {
      $this->nombre=$nom;
      $this->nombreCapitan=$nomCapitan;
      $this->objCategoria=$refCategoria;
      $this->cantJugadores=$cantJ;
  }

  public function getNombre()
  {
    return $this->nombre;
  }

  public function setNombre($nombre)
  {
    $this->nombre = $nombre;
  }

  public function getNombreCapitan()
  {
    return $this->nombreCapitan;
  }

  public function setNombreCapitan($nombreCapitan)
  {
    $this->nombreCapitan = $nombreCapitan;

    return $this;
  }
  public function getObjCategoria()
  {
    return $this->objCategoria;
  }
  public function setObjCategoria($objCategoria)
  {
    $this->objCategoria = $objCategoria;
  }
  public function __toString()
  {
      $cadena="Nombre del equipo: ".$this->getNombre()." Capitan: ".$this->getNombreCapitan()."\n";
      $cadena.=$this->getObjCategoria()->__toString();

      return $cadena;
  }

  public function getCantJugadores()
  {
    return $this->cantJugadores;
  }
  public function setCantJugadores($cantJugadores)
  {
    $this->cantJugadores = $cantJugadores;
  }
  public function chequearCategoria($refEquipo)
   {
     return $this->getObjCategoria()==$refEquipo->getObjCategoria();
   }
}



?>