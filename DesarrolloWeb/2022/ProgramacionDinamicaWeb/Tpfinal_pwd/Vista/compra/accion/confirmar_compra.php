<?php
include_once "../../../configuracion.php";


$datos = data_submitted();

$objCntrlCE = new ABMcompraestado();
//Verifico si tengo una compra con estado en confeccion
$retorno = $objCntrlCE->confirmarCompra($datos);
echo json_encode($retorno);
?>