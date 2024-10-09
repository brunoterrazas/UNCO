<?php 

class Persona
{
    private $nombre;
    private $apellido; 
    private $dni;
    private $direccion;
    private $email;
    private $telefono;
    private $neto;
   
    public function __construct($nombre,$apellido,$dni,$direccion,$email,$telefono,$neto)
    {
        $this->nombre=$nombre;
        $this->apellido=$apellido;
        $this->dni=$dni;
        $this->direccion=$direccion;
        $this->telefono=$telefono;
        $this->email=$email;
        $this->neto=$neto;
        
    }
    //vizualizadores
    public function getNombre()
    {
       return $this->nombre;
    }
    public function getApellido()
    {
        return $this->apellido;
    }
    public function getDni()
    {
        return $this->dni;
    }
    public function getDireccion()
    {
        return $this->direccion;
    }
    public function getTelefono()
    {
        return $this->telefono;
    }
    public function getEmail()
    {
        return $this->email;
    }
    public function getNeto()
    {
        return $this->neto;
    } 
    //modificadores
    public function setNombre($unNombre)
    {
        $this->nombre=$unNombre;

    }
    
    public function setApellido($unApellido)
    {
        $this->apellido=$unApellido;

    }
    
    public function setDni($unDni)
    {
        $this->dni=$unDni;

    }
    
    public function setDireccion($unaDireccion)
    {
        $this->direccion=$unaDireccion;

    }
    
    public function setTelefono($unTelefono)
    {
        $this->telefono=$unTelefono;

    }
    
    public function setEmail($unEmail)
    {
        $this->email=$unEmail;

    }
    
    public function setNeto($neto)
    {
        $this->neto=$neto;

    }
    public function __toString()
    {
        $cadena=$this->getNombre().", ".$this->getApellido()." DNI:".$this->getDni()." Direccion ".
        $this->getDireccion()." Telefono:".$this->getTelefono()." Email:".
        $this->getEmail()." Neto: ".$this->getNeto();
        return $cadena;
    }
   }
?>