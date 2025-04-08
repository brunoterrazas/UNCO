<?php

class Usuario extends BaseDatos
{
    private $idusuario;
    private $usnombre;
    private $uspass;
    private $usmail;
    private $usdeshabilitado;

    private $mensajeoperacion;


    public function __construct()
    {
        parent::__construct();
        $this->idusuario = "";
        $this->usnombre = "";
        $this->uspass = "";
        $this->usmail = "";
        $this->usdeshabilitado = "";
        $this->mensajeoperacion = "";
    }
    public function setear($idusuario, $usnombre, $uspass, $usmail, $usdeshabilitado)
    {
        $this->setidusuario($idusuario);
        $this->setusnombre($usnombre);
        $this->setuspass($uspass);
        $this->setusmail($usmail);

        // if($usdeshabilitado = '0000-00-00 00:00:00')
        //       $usdeshabilitado = "null";

        $this->setusdeshabilitado($usdeshabilitado);
    }

    public function getidusuario()
    {
        return $this->idusuario;
    }
    public function setidusuario($idusuario)
    {
        $this->idusuario = $idusuario;
    }
    public function getusnombre()
    {
        return $this->usnombre;
    }
    public function setusnombre($usnombre)
    {
        $this->usnombre = $usnombre;
    }
    public function getuspass()
    {
        return $this->uspass;
    }
    public function setuspass($uspass)
    {
        $this->uspass = $uspass;
    }
    public function getusmail()
    {
        return $this->usmail;
    }
    public function setusmail($usmail)
    {
        $this->usmail = $usmail;
    }
    public function getusdeshabilitado()
    {
        return $this->usdeshabilitado;
    }
    public function setusdeshabilitado($usdeshabilitado)
    {
        $this->usdeshabilitado = $usdeshabilitado;
    }

    public function getmensajeoperacion()
    {
        return $this->mensajeoperacion;
    }
    public function setmensajeoperacion($valor)
    {
        $this->mensajeoperacion = $valor;
    }

    public function cargar()
    {
        $resp = false;
        $sql = "SELECT * FROM usuario WHERE idusuario = " . $this->getidusuario();
        if ($this->Iniciar()) {
            $res = $this->Ejecutar($sql);
            if ($res > -1) {
                if ($res > 0) {
                    $row = $this->Registro();
                    $this->setear($row['idusuario'], $row['usnombre'], $row['uspass'], $row['usmail'], $row['usdeshabilitado']);
                }
            }
        } else {
            $this->setmensajeoperacion("Usuario->listar: " . $this->getError());
        }
        return $resp;
    }

    public function insertar()
    {
        $resp = false;
        $sql = "INSERT INTO usuario(usnombre,uspass,usmail,usdeshabilitado)  VALUES('" . $this->getusnombre() . "','" . $this->getuspass() . "','" . $this->getusmail() . "'," . $this->getusdeshabilitado() . ");";
        if ($this->Iniciar()) {
            if ($elid = $this->Ejecutar($sql)) {
                $this->setidusuario($elid);
                $resp = true;
            } else {
                $this->setmensajeoperacion("Especie->insertar: " . $this->getError());
            }
        } else {
            $this->setmensajeoperacion("Usuario->insertar: " . $this->getError());
        }
        return $resp;
    }


    public function modificar($tipo)
    {
        $resp = false;
        if ($tipo == "borradoLogico") {
            $fechaActual = Date("Y-m-d h:i:s");
            $sql = "UPDATE usuario SET usdeshabilitado='" . $fechaActual . "' WHERE idusuario=" . $this->getidusuario();
        } else {
            $sql = "UPDATE usuario SET usmail = '" . $this->getusmail() . "', uspass='" . $this->getuspass() . "' WHERE idusuario =" . $this->getidusuario();
        }
        if ($this->Iniciar()) {

            if ($this->Ejecutar($sql)) {
                $resp = true;
            } else {
                $this->setmensajeoperacion("Usuario->modificar: " . $this->getError());
            }
        } else {
            $this->setmensajeoperacion("Usuario->modificar: " . $this->getError());
        }
        return $resp;
    }




    public function eliminar()
    {
        $resp = false;
        $sql = "DELETE FROM usuario WHERE idusuario=" . $this->getidusuario();
        if ($this->Iniciar()) {
            if ($this->Ejecutar($sql)) {
                return true;
            } else {
                $this->setmensajeoperacion("Usuario->eliminar: " . $this->getError());
            }
        } else {
            $this->setmensajeoperacion("Usuario->eliminar: " . $this->getError());
        }
        return $resp;
    }

        /**
     * permite listar objetos Usuario. 
     * @param int $parametro
     * @return boolean
     */
    public static  function listar2($parametro = "")
    {

        $arreglo = array();
        $base = new BaseDatos();
        $sql = "SELECT * FROM usuario ";

        if ($parametro != "") {
            $sql .= ' WHERE ' . $parametro;
        }
        $res = $base->Ejecutar($sql);

        if ($res > -1) {
            if ($res > 0) {

                while ($row = $base->Registro()) {
                    $obj = new Usuario();
                   
                    $obj->setear($row['idusuario'], $row['usnombre'], $row['uspass'], $row['usmail'], $row['usdeshabilitado']);
                    array_push($arreglo, $obj);
                }
            }
        }

        return $arreglo;
    }
  /**
     * permite buscar a un usuario. 
     * @param int $idusario
     * @return boolean
     */
    public function buscar($idusuario)
    {
        $base = new BaseDatos();
        $consulta = "Select * from usuario where idusuario=" . $idusuario . "";
        $resp = false;
        if ($base->Iniciar()) {
            if ($base->Ejecutar($consulta)) {
                if ($row2 = $base->Registro()) {
                    $this->setidusuario($row2['idusuario']);
                    $this->cargar();

                    $resp = true;
                }
            } else {
                $this->setmensajeoperacion($base->getError());
            }
        } else {
            $this->setmensajeoperacion($base->getError());
        }
        return $resp;
    }
   
}
