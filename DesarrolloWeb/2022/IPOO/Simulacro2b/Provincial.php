<?php 
class Provincial extends Torneo
{
    private $provincia;
   public function __construct($id,$premio,$colPartidos,$provincia)
   {
       parent :: __construct($id,$premio,$colPartidos);
       $this->provincia=$provincia;
   }

    public function setProvincia($provincia)
    {
        $this->provincia = $provincia;

    }
    public function getProvincia()
    {
        return $this->provincia;
    }
    public function __toString()
   {
      $cadena="";
      $cadena.=parent ::__toString()." Provincia: ".$this->getProvincia();
      return $cadena;
   }
}

?>