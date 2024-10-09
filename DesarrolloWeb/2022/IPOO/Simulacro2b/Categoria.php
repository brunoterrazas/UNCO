<?php 
class Categoria
{
    private $idCategoria;
    private $descripcion;
    private $coeficienteCategoria;
    public function __construct($idCategoria,$descripcion,$coefCategoria)
    {
        $this->idCategoria=$idCategoria;
        $this->descripcion=$descripcion;
        $this->coeficienteCategoria=$coefCategoria;
    }
    public function getIdCategoria()
    {
        return $this->idCategoria;
    }
    public function setIdCategoria($idCategoria)
    {
        $this->idCategoria = $idCategoria;
    }
    public function getDescripcion()
    {
        return $this->descripcion;
    }
    public function setDescripcion($descripcion)
    {
        $this->descripcion = $descripcion;
    }
    public function __toString()
    {
        $cadena="Id Categoria: ".$this->getIdCategoria()." Categoria: ".$this->getDescripcion()."\n";

        return $cadena;
    }

    public function getCoeficienteCategoria()
    {
        return $this->coeficienteCategoria;
    }
    public function setCoeficienteCategoria($coeficienteCategoria)
    {
        $this->coeficienteCategoria = $coeficienteCategoria;
    }
}

?>