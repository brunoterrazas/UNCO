<?php 
include_once "../../../configuracion.php";
$data = data_submitted();
$objC = new ABMUsuario();
$respuesta = $objC->registrarUsuario($data);
$retorno['respuesta'] = $respuesta;
if (!$respuesta){
    
    $retorno['errorMsg']="No pudo registrarse el usuario";
   
}
 echo json_encode($retorno);
 ?>
