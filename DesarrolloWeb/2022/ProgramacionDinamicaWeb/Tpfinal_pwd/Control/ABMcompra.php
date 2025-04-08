<?php 
class ABMcompra{

     /**
     * Espera como parametro un arreglo asociativo donde las claves coinciden con los nombres de las variables instancias del objeto
    *@param array $param
    *@return Compra
    */
    private function cargarObjeto($param){
        $obj = null;

        if (array_key_exists('idcompra', $param) and array_key_exists('cofecha', $param) and array_key_exists('idusuario', $param)  ){
            $obj = new Compra();
            
            $objUsuario = new Usuario();
            $objUsuario->setIdusuario($param['idusuario']);
            $objUsuario->cargar();

            $obj->setear($param['idcompra'], $param['cofecha'], $objUsuario);
        }
        //print_r($obj);
        return $obj;
    }
    
     /**
     * Espera como parametro un arreglo asociativo donde las claves coinciden con los nombres de las variables instancias del objeto que son claves
     * @param array $param
     * @return Compra
     */
    private function cargarObjetoConClave($param){
        $obj = null;
        if(isset($param['idcompra'])){
            $obj = new Compra();
            $obj->setear($param['idcompra'], null, null);
        }
        return $obj;
    }
    /**
     * Corrobora que dentro del arreglo asociativo estan seteados los campos claves
     * @param array $param
     * @return boolean
     */

     private function seteadosCamposClaves($param){
        $resp = false;
        if (isset($param['idcompra']))
            $resp = true;
        //echo "SeteadosCamposClaves". $resp;
        return $resp;
     }
     public function alta($param){
        //print_r($param);
        $resp = null;
        $param['idcompra']=null;

        $elObjcompra = $this->cargarObjeto($param);
        if ($elObjcompra!=null and $elObjcompra->insertar()){
            $resp = $elObjcompra;
        }
        return $resp;
     }
      /**
     * permite eliminar un objeto 
     * @param array $param
     * @return boolean
     */
    /*

    public function bajaLogica($param){
        $resp = false;
        if ($this->seteadosCamposClaves($param)){
            $elObjcompra = $this->cargarObjetoConClave($param);
            if($elObjcompra!=null and $elObjcompra->modificar("borradoLogico")){
                $resp = true;
            }
        }
        return $resp;
    }*/
     /**
     * permite modificar un objeto
     * @param array $param
     * @return boolean
     */
    /*
    public function modificacion($param){
        $resp = false;
        if($this->seteadosCamposClaves ($param)){
            $elObjcet = $this->cargarObjeto($param);
            //print_r($param);
            if($elObjcet!=null and $elObjcet->modificar()){
                $resp = true;
            }
        }
        return $resp;
    }*/
    /**
     * permite buscar un objeto
     * @param array $param
     * @return array
     */
    public function buscar($param){
        $where = " true ";
       
        if($param<>NULL){
            if(isset($param['idcompra'])) 
                $where.=" and idcompra = ".$param['idcompra'];
            if(isset($param['cofecha'])) 
                $where.=" and cofecha ='".$param['cofecha'];
                if (isset($param['idusuario']))
                $where .= " and idusuario = ".$param['idusuario'];
            
        }
        $arreglo = Compra::listar($where);
       
    
        return $arreglo;
       }
      /* En este metodo se agregar el primer item  y se genera la compra con estado en confección, sino se incrementa la cantidad del item +1*/
   function agregarItem($valores)
   {
    $cantidad = $valores["cicantidad"];
    $idproducto = $valores["idproducto"];
    //verificamos si hay una compra en confeccion
    $objSesion = new Session();
    $idusuario =$objSesion->getUsuario()->getIdusuario();
    $param["idusuario"] = $idusuario;
    $param["idcompraestadotipo"] = 0;
    $param["cefechafin"] = "null";
    $objCntrlCE = new ABMcompraestado();
    
    $objEstado = $objCntrlCE->verificarEstado($param);
    $retorno["seagrego"]=false;
    $retorno["seactualizo"]=false;
    //verifico si hay una compra en confeccion
    if ($objEstado != null) {
        //obtenemos el idcompra de a traves de la compra estado
        $idcompra = $objEstado->getObjCompra()->getIdcompra();
    
    
        ///datos recibidos
        $data["idcompra"] = $idcompra;
        $data["cicantidad"] = $cantidad;
        $data["idproducto"] = $idproducto;
        $objControlCI = new ABMcompraitem();
        $arre = $objControlCI->agregarProducto($data);
        $retorno["seagrego"]= $arre["seagrego"];
        $retorno["seactualizo"]= $arre["seactualizo"];
       // echo"Ya hay una compra en confeccion y se agrego el producto<br>";
       //  print_r($arre);
    } else {
      //Agregamos el primer item al carrito y generamos la primer estado de la compra(en confeccion)
        $hoy = date("Y-m-d H:i:s");
        $data["cofecha"] = $hoy;
        $data["idusuario"] = $idusuario;
        //creamos la compra
        $objCompra = $this->alta($data);
    
        $idcompra = $objCompra->getIdcompra();
        $datos["idcompra"] = $idcompra;
        $datos["idcompraestadotipo"] = 0;
        $datos["idusuario"] = $idusuario;
        $datos["cefechaini"] = $data["cofecha"];
        $datos["cefechafin"] = "null";
        //creamos compra estado "en confeccion"
        $objCtrlCE = new ABMcompraestado();
        $objEstado = $objCtrlCE->alta($datos);
        // agregamos el producto        
        $data["idcompra"] = $idcompra;
        $data["cicantidad"] = $cantidad;
        $data["idproducto"] = $idproducto;
        $objControlCI = new ABMcompraitem();
        $arre = $objControlCI->agregarProducto($data);
        $retorno["seactualizo"]= $arre["seactualizo"];
        $retorno["seagrego"]= $arre["seagrego"];
        
         //echo "Se crea la compra en confeccion<br>";
       
    }
  return $retorno;
   }
}
