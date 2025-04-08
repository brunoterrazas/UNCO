<?php

include_once '../../../configuracion.php';

$datos = data_submitted();
$objSession = new Session();
$resp = $objSession->cerrar();
$retorno['respuesta'] = $resp; //true o false

echo json_encode($retorno);

?>