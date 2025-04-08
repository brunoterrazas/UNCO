<?php
include_once "../../../configuracion.php";
$data = data_submitted();
$objC = new ABMUsuario();
$respuesta = $objC->bajaLogica($data);
$retorno['respuesta'] = $respuesta;
if (!$respuesta) {
    $retorno['errorMsg'] = "No se pudo eliminar al usuario";
}
echo json_encode($retorno);
?>