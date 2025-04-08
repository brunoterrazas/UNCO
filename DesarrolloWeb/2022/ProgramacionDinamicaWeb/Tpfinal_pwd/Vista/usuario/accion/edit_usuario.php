<?php
include_once "../../../configuracion.php";
$data = data_submitted();
$objSesion = new Session();

$idusuario = $objSesion->getUsuario()->getIdusuario();
$data["idusuario"] = $idusuario;
$objC=new ABMUsuario();
$respuesta = $objC->modificacion($data);

if (!$respuesta) {

    $retorno['errorMsg'] = "No pudo eliminarse el usuario";
}


$retorno['respuesta'] = $respuesta;


echo json_encode($retorno);
?>