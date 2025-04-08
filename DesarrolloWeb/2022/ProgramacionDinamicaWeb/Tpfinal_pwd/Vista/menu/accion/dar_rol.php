<?php
include_once "../../../configuracion.php";
$data = data_submitted();
$objC = new AbmMenu();
$respuesta = $objC->alta_rol($data);
if (!$respuesta) {
    $retorno['errorMsg'] = "No se pudo asignar el rol";
}

$retorno['respuesta'] = $respuesta;

echo json_encode($retorno);
?>