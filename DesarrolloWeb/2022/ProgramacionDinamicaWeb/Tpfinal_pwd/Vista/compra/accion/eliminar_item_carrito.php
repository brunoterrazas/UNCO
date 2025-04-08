<?php 

include_once "../../../configuracion.php";
$datos=data_submitted();

$objC = new ABMcompraitem();
$retorno=$objC->eliminarItem($datos);
echo json_encode($retorno);
?>