<?php
class ABMcompraitem
{

    /**
     * Espera como parametro un arreglo asociativo donde las claves coinciden con los nombres de las variables instancias del objeto
     *@param array $param
     *@return CompraItem
     */
    private function cargarObjeto($param)
    {
        $obj = null;
        if (array_key_exists('idcompraitem', $param) and array_key_exists('idproducto', $param) and array_key_exists('idcompra', $param) and array_key_exists('cicantidad', $param)) {
            $obj = new CompraItem();
            $objProducto = new Producto();
            $objProducto->setIdproducto($param['idproducto']);
            $objProducto->cargar();

            $objCompra = new Compra();
            $objCompra->setIdcompra($param['idcompra']);
            $objCompra->cargar();

            $obj->setear($param['idcompraitem'], $objProducto, $objCompra, $param['cicantidad']);
        } else {
            if (array_key_exists('idcompraitem', $param)) {
                $obj = new CompraItem();
                $obj->setIdcompraitem($param['idcompraitem']);
                $obj->cargar();
            }
            if (array_key_exists('idproducto', $param)) {

                $objProducto = new Producto();
                $objProducto->setIdproducto($param['idproducto']);
                $objProducto->cargar();
                $obj->setObjProducto($objProducto);
            }
            if (array_key_exists('idcompra', $param)) {
                $objCompra = new Compra();
                $objCompra->setIdcompra($param['idcompra']);
                $objCompra->cargar();
                $obj->setObjCompra($objCompra);
            }

            if (array_key_exists('cicantidad', $param)) {




                $obj->setCicantidad($param["cicantidad"]);
            }
        }
        //print_r($obj);
        return $obj;
    }

    /**
     * Espera como parametro un arreglo asociativo donde las claves coinciden con los nombres de las variables instancias del objeto que son claves
     * @param array $param
     * @return CompraItem
     */
    private function cargarObjetoConClave($param)
    {
        $obj = null;
        if (isset($param['idcompraitem'])) {
            $obj = new CompraItem();
            $obj->setear($param['idcompraitem'], null, null, null);
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
        if (isset($param['idcompraitem']))
            $resp = true;
        //echo "SeteadosCamposClaves". $resp;
        return $resp;
    }
    public function alta($param)
    {
        //print_r($param);
        $resp = false;
        $param['idcompraitem'] = null;

        $elObjcitem = $this->cargarObjeto($param);
        if ($elObjcitem != null and $elObjcitem->insertar()) {
            $resp = true;
        }
        return $resp;
    }
    /**
     * permite eliminar un objeto 
     * @param array $param
     * @return boolean
     */

    public function baja($param)
    {
        $resp = false;
        if ($this->seteadosCamposClaves($param)) {
            $elObjcitem = $this->cargarObjetoConClave($param);
            if ($elObjcitem != null and $elObjcitem->eliminar()) {
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
            $elObjcitem = $this->cargarObjeto($param);
            //print_r($param);
            if ($elObjcitem != null and $elObjcitem->modificar()) {
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
    public function buscar($param)
    {
        $where = " true ";
        //echo "Este dato ingresa a Buscar en ABMusuario";

        //print_r($param);
        //echo "<br>";
        //print_r ($param['usmail']);
        if ($param <> NULL) {
            if (isset($param['idcompraitem']))
                $where .= " and idcompraitem = " . $param['idcompraitem'];
            if (isset($param['idproducto']))
                $where .= " and idproducto =" . $param['idproducto'];
            if (isset($param['idcompra']))
                $where .= " and idcompra =" . $param['idcompra'];
            if (isset($param['cicantidad']))
                $where .= " and cicantidad =" . $param['cicantidad'];
        }
        
        $arreglo = CompraItem::listar($where);
       
        return $arreglo;
    }
      /**
     * Agrega el primer producto en el carrito y genera la primer estado de la compra "En confeccion", sino incrementa la cantidad del item +1
     * @param array $param
     * @return array
     */
    public function agregarProducto($param)
    {



        $cntrlProducto = new ABMproducto();
        $datosProd["idproducto"] = $param["idproducto"];
        $arreProducto = $cntrlProducto->buscar($datosProd);
        $objProducto = null;
        $resultado = [];
        if (count($arreProducto) == 1) {
            $objProducto = $arreProducto[0];
        }
        if ($objProducto != null) {

            //obtenemos su stock    
            $cantStock = $objProducto->getProcantstock();
            //si la cantidad es menor o igual a la cantidad stock del producto
            if ($param["cicantidad"] <= $cantStock) {


                //verificamos si el item ya esta agregado en el carrito(compra)
                $datositemc["idcompra"] = $param["idcompra"];
                $datositemc["idproducto"] = $param["idproducto"];
                $cantStock = $cantStock - $param["cicantidad"];
                $arreitemBuscado = $this->buscar($datositemc);

                if (count($arreitemBuscado) == 1) {

                    $idcompraitem = $arreitemBuscado[0]->getIdcompraitem();
                    //se modifica la cantidad el item al carrito
                    $cicantidad = $arreitemBuscado[0]->getCicantidad();
                    $datositemc["idcompraitem"] = $idcompraitem;
                    //incrementamos +1 cicantidad, la cantidad es enviada desde compra/index.php por defecto es 1 
                    $datositemc["cicantidad"] = $cicantidad + $param["cicantidad"];
                    $seagrego = $this->modificacion($datositemc);
                } else {
                    //se agrega el item al carrito
                    $datositemc["idcompra"] = $param["idcompra"];
                    $datositemc["idproducto"] = $datosProd["idproducto"];
                    $datositemc["cicantidad"] = $param["cicantidad"];
                    $seagrego = $this->alta($datositemc);
                }
                $resultado["seagrego"] = $seagrego;
                $data["idproducto"] =  $datosProd["idproducto"];
                $data["procantstock"] = $cantStock;
                //se actualiza el stock
                $res = $cntrlProducto->modificacion($data);
                $resultado["seactualizo"] = $res;
            }
        }
        return $resultado;
    }
      /**
     * Devuelve el stock de cada producto del carrito de compras
     * @param array $data
     * @return array
     */
    public function devolverProductos($data)
    {
        //con el idcompra, obtenemos los items o productos comprados(objetos CompraItem) 
        $arrproductos = $this->buscar($data);
        /*recorremos todos los objetos CompraItem, para eliminar cada item o producto
             y devolver la cantidad a su stock*/
        $resultado = array();

        foreach ($arrproductos as $objCI) {
            $idcompraitem = $objCI->getIdcompraitem();
            $objProducto = $objCI->getObjProducto();
            $idproducto = $objProducto->getIdproducto();
            $cicantidad = $objCI->getCicantidad();

            $procantstock = $objProducto->getProcantstock();
            //datos del producto 
            $data["idproducto"] = $idproducto;
            $data["procantstock"] = $procantstock + $cicantidad;
            //actualizamos el stock del producto
            $objCtrlProducto = new ABMproducto();
            $res = $objCtrlProducto->modificacion($data);
            ////////////////////////
            $datos["idcompraitem"] = $idcompraitem;
            //si eliminamos el item
            // $result = $this->baja($datos);

            //sino solo se actualiza el stock
            $resultado[]["seborro"] = true;
            $resultado[]["sedevolvio"] = $res;
        }
        return $resultado;
    }
  /**
     * actualiza la cantidad del item del carrito
     * @param array $param
     * 
     */

    function cambiarCantidadItem2($param)
    {
        $datos["idcompraitem"] = $param["idcompraitem"];
        //buscamos la instancia de compraitem
        $objCompraItem = $this->buscar($datos);
        $cicantidadactual = $objCompraItem[0]->getCicantidad();

        $opc = $param["opc"];
        $cantNueva = $param["cantNueva"];
        $idproducto = $objCompraItem[0]->getObjProducto()->getIdproducto();
        $cantStock = $objCompraItem[0]->getObjProducto()->getProcantstock();
        $res = false;
        $resultado = 0;
        switch ($opc) {
            case 1:
                //incrementando 1 item
                if ($cantStock - 1 >= 0) {
                    $data["idproducto"] = $idproducto;
                    $data["procantstock"] = $cantStock - 1;
                    //actualizamos stock del producto
                    $objCtrlProducto = new ABMproducto();
                    $res = $objCtrlProducto->modificacion($data);
                    $param["cicantidad"] = $objCompraItem[0]->getCicantidad() + 1;
                }

                break;
            case 2:
                //quitando 1 item
                if ($cicantidadactual > 1) {
                    $data["idproducto"] = $idproducto;
                    $data["procantstock"] = $cantStock + 1;
                    //actualizamos stock del producto
                    $objCtrlProducto = new ABMproducto();
                    $res = $objCtrlProducto->modificacion($data);
                    $param["cicantidad"] = $objCompraItem[0]->getCicantidad() - 1;
                }

                break;
            case 3:
                //cambiando por otra cantidad de item
                if ($cantNueva == $cicantidadactual) {
                    $resultado = 1;
                } else {
                    if ($cantNueva > $cicantidadactual) {
                        $cant = $cantNueva - $cicantidadactual;
                        if (($cantStock - $cant) >= 0) {
                            $data["idproducto"] = $idproducto;
                            $data["procantstock"] = $cantStock - $cant;
                            //actualizamos stock del producto
                            $objCtrlProducto = new ABMproducto();
                            $res = $objCtrlProducto->modificacion($data);
                            $param["cicantidad"] = $objCompraItem[0]->getCicantidad() + $cant;
                        }
                    } else {
                        $cant = $cicantidadactual - $cantNueva;
                        if (($cantStock + $cant) >= 0) {
                            $data["idproducto"] = $idproducto;
                            $data["procantstock"] = $cantStock + $cant;
                            //actualizamos stock del producto
                            $objCtrlProducto = new ABMproducto();
                            $res = $objCtrlProducto->modificacion($data);
                            $param["cicantidad"] = $objCompraItem[0]->getCicantidad() - $cant;
                        }
                    }
                }
                break;
        }
        if ($res) {
            //modificamos la cantidad del item del carrito
            $resultado = $this->modificacion($param);
        }

        return $resultado;
    }
      /**
     * Elimina el item del carrito y devuelve su cantidad al stock del producto
     * @param array $param
     * @return array
     */
    function eliminarItem($datos)
    {
        $respuesta = false;
        $seactualizo = false;
        if (isset($datos['idcompraitem']) && isset($datos['idproducto']) && isset($datos["cicantidad"])) {

            $objCtrlProd = new ABMproducto();
            $arrayAsoc["idproducto"] = $datos["idproducto"];
            $arreProd = $objCtrlProd->buscar($arrayAsoc);
            if (count($arreProd) == 1) {
                //obtenemos su stock    
                $cantStock = $arreProd[0]->getProcantstock();
                //si la cantidad es menor o igual a la cantidad stock del producto


                $cantStock = $cantStock + $datos["cicantidad"];
                $param["idproducto"] = $datos["idproducto"];
                $param["procantstock"] = $cantStock;
                //se actualiza el stock

                $seactualizo = $objCtrlProd->modificacion($param);
                $data["idcompraitem"] = $datos['idcompraitem'];
                $respuesta = $this->baja($data);
            }
        } else {
            $mensaje = "Error al pasar los datos";
        }

        $retorno["respuesta"] = $respuesta;
        $retorno["seactualizo"] = $seactualizo;
        if (isset($mensaje)) {
            $retorno["errorMsg"] = $mensaje;
        }
        return $retorno;
    }
}
