<?php 

class Cuota
{
   private $numero;
   private $monto_cuota;
   private $monto_interes;
   private $isCancelada;
   public function __construct($numero,$monto,$monto_interes)
   {
       $this->numero=$numero;
       $this->monto_cuota=$monto;
       $this->monto_interes=$monto_interes;
       $this->isCancelada=false;
   }
   //vizualizadores
   public function getNumero()
   {
       return $this->numero;
   }

   
   public function getMontoCuota()
   {
       return $this->monto_cuota;
   }
   public function getMonto_interes()
   {
       return $this->monto_interes;
   }
   public function getIsCancelado()
   {
     return $this->isCancelada;
   }
    public function darMontoFinalCuota()
    {
        return $this->getMontoCuota()+$this->getMonto_interes();
    }
   //modificadores
   public function setNumero($unNumero)
   {
     $this->numero=$unNumero;
   }
   public function setMonto($unMonto)
   {
     $this->monto=$unMonto;
   }
   public function setIsCancelado($val)
   {
       $this->isCancelada=$val;
   }
   public function __toString()
   {
       $cadena= "Num: ".$this->numero." Monto interes: ".$this->monto_interes." Monto: ".$this->monto_cuota;
       return $cadena;
    }
}

?>