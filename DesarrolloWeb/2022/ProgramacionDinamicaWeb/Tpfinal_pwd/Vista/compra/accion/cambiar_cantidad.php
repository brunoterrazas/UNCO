<?php
include_once "../../../configuracion.php";
$valores=data_submitted();
$objControlCI=new ABMcompraitem();
$res=$objControlCI->cambiarCantidadItem2($valores);

echo $res;
?>