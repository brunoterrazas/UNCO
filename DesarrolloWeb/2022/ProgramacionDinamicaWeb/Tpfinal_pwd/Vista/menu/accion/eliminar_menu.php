<?php
include_once "../../../configuracion.php";
$data = data_submitted();
$objC = new AbmMenu();
$respuesta = $objC->bajaLogica($data);
if (!$respuesta) {

    $retorno['errorMsg'] ="No se pudo eliminar el menu";
}
$retorno['respuesta'] = $respuesta;
echo json_encode($retorno);
?>