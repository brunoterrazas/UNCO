<?php
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\SMTP;
use PHPMailer\PHPMailer\Exception;
class ABMcompraestado
{

    /**
     * Espera como parametro un arreglo asociativo donde las claves coinciden con los nombres de las variables instancias del objeto
     *@param array $param
     *@return CompraEstado
     */
    private function cargarObjeto($param)
    {
        $obj = null;
        if (array_key_exists('idcompraestado', $param) and array_key_exists('idcompra', $param) and array_key_exists('idcompraestadotipo', $param) and array_key_exists('cefechaini', $param) and array_key_exists('cefechafin', $param) and array_key_exists('idusuario', $param)) {
            $obj = new CompraEstado();

            $objCompra = new Compra();
            $objCompra->setIdcompra($param['idcompra']);
            $objCompra->cargar();

            $objCet = new CompraEstadoTipo();
            $objCet->setIdcompraestadotipo($param['idcompraestadotipo']);
            $objCet->cargar();

            $objusuario = new Usuario();
            $objusuario->setidusuario($param['idusuario']);
            $objusuario->cargar();

            $obj->setear($param['idcompraestado'], $objCompra, $objCet, $param['cefechaini'], $param['cefechafin'], $objusuario);
        } else {
            if (array_key_exists('idcompraestado', $param)) {
                $obj = new CompraEstado();
                $obj->setIdcompraestado($param['idcompraestado']);
                $obj->cargar();
            }

            if (array_key_exists('idcompra', $param)) {
                $objCompra = new Compra();
                $objCompra->setIdcompra($param['idcompra']);
                $objCompra->cargar();
                $obj->setObjcompra($objCompra);
            }
            if (array_key_exists('idcompraestadotipo', $param)) {
                $objCet = new CompraEstadoTipo();
                $objCet->setIdcompraestadotipo($param['idcompraestadotipo']);
                $objCet->cargar();
                $obj->setObjcompraestadotipo($objCet);
            }
            if (array_key_exists('cefechaini', $param)) {
                $obj->setCefechaini($param['cefechaini']);
            }
            if (array_key_exists('cefechafin', $param)) {
                if ($param['cefechafin'] == null) {
                    $fechafin = "null";
                } else {
                    $fechafin = $param['cefechafin'];
                }
                $obj->setCefechafin($fechafin);
            }
            if (array_key_exists('idusuario', $param)) {
                $objusuario = new Usuario();
                $objusuario->setidusuario($param['idusuario']);
                $objusuario->cargar();
                $obj->setObjUsuario($objusuario);
            }
        }





        //    $obj->setear($param['idcompraestado'], $objCompra, $objCet, $param['cefechaini'], $param['cefechafin'],$objusuario);

        //print_r($obj);
        return $obj;
    }

    /**
     * Espera como parametro un arreglo asociativo donde las claves coinciden con los nombres de las variables instancias del objeto que son claves
     * @param array $param
     * @return CompraEstado
     */
    private function cargarObjetoConClave($param)
    {
        $obj = null;
        if (isset($param['idcompraestado'])) {
            $obj = new CompraEstado();
            $obj->setear($param['idcompraestado'], null, null, null, null, null);
        }
        return $obj;
    }
    /**
     * Corrobora que dentro del arreglo asociativo estan seteados los campos claves
     * @param array $param
     * @return boolean
     */

    private function seteadosCamposClaves($param)
    {
        $resp = false;
        if (isset($param['idcompraestado']))
            $resp = true;
        //echo "SeteadosCamposClaves". $resp;
        return $resp;
    }
    public function alta($param)
    {
        //print_r($param);
        $resp = false;
        $param['idcompraestado'] = null;

        $elObjce = $this->cargarObjeto($param);
        if ($elObjce != null and $elObjce->insertar()) {
            $resp = true;
        }
        return $resp;
    }
    /**
     * permite eliminar un objeto 
     * @param array $param
     * @return boolean
     */

    public function bajaLogica($param)
    {
        $resp = false;
        if ($this->seteadosCamposClaves($param)) {
            $elObjce = $this->cargarObjetoConClave($param);
            if ($elObjce != null and $elObjce->modificar("borradoLogico")) {
                $resp = true;
            }
        }
        return $resp;
    }
    /**
     * permite modificar un objeto
     * @param array $param
     * @return boolean
     */
    public function modificacion($param)
    {
        $resp = false;
        if ($this->seteadosCamposClaves($param)) {
            $elObjce = $this->cargarObjeto($param);
            //print_r($param);
            if ($elObjce != null and $elObjce->modificar()) {
                $resp = true;
            }
        }
        return $resp;
    }
    /**
     * permite buscar un objeto
     * @param array $param
     * @return array
     */
    public function buscar($param = null)
    {
        $where = " true ";

        if ($param <> NULL) {


            if (isset($param['idcompraestado'])) {
                $where .= " and idcompraestado = " . $param['idcompraestado'];
            }
            if (isset($param['idcompra'])) {
                $where .= " and idcompra =" . $param['idcompra'];
            }
            //condicion para buscar idcompraestadotipo mayor a un valor
            if (isset($param['idcompraet'])) {
                $where .= " and idcompraestadotipo > " . $param['idcompraet'];
            } else {
                //sino buscamos por idcompraestadotipo igual a un valor
                if (isset($param['idcompraestadotipo'])) {
                    $where .= " and idcompraestadotipo =" . $param['idcompraestadotipo'];
                }
            }
            if (isset($param['cefechaini'])) {
                $where .= " and cefechaini ='" . $param['cefechaini'] . "'";
            }
            if (isset($param['cefechafin'])) {
                $where .= " and cefechafin is " . $param['cefechafin'] . "";
            }
            if (isset($param['idusuario'])) {
                $where .= " and idusuario = " . $param['idusuario'];
            }
        }

        $arreglo = CompraEstado::listar($where);


        return $arreglo;
    }
    public function verificarEstado($param)
    {
        $objCompraEstado = null;
        $arreCompraEstado = $this->buscar($param);
        if (count($arreCompraEstado) == 1) {
            $objCompraEstado = $arreCompraEstado[0];
        }
        return $objCompraEstado;
    }
    public function cambiarEstado($datos)
    {
        $hoy = date("Y-m-d H:i:s");
        $datos["cefechaini"] = $hoy;
        $datos["cefechafin"] = "null";

        $seagrego = false;
        $seactualizo = false;


        if (isset($datos["idcompra"])) {



            $param["idcompraestado"] = $datos["idcompraestado"];

            //agregamos el nuevo estado 
            $seagrego = $this->alta($datos);
            //para actualizar asignamos la fecha fin del estado anterior 

            $seactualizo = $this->modificacion($param);
        }
        $resultado["seagrego"] = $seagrego;
        $resultado["seactualizo"] = $seactualizo;

        return $resultado;
    }
       /**
     * verifica el estado de la compra y cambia el estado de la compra a iniciado
     * @param array $param
     * @return array
     */
    public function confirmarCompra($datos)
    {
        $objSesion = new Session();
        $idusuario = $objSesion->getUsuario()->getIdusuario();

        $respuesta = [];

        $param["idusuario"] = $idusuario;
        $param["idcompraestadotipo"] = 0;
        $param["cefechafin"] = "null";

        //Verifico si tengo una compra con estado en confeccion
        $objEstado = $this->verificarEstado($param);

        $idcompra = -1;
        $idcompraestado = -1;

        if ($objEstado != null) {
            $idcompra = $objEstado->getObjCompra()->getIdcompra();
            $idcompraestado = $objEstado->getIdcompraestado();
        }
        if ($idcompra != -1) {
            $datos["idusuario"] = $idusuario;
            $datos["idcompraestado"] = $idcompraestado;
            $datos["idcompra"] = $idcompra;
            /////////////////////////////////////
            $data["idcompra"] = $idcompra;
            $objControlCI=new ABMcompraitem();
            $arre=$objControlCI->buscar($data);
            $cant=count($arre);

            ///////////////////////////////
            //Verificamos que hayan items en el carrito
            if($cant>0)
            {
            $respuesta = $this->cambiarEstado($datos);
            }
            else{
                $respuesta["seagrego"]=false;
                $respuesta["seactualizo"]=false;
                
            $retorno['errorMsg'] = "Agregue productos al carrito";
            }
        } else {
            $retorno['errorMsg'] = "No se pudo concretar";
        }
        $retorno['respuesta'] = $respuesta["seagrego"];
        $retorno['seactualizo'] = $respuesta["seactualizo"];
        

        
        return $retorno;
    }
       /**
     * Cambia el estado de la compra
     * @param array $datos
     * @return array
     */
    public function actualizarEstadoCompra($datos)
    {

        $respuesta = [];
        if (isset($datos["idcompra"])) {



            $objCtrlCI = new ABMcompraitem();
            $respuesta = $this->cambiarEstado($datos);
            if ($datos["idcompraestadotipo"] == 4) {
                $data["idcompra"] = $datos["idcompra"];
                $objCtrlCI->devolverProductos($data);
            }
           
            if ($datos["idcompraestadotipo"] > 0) {
                $retorno['msgMail'] = $this->enviarMail($datos["idcompra"], $datos["idcompraestadotipo"]);
            }
        } else {
            $mensaje = "no se pudo concretar";
        }
        $retorno['respuesta'] = $respuesta["seagrego"];
        $retorno['seactualizo'] = $respuesta["seactualizo"];
        if (isset($mensaje)) {

            $retorno['errorMsg'] = $mensaje;
        }
        return $retorno;
    }
   public function enviarMail($idcompra,$idcompraestadotipo)
{
$mail = new PHPMailer(true);

        try {
             //si la compra ya no esta en confeccion
             $objCntrolCompra=new ABMcompra();
             $valor["idcompra"]=$idcompra;
             $listcompra=$objCntrolCompra->buscar($valor);
             $objUsuario=$listcompra[0]->getObjUsuario();
          
            $objCtrlCET=new ABMcompraestadotipo();  
            $param["idcompraestadotipo"]=$idcompraestadotipo;
            $lista=$objCtrlCET->buscar($param);
            $objCET=$lista[0];
            $emailCliente=$objUsuario->getusmail();
            $estado=$objCET->getCetdescripcion();
            //Configuracion del servidor SMTP
            $mail->SMTPDebug = 0;
            $mail->isSMTP();
            /*********************USANDO UNA SANDBOX****************/
            $mail->Host       =  'sandbox.smtp.mailtrap.io';
            $mail->SMTPAuth   = true;
            $mail->Username   = '78c7a2cf766015';
            $mail->Password   = '8cd496cbaf6bde';
            $mail->SMTPSecure = PHPMailer::ENCRYPTION_STARTTLS;
            $mail->Port       = 2525;
            /********************************************************/
            //Remitente del correo
            $mail->setFrom('br1uno01one@gmail.com', 'Empresa');
            //Destinatario
            $mail->addAddress($emailCliente, 'Cliente');
            //Archivos adjuntos(opcional, depende si esta disponible en el host)
            $mail->addAttachment('../../css/images/logo-sis-text-2-(800p).png', 'Comunicado');      
            $mail->isHTML(true);
            $mail->Subject = 'Nro. pedido:'.$idcompra.', su compra ha sido '.$estado;
            $mail->Body    = 'El estado de su compra cambio a ' .$estado; 

            $mail->send();
            $res ='El mensaje ha sido enviado correctamente';
        } catch (Exception $e) {
            $res="Ha ocurrido un error al enviar el mensaje: {$mail->ErrorInfo}";
        }
        return $res;
    }
}
?>