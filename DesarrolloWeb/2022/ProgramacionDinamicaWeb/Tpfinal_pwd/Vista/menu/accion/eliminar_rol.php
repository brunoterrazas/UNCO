<?php
include_once "../../../configuracion.php";
$data = data_submitted();
$objC = new AbmMenu();
$respuesta = $objC->borrar_rol($data);
$retorno["respuesta"]=$respuesta;
if(!$respuesta){
    $retorno['errorMsg'] = "No se pudo eliminar el rol";
}
echo json_encode($retorno);
?>