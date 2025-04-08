<?php
include_once "../../../configuracion.php";
$data = data_submitted();
$respuesta = false;
if (isset($data['idproducto'])){
    $objC = new ABMproducto();
    $respuesta = $objC->modificacion($data);
}
$retorno['respuesta'] = $respuesta;
if (!$respuesta){
    
    $retorno['errorMsg']=" La accion  MODIFICACION No pudo concretars";
    
}
echo json_encode($retorno);
?>