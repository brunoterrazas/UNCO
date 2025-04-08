<?php
include_once "../../../configuracion.php";
$data = data_submitted();
$objC = new AbmMenu();
$respuesta = $objC->modificacion($data);
$retorno['respuesta'] = $respuesta;
if (!$respuesta) {

  $retorno['errorMsg'] = "No se pudo modificar el menu";
}
echo json_encode($retorno);
?>