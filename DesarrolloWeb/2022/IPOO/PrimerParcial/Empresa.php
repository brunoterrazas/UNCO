<?php 
class Empresa
{
  private $identificacion;
  private $nombre;
  private $colObjViajes;
  public function __construct($ide,$nom,$objColViajes)
  {
      $this->identificacion=$ide;
      $this->nombre=$nom;
      $this->colObjViajes=$objColViajes;
  }
  public function getIdentificacion()
  {
    return $this->identificacion;
  }

  public function setIdentificacion($identificacion)
  {
    $this->identificacion = $identificacion;
  }
  public function getNombre()
  {
    return $this->nombre;
  }
  public function setNombre($nombre)
  {
    $this->nombre = $nombre;
  }
  public function getColObjViajes()
  {
    return $this->colObjViajes;
  }
  public function setColObjViajes($objColViajes)
  {
    $this->colObjViajes = $objColViajes;
  }
  public function darViajeADestino($destino,$cantAsientos)
  {
      $colViajesDisponibles=[];
      $pos=0;
      for($i=0;$i<count($this->getColObjViajes());$i++)
      {
          $tieneEspacio=$this->getColObjViajes()[$i]->asignarAsientosDisponibles($cantAsientos);
          if($tieneEspacio&&($this->getColObjViajes()[$i]->getDestino())==$destino)
          {
            $colViajesDisponibles[$pos]=$this->getColObjViajes()[$i];
              $pos++;
          }
 

      }
      return  $colViajesDisponibles;

  }
  public function incorporarViaje()
  {
    

  }
  public function __toString()
  {
      $cadena="EMPRESA\n";

      $cadena.="Identificación: ".$this->getIdentificacion()." Nombre empresa: ".$this->getNombre()."\n";

     foreach($this->getColObjViajes() as $objViaje) 
     {
       $cadena.= $objViaje->__toString();

     }
      return $cadena;
  }
  public function responsableViaje($numViaje)
  {
    $responsable=null;
    foreach($this->getColObjViajes() as $objViaje) 
    {
      if($objViaje->getNumero()==$numViaje)
      {
         $responsable=$objViaje->getObjResponsable();
      }
    }
    return $responsable;
  }

}


?>