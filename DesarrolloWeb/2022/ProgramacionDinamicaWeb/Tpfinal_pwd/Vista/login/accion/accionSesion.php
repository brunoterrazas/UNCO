<?php

include_once '../../../configuracion.php';

$datos = data_submitted();
$resp = false;
if (isset($datos['usnombre']) && $datos['uspass']) {
    $objTrans = new Session();
    $resp = $objTrans->iniciar($datos['usnombre'], $datos['uspass']);
}
$retorno['respuesta'] = $resp; //true o false
if (!$resp) {
    $retorno['errorMsg'] = "Vuelva a ingresar los datos";
}
echo json_encode($retorno);
?>