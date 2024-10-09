<?php
class Torneo
{
   private $idTorneo;
   private $premio;
   private $colPartidos;

   public function __construct($id,$premio, $colPartidos)
   {
      $this->idTorneo=$id;
       $this->colPartidos=$colPartidos;
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
   /* Retorna un array asociativo con el equipo ganador del torneo */
   public function darGanadores()
   {
      $colGanadores=array();
      $i=0;
      foreach($this->getColPartidos() as $objPartido )
     {
        
   
         $arrayGanador=$objPartido->verificarGanador();
 
         if($arrayGanador!=null)
         { 
            //Verifico si el ganador esta registrado
            $pos=$this->buscarEnArreglo($colGanadores,$arrayGanador["ganador"]);
            if($pos==-1)
            {
            //lo agrego a la colección
            $colGanadores[$i]["objGanador"]=$arrayGanador["ganador"];
            $colGanadores[$i]["cantPartidosGanados"]=1;
            $colGanadores[$i]["cantGoles"]=$arrayGanador["cantGoles"];
            }
            else
            {
            $colGanadores[$pos]["cantPartidosGanados"]=$colGanadores[$pos]["cantPartidosGanados"]+1;
            $colGanadores[$pos]["cantGoles"]=$colGanadores[$pos]["cantGoles"]+$arrayGanador["cantGoles"];
            }
            
            $i++;
         }
    
     }
     return $colGanadores;

   }
   public function obtenerEquipoGanadorTorneo()
   {
      
      $colGanadores=$this->darGanadores();
      $mayor=0;
      $posMayor=0;
      foreach($colGanadores as $key=>$value)
     {
       if($value["cantPartidosGanados"]>$mayor)
       { 
          $mayor=$value["cantPartidosGanados"];
          $posMayor=$key; 
       } 
    
     }
     
     $arrayGanador["ganador"]=$colGanadores[$posMayor]["objGanador"];
     $arrayGanador["cantPartidosGanados"]=$colGanadores[$posMayor]["cantPartidosGanados"];
     $arrayGanador["cantGoles"]=$colGanadores[$posMayor]["cantGoles"];

     return $arrayGanador;
   }
   public function buscarEnArreglo($colGanadores,$objGanador)
   {
      $i=0;
      $pos=-1;
      $esta=false;
      if(!empty($colGanadores))
      {
       while($i<count($colGanadores)&& !$esta)
       {
          if($colGanadores[$i]["objGanador"]==$objGanador)
          {
             $esta=true;
             $pos=$i;
          }
          $i++;
       }
     }
    return $pos;
   }

   /*
    
   5. Implementar el método  obtenerPremioTorneo() en la clase  Torneo que 
   calcula el premio económico que debe ser otorgado al equipo ganador del Torneo Provincial 
   o Nacional. 
   El premio económico es otorgado al equipo que ha ganado mas partidos, 
   y si se trata de un torneo Nacional al premio económico se adiciona
   el 10% del monto del premio  por la cantidad de partidos ganados. Redefinir el método
   cuando lo considere necesario e invoque al método del punto 4 para obtener el equipo 
   ganador y su información.
    */
     public function obtenerPremioTorneo()
   {
      $arrayGanador=$this->obtenerEquipoGanadorTorneo();
      $premio=$this->getPremio()*$arrayGanador["cantPartidosGanados"];
      return $premio;
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
 

  
   public function getIdTorneo()
   {
      return $this->idTorneo;
   }

   public function setIdTorneo($idTorneo)
   {
      $this->idTorneo = $idTorneo;
   }
}

?>