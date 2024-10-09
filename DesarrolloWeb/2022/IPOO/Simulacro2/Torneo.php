<?php
class Torneo
{
   private $colPartidos;
   private $premio;
   public function __construct($premio)
   {
       $this->colPartidos=[];
       $this->premio=$premio;
   }

   public function getColPartidos()
   {
      return $this->colPartidos;
   }

   public function setColPartidos($colPartidos)
   {
      $this->colPartidos = $colPartidos;
   }
   
   public function getPremio()
   {
      return $this->premio;
   }

  
   public function setPremio($premio)
   {
      $this->premio = $premio;

   }
   public function ingresarPartido($objEquipo1,$objEquipo2,$fecha,$tipo)
   {
      $objPartido=null;
     if($this->compararEquipos($objEquipo1,$objEquipo2))
    {
      $arrePartidos=$this->getColPartidos(); 
      if($tipo=="futbol")
      {
        $objPartido=new Futbol($objEquipo1,$objEquipo2,$fecha,count($this->getColPartidos()),0,0,11);
        $arrePartidos[]=$objPartido;
      }
      if($tipo=="basket")
      {//sino es tipo de Basquet
       $objPartido=new Basket($objEquipo1,$objEquipo2,$fecha,count($this->getColPartidos()),0,0,11,0);
       $arrePartidos[]=$objPartido;
      }

    }
   return $objPartido;
   }
   public function compararEquipos($objEquipo1,$objEquipo2)
   {
       $res=false;
       $cantJugadoresE1=$objEquipo1->getCantJugadores();      
       $cantJugadoresE2=$objEquipo2->getCantJugadores();
      if($objEquipo1->chequearCategoria($objEquipo2)&&($cantJugadoresE1==$cantJugadoresE2))
      {
          $res=true;
      }
    return $res;
   }
   /*Retorna un coleccion con los equipos ganadores 
     deporte debe ser: Futbol o Basquet 
   */
   public function darGanadores($deporte)
   {
      if($deporte=="futbol")
      $deporte="Futbol";      
      if($deporte=="basket")
      $deporte="Basket";
      
      $colGanadores=array();
     foreach($this->getColPartidos() as $objPartido )
     {
      if (is_a($objPartido,$deporte))
      {
         $ganador=$objPartido->verificarGanador();
         //Si hay un ganador
         if($ganador!=null)
         {  //lo agrego a la colección
            $colGanadores[]=$ganador;
         }
      }
     }
     return $colGanadores;
   }
   public function calcularPremioPartido($objPartido)
   {
      $arrePremio=[];
      $ganador=$objPartido->verificarGanador();
      if($ganador!=null)
      {
       $arrePremio["equipoGanador"]=$ganador;       
       $arrePremio["premio"]= $objPartido->coeficientePartido()*$this->getPremio();
      }
      else{
         $arrePremio["equipoGanador"]=null;       
         $arrePremio["premio"]= $objPartido->coeficientePartido()*$this->getPremio();
           
      }  
      return $arrePremio;
   }
   public function __toString()
   {
      $cadena="Torneo\n";
      $cadena.="Premio: ".$this->getPremio()."\n";
      foreach($this->getColPartidos() as $objPartido)
      {
      $cadena.=$objPartido->__toString();
      }
      return $cadena;
   } 
 
}

?>