<?php 

class Financiera{
  
    private $colPrestamos;
    private $denominacion;
    private $direccion;
    public function __construct($col_prestamos,$unaDireccion,$unaDenominacion)
    {
        $this->colPrestamos=$col_prestamos;
        $this->direccion=$unaDireccion;
        $this->denominacion=$unaDenominacion;
        
    }
    public function getDenominacion()
    {
        return $this->direccion;
    }
    public function getDireccion()
    {
        return $this->direccion;
    }
    public function getColPrestamos()
    {
        return $this->colPrestamos;        
    }
    public function setDenominacion($denominacion)
    {
       $this->denominacion=$denominacion;
    }
    public function setDireccion($direccion)
    {
        $this->direccion=$direccion;
    }
    public function setColPrestamos($colObjPrestamo)
    {
        $this->colPrestamos=$colObjPrestamo;

    }
    public function incorporarPrestamo($objPrestamo)
    {
        $res=true;
        $prestamos=$this->getColPrestamos();
        $pos=count($prestamos);
        $prestamos[$pos]=$objPrestamo;
        $this->setColPrestamos($prestamos);

        return $res;
    }
    public function __toString()
    {
        $cadena="Denominacion: ".$this->getDenominacion()."Direccion: ".$this->getDireccion().
        "\n"."---------Lista de prestamos---------\n";

        foreach($this->getColPrestamos() as $objprestamo)
        {
            $cadena.=$objprestamo-> __toString();
        } 
        $cadena.="------------------------------------\n";

        return $cadena;
    }
    public function otorgarPrestamoSiCalifica()
    {

          foreach($this->getColPrestamos() as $objPrestamo)
          { 
              if($objPrestamo->verificarPrestamo())
              $objPrestamo->otorgaPrestamo($objPrestamo->getCantidadCuotas());              
            
          }
         
    }
    public function informarCuotaPagar($id_prestamo)
    {
        $encontrado=false;
        $cant_prestamos=count($this->getColPrestamos());
        $i=0;
        
        while($i<$cant_prestamos&& !$encontrado)
        {
           $prestamo=$this->getColPrestamos()[$i];  
           if($prestamo->getIdentificacion()==$id_prestamo)
           {
            $cuota=$prestamo->darSiguienteCuotaPagar();                                 
            $encontrado=true; 
           }
           $i++;
        }
      return $cuota;

    }

}

?>