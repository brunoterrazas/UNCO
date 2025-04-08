<?php 
class ABMmenurol{
    //Espera como parámetro un arrego asociativo donde las claves coinciden con los nombres de las variables instancias del objeto
    public function abm($datos){
        $resp = false;
        if($datos['accion']=='editar'){
            if($this->modificacion($datos)){
                $resp = true;
            }
        }
        if($datos['accion']=='borradoLogico'){
            if($this->bajaLogica($datos)){
                $resp =true;
            }
        }
        if ($datos['accion'] == 'nuevo') {
            $objMenurol=null;
            if (isset($datos['idmenu'])) {
                $arraymenurol= ['idmenu' => $datos['idmenu']];
     
                $objMenurol = $this->buscar($arraymenurol);
           
            }
            if ($objMenurol == null) {
              
                    if (isset($datos['accion'])) {
                   
                        if ($this->alta($datos)) {
                            $resp = true;
                        }
                    }
                  
            }
            else {
                echo "El correo electrónico ya esta registrado";
            }
        }



        return $resp;

        }
     /**
     * Espera como parametro un arreglo asociativo donde las claves coinciden con los nombres de las variables instancias del objeto
    *@param array $param
    *@return MenuRol
    */
    private function cargarObjeto($param){
        $obj = null;

        if (array_key_exists('idmenu', $param) and array_key_exists('idrol', $param) ){
            
            $obj = new MenuRol();
            
            $objMenu = new Menu();
            $objMenu->setIdmenu($param['idmenu']);
            $objMenu->cargar();

            $objRol = new Rol();
            $objRol->setIdrol($param['idrol']);
            $objRol->cargar();

            $obj->setear($objMenu, $objRol );
        }
        //print_r($obj);
        return $obj;
    }
    
     /**
     * Espera como parametro un arreglo asociativo donde las claves coinciden con los nombres de las variables instancias del objeto que son claves
     * @param array $param
     * @return MenuRol
     */
    private function cargarObjetoConClave($param){
        $obj = null;
        if(isset($param['idmenu']) and isset($param['idrol'])){
            $obj = new MenuRol();

            $objMenu = new Menu();
            $objMenu->setIdmenu($param['idmenu']);
            $objMenu->cargar();

            $objRol = new Rol();
            $objRol->setIdrol($param['idrol']);
            $objRol->cargar();

            $obj->setear($objMenu, $objRol );
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
        if (isset($param['idmenu']))
            $resp = true;
     
        return $resp;
     }
     public function alta($param){
     
        $resp = false;
        

        $elObjmenurol = $this->cargarObjeto($param);
        if ($elObjmenurol!=null and $elObjmenurol->insertar()){
            $resp = true;
        }
        return $resp;
     }
      /**
     * permite eliminar un objeto 
     * @param array $param
     * @return boolean
     */
    
    public function bajaLogica($param){
        $resp = false;
        if ($this->seteadosCamposClaves($param)){
            $elObjmenurol = $this->cargarObjetoConClave($param);
            if($elObjmenurol!=null and $elObjmenurol->modificar("borradoLogico")){
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
    public function modificacion($param){
        $resp = false;
        if($this->seteadosCamposClaves ($param)){
            $elObjmenurol = $this->cargarObjeto($param);
            
            if($elObjmenurol!=null and $elObjmenurol->modificar()){
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
    public function buscar($param){
        $where = " true ";
            if($param<>NULL){
            if(isset($param['idmenu'])) 
                $where.=" and idmenu = ".$param['idmenu'];
            if (isset($param['idrol']))
                $where .= " and idrol = ".$param['idrol'];
            
        }

        $arreglo = MenuRol::listar($where);
     
        return $arreglo;
       }
      
   
}

?>