<?php 

class Partido
{
  private $idPartido;
  private $fecha;
  private $objEquipo1;
  private $objEquipo2;
  private $cantGolesE1;
  private $cantGolesE2;
  public function __construct($equipo1,$equipo2,$fecha,$id,$cantG1,$cantG2)
  {
      $this->objEquipo1=$equipo1;
      $this->objEquipo2=$equipo2;
      $date = date_create($fecha);
      $this->fecha=date_format($date,"d-m-Y");
      $this->idPartido=$id;
      $this->cantGolesE1=$cantG1;
      $this->cantGolesE2=$cantG2;      
  }

  public function getObjEquipo1()
  {
    return $this->objEquipo1;
  }

  public function setObjEquipo1($objEquipo1)
  {
    $this->objEquipo1 = $objEquipo1;

    return $this;
  }
  public function getObjEquipo2()
  {
    return $this->objEquipo2;
  }

  public function setObjEquipo2($objEquipo2)
  {
    $this->objEquipo2 = $objEquipo2;
  }

  public function getIdPartido()
  {
    return $this->idPartido;
  }

  public function setIdPartido($idPartido)
  {
    $this->idPartido = $idPartido;
  }
  public function getFecha()
  {
    return $this->fecha;
  }

  public function setFecha($fecha)
  {
    $this->fecha = $fecha;

  }

  public function getCantGolesE1()
  {
    return $this->cantGolesE1;
  }

  public function setCantGolesE1($cantGolesE1)
  {
    $this->cantGolesE1 = $cantGolesE1;
  }
  public function getCantGolesE2()
  {
    return $this->cantGolesE2;
  }
  public function setCantGolesE2($cantGolesE2)
  {
    $this->cantGolesE2 = $cantGolesE2;
  }
  public function __toString()
  {
      $cadena="";
      $cadena.="Id Partido: ".$this->getIdPartido()." Fecha: ".$this->getFecha()."\n";
      $cadena.="Equipo 1\n".$this->getObjEquipo1()->__toString();
      $cadena.="Equipo 2\n".$this->getObjEquipo2()->__toString(); 
      $cadena.="Cantidad de goles Equipo 1: ".$this->getCantGolesE1();      
      $cadena.=" Cantidad de goles Equipo 2: ".$this->getCantGolesE1();
       
      return $cadena;
  }
  public function coeficientePartido()
  {   
      $cantJugsE1=$this->getObjEquipo1()->getCantJugadores();
      $cantJugsE2=$this->getObjEquipo2()->getCantJugadores();
      $coef=0.5*($cantJugsE1+$cantJugsE2)*($this->getCantGolesE1()+$this->getCantGolesE2());
      return $coef;
  } 
  public function verificarGanador()
  {
    if($this->getCantGolesE1()==$this->getCantGolesE2())
    {
      $arrayAsoc=null;
    }
    else {
         if($this->getCantGolesE1()>$this->getCantGolesE2())
           {
            $ganador=$this->getObjEquipo1();
            $arrayAsoc["ganador"]=$ganador;
            $arrayAsoc["cantGoles"]=$this->getCantGolesE1();
           }
         else{
          $ganador=$this->getObjEquipo2();
          $arrayAsoc["ganador"]=$ganador;
          $arrayAsoc["cantGoles"]=$this->getCantGolesE2();
             }
  }
    return $arrayAsoc;
  }


}

?>