<?php 
class Viaje{
private $numero;
private $destino;
private $hora_partida;
private $hora_llegada;
private $fecha;
private $monto;
private $cant_asientos_total;
private $cant_asientos_disponible;
private $objResponsable;
public function __construct($num,$destino,$hora_partida,$hora_llegada,$fecha,$monto,$cant_total,$objResponsable)
{
  $this->numero=$num;
  $this->destino=$destino;
  $this->hora_partida=$hora_partida;
  $this->hora_llegada=$hora_llegada;
  $this->fecha=$fecha;
  $this->monto=$monto;
  $this->cant_asientos_total=$cant_total;
  $this->cant_asientos_disponible=$cant_total;
  $this->objResponsable=$objResponsable;
}



public function getNumero()
{
return $this->numero;
}


public function setNumero($numero)
{
$this->numero = $numero;

}

public function getDestino()
{
return $this->destino;
}

public function setDestino($destino)
{
$this->destino = $destino;
}

public function getHoraPartida()
{
return $this->hora_partida;
}

public function setHoraPartida($hora_partida)
{
$this->hora_partida = $hora_partida;
}

public function getHoraLlegada()
{
return $this->hora_llegada;
}

public function setHoraLlegada($hora_llegada)
{
$this->hora_llegada = $hora_llegada;
}

public function getFecha()
{
return $this->fecha;
}
public function setFecha($fecha)
{
$this->fecha = $fecha;
}

public function getMonto()
{
return $this->monto;
}

public function setMonto($monto)
{
$this->monto = $monto;
}

public function getCantAsientosTotal()
{
return $this->cant_asientos_total;
}

public function setCantAsientosTotal($cant_asientos_total)
{
$this->cant_asientos_total = $cant_asientos_total;

return $this;
}

public function getCantAsientosDisponible()
{
return $this->cant_asientos_disponible;
}

public function asignarAsientosDisponibles($cantAsientos)
{ 
    $res=false;
    if($cantAsientos<=$this->getCantAsientosDisponible())
    {
        $this->setCantAsientosDisponible($this->getCantAsientosDisponible()-$cantAsientos);
        $res=true;
    }

  return $res;
}
public function setCantAsientosDisponible($cant_asientos_disponible)
{
$this->cant_asientos_disponible =$this->cant_asientos_disponible- $cant_asientos_disponible;
}

public function getObjResponsable()
{
return $this->objResponsable;
}

public function setObjResponsable($objResponsable)
{
$this->objResponsable = $objResponsable;
}
public function __toString()
{
  $cadena="DETALLE VIAJE\n ";
  $cadena.="Num. viaje: ".$this->getNumero()."Num. viaje: ".$this->getNumero()." Destino: ".$this->getNumero()." Fecha: ".$this->getFecha()." Hora de partida: ".$this->getHoraPartida()." Hora de llegada: ".$this->getHoraLlegada()."\nMonto: ".$this->getMonto()." Cantidad de asientos disponibles: ".$this->getCantAsientosDisponible()." Cantidad de asientos Total: ".$this->getCantAsientosTotal()."\n";
  $cadena.="Datos Responsable de viaje:\n";
  $cadena=$cadena.($this->getObjResponsable()->__toString())."\n";
  
  return $cadena;
    
}
}
?>