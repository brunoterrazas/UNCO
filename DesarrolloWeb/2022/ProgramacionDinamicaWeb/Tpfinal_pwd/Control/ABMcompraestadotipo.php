<?php
class ABMcompraestadotipo{
  
     /**
     * Espera como parametro un arreglo asociativo donde las claves coinciden con los nombres de las variables instancias del objeto
    *@param array $param
    *@return CompraEstadoTipo
    */
    private function cargarObjeto($param){
        $obj = null;

        if (array_key_exists('idcompraestadotipo', $param) and array_key_exists('cetdescripcion', $param) and array_key_exists('cetdetalle', $param)  ){
            $obj = new CompraEstadoTipo();
            $obj->setear($param['idcompraestadotipo'], $param['cetdescripcion'], $param['cetdetalle']);
        }
        //print_r($obj);
        return $obj;
    }
    
     /**
     * Espera como parametro un arreglo asociativo donde las claves coinciden con los nombres de las variables instancias del objeto que son claves
     * @param array $param
     * @return CompraEstadoTipo
     */
    private function cargarObjetoConClave($param){
        $obj = null;
        if(isset($param['idcompraestadotipo'])){
            $obj = new CompraEstadoTipo();
            $obj->setear($param['idcompraestadotipo'], null, null);
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
        if (isset($param['idcompraestadotipo']))
            $resp = true;
        //echo "SeteadosCamposClaves". $resp;
        return $resp;
     }
     public function alta($param){
        
        $resp = false;
        //$param['idcompraestadotipo']=null;

        $elObjcet = $this->cargarObjeto($param);
        
        if ($elObjcet!=null and $elObjcet->insertar()){
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
            $elObjcet = $this->cargarObjetoConClave($param);
            if($elObjcet!=null and $elObjcet->modificar("borradoLogico")){
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
            $elObjcet = $this->cargarObjeto($param);
            //print_r($param);
            if($elObjcet!=null and $elObjcet->modificar()){
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
        //echo "Este dato ingresa a Buscar en ABMusuario";
        
        //print_r($param);
        //echo "<br>";
        //print_r ($param['usmail']);
        if($param<>NULL){
            if(isset($param['idcompraestadotipo'])) 
                $where.=" and idcompraestadotipo = ".$param['idcompraestadotipo'];
            if(isset($param['cetdescripcion'])) 
                $where.=" and cetdescripcion ='".$param['cetdescripcion']."'";
            
        }
      
        $arreglo = CompraEstadoTipo::listar($where);
        
    
        return $arreglo;
       }
      
   
}



?>