<?php 

class Prestamo
{
   private $identificacion;
   private $codigo_electrodomestico;
   private $fecha_otorgada;
   private $monto;
   private $cantidad_cuotas;
   private $taza_interes;
   private $colObjCuotas;
   private $objPersona;

   public function __construct($identificacion,$cod_electrodomestico,$monto,$cant_cuotas,
      $taza_interes,$objPersona)
    {
      $this->identificacion = $identificacion;
      $this->codigo_electrodomestico = $cod_electrodomestico;
      $this->monto = $monto;
      $this->colObjCuotas = [];
      $this->cantidad_cuotas = $cant_cuotas;
      $this->taza_interes = $taza_interes;
      $this->objPersona = $objPersona;
   }
   /**
    * Registra la fecha otorgada y las cuotas del prestamo 
    * @param Int $cant_cuotas
    * @return void
    */
   public function otorgaPrestamo($cant_cuotas)
   {
      $hoy = date('d-m-Y');
      $this->setFechaOtorgada($hoy);
      $this->setColObjCuotas($this->calcularInteresPrestamo($cant_cuotas));
   }
   public function getIdentificacion()
   {
   return $this->identificacion;
   }
   public function getCodigoElectrodomestico()
   {
      return $this->codigo_electrodomestico;    
   }
   public function getFechOtorgada()
   {
      return $this->fecha_otorgada;
   }
   public function getMonto()
   {
      return $this->monto;         
   }
   public function getCantidadCuotas()
   {
     return $this->cantidad_cuotas;
   }
   public function getTaza_interes()
   {
      return $this->taza_interes;
   }
   public function getColObjCuotas()
   {
      return $this->colObjCuotas;
   }
   public function getObjPersona()
   {
      return $this->objPersona;
   }
   //modificadores
   public function setIdentificacion($identificacion)
   {
      $this->identificacion=$identificacion;
   }
   public function setCodigoElectrodomestico($cod_electrodomestico)
   {
     $this->codigo_electrodomestico=$cod_electrodomestico;
   }
   public function setFechaOtorgada($fecha)
   {
      $this->fecha_otorgada=$fecha;
   }
   public function setMonto($monto)
   {
      $this->monto=$monto;
   }
   public function setColObjCuotas($colObjCuotas)
   {
     $this->colObjCuotas=$colObjCuotas;
   }
   public function setObjPersona($persona)
   {
      $this->objPersona=$persona;
   }
   public function verificarPrestamo()
   {
      $res=false;
      $porcentajeNeto=40;
      $monto=$this->getMonto();
      $cantidad_cuotas=$this->getCantidadCuotas();
      if(($monto/$cantidad_cuotas)<=($this->objPersona->getNeto()*$porcentajeNeto/100))  
      {
        $res=true;
      }
    return $res;
   }
   /**
    * Calcula el interes y la cantidad de cuotas a pagar, retorna una coleccion de objetos de la clase Cuota 
    * @param Int $cant_cuotas
    * @return array 
    */
   private function calcularInteresPrestamo($cant_cuotas)
   {
      $cuotas = array();
      $monto=$this->getMonto();
      $monto_cuota=$monto/$cant_cuotas;
      $taza_interes=$this->getTaza_interes();
      $monto_interes=($monto*($taza_interes/100));
      $numCuota=0;
      
      $cuotas[$numCuota] = new Cuota($numCuota+1,$monto_cuota,$monto_interes);
      $numCuota++;
      while($numCuota<$cant_cuotas)
      {
         $monto_interes=($monto-(($monto/$cant_cuotas)*$numCuota))*($taza_interes/100);
         $cuotas[$numCuota] = new Cuota($numCuota+1,$monto_cuota,$monto_interes);
         $numCuota++;
      }
  
      return $cuotas;
   }
    public function __toString()
    {
       $cadena="Detalle prestamo:\n";

       $cadena.="Datos cliente:".$this->getObjPersona()->__toString()."\n".
                "Id: ".$this->getIdentificacion()." Cod. Electrodomestico: ".$this->getCodigoElectrodomestico().
                " Monto: ".$this->getMonto()." Fecha ortogada: ".$this->getFechOtorgada()."\n";
                "Cuotas a Pagar\n";
               
                foreach($this->getColObjCuotas() as $cuota)
                {
                    $cadena.=$cuota->__toString()."\n";
                }
               

                return $cadena;


    }
    public function darSiguienteCuotaPagar()
    {
       $cant_cuotas=count($this->getColObjCuotas());
       $i=0;
       $sin_pagar=false; 
       $cuota=null;     
          while($i<$cant_cuotas&&!$sin_pagar)
          {
            $cuota=$this->getColObjCuotas()[$i];
            if(!$cuota->getIsCancelado())
                  $sin_pagar=true;

            $i++;      
          }
          
          return $cuota;
    }
}
