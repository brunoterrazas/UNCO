<?php
 class Reloj
 {
   private $horas;
   private $minutos;
   private $segundos;

   public function  __construct($horas,$minutos,$segundos)
   {
    // Metodo constructor de la clase Calculadora
    $this->horas = $horas;
    $this->minutos = $minutos;
    $this->segundos = $segundos;
   }
   //Observadores
    public function getHoras()
    {
       return $this->horas;
    }
    public function getMinutos()
    {
       return $this->minutos;
    }
    public function getSegundos()
    {
       return $this->segundos;
    }
    //Modificadores
    public function setHoras($horas)
    {
       $this->horas=$horas;
    }
    public function setMinutos($minutos)
    {
       $this->minuto=$minutos;
    }
    public function setSegundos($segundos)
    {
       $this->segundos=$segundos;
    }
    public function puesta_a_cero()
    {
        $this->horas=0;
        $this->minutos=0;
        $this->segundos=0;
    } 
    
    public function __toString()
    {
        $horas=$this->getHoras();
        $minutos=$this->getMinutos();
        $segundos=$this->getSegundos();
        if($horas<10&&strlen($horas)==1)
           $horas="0".$horas;
           if($minutos<10&&strlen($minutos)==1)
           $minutos="0".$minutos;
           if($segundos<10&&strlen($segundos)==1)
           $segundos="0".$segundos;

        return $horas.":".$minutos.":$segundos\n";
    }  
    

}
 ?>