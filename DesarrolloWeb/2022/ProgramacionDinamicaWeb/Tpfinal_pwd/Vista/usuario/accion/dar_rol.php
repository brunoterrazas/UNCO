<?php 
include_once "../../../configuracion.php";
$data = data_submitted();
$objC = new ABMUsuario();
$respuesta = $objC->alta_rol($data);
$retorno['respuesta'] = $respuesta;
if (!$respuesta){
    
    $retorno['errorMsg']="No se pudo asignar el rol";
   
}
 echo json_encode($retorno);
?>


