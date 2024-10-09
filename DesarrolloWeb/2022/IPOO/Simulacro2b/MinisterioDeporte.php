<?php
class MinisterioDeporte
{
    private $anio;
    private $colTorneos;
    public function __construct($anio,$colTorneos)
    {
        $this->anio=$anio;
        $this->colTorneos=$colTorneos;
    }

    public function getAnio()
    {
        return $this->anio;
    }

    public function setAnio($anio)
    {
        $this->anio = $anio;
    }

    public function getColTorneos()
    {
        return $this->colTorneos;
    }

    public function setColTorneos($colTorneos)
    {
        $this->colTorneos = $colTorneos;
    }
    /*
    6. Implementar   el   método  registrarTorneo($ColPartidos,$tipo,$ArrayAsociativo)  en   la   
    clase MinisterioDeporte que recibe la colección de partidos que se van a jugar en el torneo,
    el tipo que indica si es nacional o  provincial y un arreglo asociativo cuyas claves van a coincidir
    con la info necesaria para crear el torneo dependiendo su tipo. El método debe retornar la instancia
    de la clase Torneo creada según corresponda.    
     */
    public function registrarTorneo($ColPartidos,$tipo,$ArrayAsociativo)
    {
      $exito=false;
      if($tipo=="nacional")
      {
        $idTorneo=$ArrayAsociativo["idTorneo"];
        $premio=$ArrayAsociativo["premio"];
        $objTorneo=new Nacional($idTorneo,$premio,$ColPartidos);
       
      $exito=true;
        }

      else if($tipo=="provincial")
      {
        $idTorneo=$ArrayAsociativo["idTorneo"];
        $premio=$ArrayAsociativo["premio"];
        $provincia=$ArrayAsociativo["provincia"];
        
        $objTorneo=new Provincial($idTorneo,$premio,$ColPartidos,$provincia);
      
        $exito=true;
      }
      if($exito)
      {
          $arreTorneo=$this->getColTorneos();
          $arreTorneo[]=$objTorneo;
          $this->setColTorneos($arreTorneo);
      }
       


      return $exito;
    }
}

?>