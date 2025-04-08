<?php
include_once "../../../configuracion.php";
$data = data_submitted();
$objC = new ABMproducto();
$respuesta = $objC->alta($data);
$retorno['respuesta'] = $respuesta;
if (!$respuesta) {

    $retorno['errorMsg'] = "No pudo crearse el producto";
}
echo json_encode($retorno);
?>