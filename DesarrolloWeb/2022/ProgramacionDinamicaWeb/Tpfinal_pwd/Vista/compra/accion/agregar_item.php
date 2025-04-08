<?php
include_once "../../../configuracion.php";
$valores=data_submitted();
$objCntrlC=new ABMcompra();
$retorno=$objCntrlC->agregarItem($valores);
echo json_encode($retorno);