<?php
class Session
{

    public function __construct()
    {
        if (!session_start()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Actualiza las variables de sesión con los valores ingresados.
     */
    public function iniciar($nombreUsuario, $psw)
    {
        $resp = false;

        $obj = new ABMUsuario();
        $param['usnombre'] = $nombreUsuario;
        $param['uspass'] = $psw;
        $param['usdeshabilitado'] = null;

        $resultado = $obj->buscar($param);
        if (count($resultado) > 0) {
            $usuario = $resultado[0];
            $usuhabilitado = $usuario->getUsdeshabilitado();
            if ($usuhabilitado == null) {
                $_SESSION['idusuario'] = $usuario->getidusuario();
                $resp = true;
            }
        } else {
            $this->cerrar();
        }
        return $resp;
    }

    /**
     * Valida si la sesión actual tiene usuario y psw válidos. Devuelve true o false.
     */
    public function validar()
    {
        $resp = false;
        if ($this->activa() && isset($_SESSION['idusuario']))
            $resp = true;
        return $resp;
    }

    /**
     *Devuelve true o false si la sesión está activa o no.
     */
    public function activa()
    {
        $resp = false;
        if (php_sapi_name() !== 'cli') {
            if (version_compare(phpversion(), '5.4.0', '>=')) {
                $resp = session_status() === PHP_SESSION_ACTIVE ? TRUE : FALSE;
            } else {
                $resp = session_id() === '' ? FALSE : TRUE;
            }
        }
        return $resp;
    }

    /**
     * Devuelve el usuario logeado.
     */
    public function getUsuario()
    {
        $usuario = null;
        if ($this->validar()) {
            $obj = new ABMUsuario();
            $param['idusuario'] = $_SESSION['idusuario'];
            $resultado = $obj->buscar($param);
            if (count($resultado) > 0) {
                $usuario = $resultado[0];
            }
        }

        return $usuario;
    }

    /**
     * Devuelve el rol del usuario logeado.
     */
    public function getRol()
    {
        $list_rol = [];
        if ($this->validar()) {
            $obj = new ABMUsuario();
            $param['idusuario'] = $_SESSION['idusuario'];
            $resultado = $obj->darRoles($param);
            if (count($resultado) > 0) {
                $list_rol = $resultado;
            }
        }
        return $list_rol;
    }

    /**
     *Cierra la sesión actual.
     */
    public function cerrar()
    {
        $resp = true;
        session_destroy();
        // $_SESSION['idusuario']=null;
        return $resp;
    }

    //recibo la URL de cada página (sin ../)
    public function tengoPermisos($url)
    {

        // concateno para logra la URL como está guardada en la BD
        $urlMenu['medescripcion'] = "../" . $url;

        // el método getRol de Session devuelve un objeto UsuarioRol               
        $objUsuroles = $this->getRol();

        $i = 0;
        $encontrado = false;
        while ($i < count($objUsuroles) && !$encontrado) {
            $idrol =  $objUsuroles[$i]->getobjrol()->getidrol();
            $objMenuRol = new ABMmenurol();
            $param['idrol'] = $idrol;
            $arraymenusrol = $objMenuRol->buscar($param);
            $j = 0;

            while ($j < count($arraymenusrol) && !$encontrado) {

                $objMenu = $arraymenusrol[$j]->getObjMenu();
                if ($urlMenu['medescripcion'] == $objMenu->getMedescripcion()) {
                    $objUsuvalido = $this->getUsuario();
                    $usuhabilitado = $objUsuvalido->getUsdeshabilitado();
                    if ($usuhabilitado == null) {
                        $encontrado = true;
                    }
                }
                $j++;
            }
            $i++;
        }
        return $encontrado;
    }
}
?>