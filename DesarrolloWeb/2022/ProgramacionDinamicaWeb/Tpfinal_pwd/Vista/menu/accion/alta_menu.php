<?php
include_once "../../../configuracion.php";
$data = data_submitted();
$objC = new AbmMenu();
$respuesta = $objC->alta($data);
if (!$respuesta) {
    $retorno['errorMsg'] = "No se pudo agregar";
}

$retorno['respuesta'] = $respuesta;

echo json_encode($retorno);
?>