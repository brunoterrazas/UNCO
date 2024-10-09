<?php
class Login
{
    private $nombre_usuario;
    private $contrasenia;
    private $frase;
    private $arre_contrasenias;
    private static $cant_contranias=4; 

    public function __construct($nombre_user,$contra,$frase)
    {
        $this->nombre_usuario=$nombre_user;
        $this->contrasenia=$contra;
        $this->frase=$frase;
        $this->arre_contrasenias= array($this->cant_contranias);
    }
    /**
     * Get the value of nombre_usuario
     */
    public function getNombreUsuario()
    {
        return $this->nombre_usuario;
    }
    /**
     * Get the value of contrasenia
     */
    public function getContrasenia()
    {
        return $this->contrasenia;
    }
    /**
     * Get the value of frase
     */
    public function getFrase()
    {
        return $this->frase;
    }
    public function getArreContrasenias()
    {
        return $this->arre_contrasenias;
    }
    public function setArreContrasenias($arre_contrasenias)
    {
        $this->arre_contrasenias=$arre_contrasenias;
    }
    public function guardarContrasenia($pass)
    {
        $tamanio=count($this->getArreContrasenias());
       if($this->cant_contrasenias==$tamanio)
       {
           
       }

    }
    /**
     * Set the value of nombre_usuario
     */
    public function setNombreUsuario($nombre_usuario)
    {
        $this->nombre_usuario = $nombre_usuario;

        return $this;
    }



    /**
     * Set the value of contrasenia
     */
    public function setContrasenia($contrasenia)
    {
        $this->contrasenia = $contrasenia;

        return $this;
    }



    /**
     * Set the value of frase
     */
    public function setFrase($frase)
    {
        $this->frase = $frase;

        return $this;
    }
    public function validarContraseña($pass)
    {
       return $pass==$this->getContrasenia();

    }
}
