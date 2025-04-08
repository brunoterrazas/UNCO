<?php
class ABMUsuario{

    /**
     * Espera como parametro un arreglo asociativo donde las claves coinciden con los nombres de las variables instancias del objeto
     * @param array $param
     * @return Usuario
     */
    private function cargarObjeto($param){
        $obj = null;
    //SELECT `idusuario`, `usnombre`, `uspass`, `usmail`, `usdeshabilitado` FROM `usuario` WHERE 1
           
        if( array_key_exists('idusuario',$param)  and array_key_exists('usnombre',$param) and array_key_exists('uspass',$param)
        and array_key_exists('usmail',$param) and array_key_exists('usdeshabilitado',$param)){
            $obj = new Usuario();
            $obj->setear($param['idusuario'],$param['usnombre'],$param['uspass'],$param['usmail'],$param['usdeshabilitado']);
        }
        return $obj;
    }
    
    /**
     * Espera como parametro un arreglo asociativo donde las claves coinciden con los nombres de las variables instancias del objeto que son claves
     * @param array $param
     * @return Tabla
     */
    
    private function cargarObjetoConClave($param){
        $obj = null;
        if( isset($param['idusuario']) ){
            $obj = new Usuario();
            $obj->setear($param['idusuario'], null,null,null,null);
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
        if (isset($param['idusuario']))
            $resp = true;            
        return $resp;
    }
      /**
     * permite registrar a un usuario. 
     * @param array $param
     * @return Usuario
     */
    public function alta($param){
        $resp = null;
        $param['idusuario'] =null;
        $elObjtUsuario = $this->cargarObjeto($param);

        if ($elObjtUsuario!=null and $elObjtUsuario->insertar()){
            $resp = $elObjtUsuario;
            
        }
        return $resp;
        
    }
  /**
     * permite quitar un rol a un usuario. 
     * @param array $param
     * @return boolean
     */
    public function borrar_rol($param){
        $resp = false;
        if(isset($param['idusuario']) && isset($param['idrol'])){
            $elObjtUsuario = new UsuarioRol();
            $elObjtUsuario->setearConClave($param['idusuario'],$param['idrol']);
            $resp = $elObjtUsuario->eliminar();
            
        }
       
        return $resp;
        
    }
      /**
     * permite asignar un rol a un usuario. 
     * @param string $param
     * @return
     */
    public function alta_rol($param){
        $resp = false;
        if(isset($param['idusuario']) && isset($param['idrol'])){
            $elObjtUsuario = new UsuarioRol();
            $elObjtUsuario->setearConClave($param['idusuario'],$param['idrol']);
            $resp = $elObjtUsuario->insertar();
           

        }
       
        return $resp;
        
    }
    /**
     * permite realizar el borrado logico de un usuario. 
     * @param array $param
     * @return boolean
     */
    public function bajaLogica($param){
        $resp = false;
        if ($this->seteadosCamposClaves($param)){
            $elObjtUsuario = $this->cargarObjetoConClave($param);
            if ($elObjtUsuario!=null and $elObjtUsuario->modificar("borradoLogico")){
                $resp = true;
            }
        }
        
        return $resp;
    }
    
    /**
     * permite modificar un usuario
     * @param array $param
     * @return boolean
     */
    public function modificacion($param){
           $resp = false;
        if ($this->seteadosCamposClaves($param)){
            $elObjtUsuario = $this->cargarObjeto($param);            
            if($elObjtUsuario!=null and $elObjtUsuario->modificar("")){
                $resp = true;
            }
        }       
        return $resp;
    }
 /**
     * Retorna un lista de objetos UsuarioRol
     * @param array $param
     * @return array
     */
    public function darRoles($param){
        $where = " true ";
        if ($param<>NULL){
            if  (isset($param['idusuario']))
                $where.=" and idusuario =".$param['idusuario'];
            if  (isset($param['idrol']))
                 $where.=" and idrol ='".$param['idrol']."'";
        }
        $obj = new UsuarioRol();
        $arreglo = $obj->listar($where);
        //echo "Van ".count($arreglo);
        return $arreglo;
    }

    
    /**
     * permite buscar y listar uno o mas objetos Usuario
     * @param string $param
     * @return array
     */
    public function buscar($param){
        $where = " true ";
        if ($param<>NULL){
            if  (isset($param['idusuario']))
                $where.=" and idusuario =".$param['idusuario'];
            if  (isset($param['usnombre']))
                 $where.=" and usnombre ='".$param['usnombre']."'";
            if  (isset($param['usmail']))
                 $where.=" and usmail ='".$param['usmail']."'";
            if  (isset($param['uspass']))
                 $where.=" and uspass ='".$param['uspass']."'";
            if  (isset($param['usdeshabilitado']))
                 $where.=" and usdeshabilitado ='".$param['usdeshabilitado']."'";
        }
        //$obj = new Usuario();
        $arreglo = Usuario::listar2($where);
       
        return $arreglo;
    }
     /**
     * Permite registrar a un nuevo usuario, automaticamente se le asigna el rol de cliente
     * @param array $data
     * @return boolean
     */
    function registrarUsuario($data)
    {
        $respuesta = false;
        if (isset($data['usnombre'])) {
            $objC = new ABMUsuario();
            $objUsuario = $objC->alta($data);
            if ($objUsuario != null) {


                $datos["idusuario"] = $objUsuario->getidusuario();
                //le asignamos rol de cliente
                $datos["idrol"] = 2;
                $respuesta = $objC->alta_rol($datos);
            }
        }
        return $respuesta;
    }
}
?>