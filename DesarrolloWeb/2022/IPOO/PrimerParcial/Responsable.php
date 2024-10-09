<?php
 class Responsable{
     
    private $num_documento;
    private $nombre;
    private $apellido;
    private $direccion;
    private $mail;
    private $telefono;

   public function __construct($num_docu,$nombre, $apellido,$direccion,$mail,$telefono)
   {
       $this->num_documento=$num_docu;
       $this->nombre=$nombre;
       $this->apellido=$apellido;
       $this->direccion=$direccion;
       $this->mail=$mail;
       $this->telefono=$telefono;
   }

   public function getNumDocumento()
   {
       return $this->num_documento;
   }

    public function setNumDocumento($num_documento)
   {
       $this->num_documento = $num_documento;
   }


    public function getNombre() 
    {
        return $this->nombre;
    }

    public function setNombre($nombre)
    {
        $this->nombre = $nombre;

   
    }
    public function getApellido() 
    {
        return $this->apellido;
    }

    public function setApellido($apellido)
    {
        $this->apellido = $apellido;

   
    }
    

   
  
    public function getDireccion()
    {
        return $this->direccion;
    }

    public function setDireccion($direccion)
    {
        $this->direccion = $direccion;

    }

    public function getMail()
    {
        return $this->mail;
    }

    public function setMail($mail)
    {
        $this->mail = $mail;
    }

    public function getTelefono()
    {
        return $this->telefono;
    }

    public function setTelefono($telefono)
    {
        $this->telefono = $telefono;

    }
      /**
 * Retorna un string represente a los objetos de la clase Responsable. 
 * String cadena
 * @return String
 */
public function __toString()
{
    $cadena="";
    $cadena.="Num. Documento: ".$this->getNumDocumento()." Nombre: ".$this->getNombre()." Apellido: ".$this->getApellido()." Direccion: ".$this->getDireccion()." Mail: ".$this->getMail()." Telefono: ".$this->getTelefono();
  return $cadena;
}
}

?>