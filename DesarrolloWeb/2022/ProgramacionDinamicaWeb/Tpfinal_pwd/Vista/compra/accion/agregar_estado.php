<?php
include_once "../../../configuracion.php";
require_once("enviarMail.php");
  

$datos=data_submitted();

if (isset($datos["idcompra"])){

$objCtrlCE=new ABMcompraestado();  
$retorno= $objCtrlCE->actualizarEstadoCompra($datos);
}
else{
    $retorno["respuesta"]=false;
}


    echo json_encode($retorno);
