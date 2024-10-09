<?php 



$horas=new DateTime("13:41:00");
//$hora1=$horasformat
echo  strlen($horas->is_string);
//$horas2=new DateTime("14:21:00");
//echo $horas2;
$fecha=getdate();
$dia=$fecha["mday"];
$mes=$fecha["mon"];
$anio=$fecha["year"];
if($dia<10)
$dia="0".$dia;
if($mes<10)
$mes="0".$mes;
$fechaActual=$anio."-".$mes."-".$dia."\n";
echo $fechaActual;
function calcularDias()
{
$fecha= new DateTime("now");
$fechaVencimiento= new DateTime("2022-06-05");
$res = $fecha->diff($fechaVencimiento);
$dias=$res->days;
echo $dias. ' dias';
if($dias>0&&$dias<10)
{
    echo "atrasado";
}
if($dias>=10)
{
    echo "deudor moroso";
}
return $dias;
}
echo "desde metodo dias->".calcularDias();
/*$fecha= date_create("12-09-2022");
$fechaVenc=date_format($fecha,"d-m-Y");
//Fecha actual
$fecha1=  new DateTime("23-09-2022");
$fechaActual=$fecha1;
//Fecha vencimiento
$fecha2=new DateTime("12-03-2022");
$fechaVencimiento=$fecha2->format("d-m-Y");

$dias=($fecha1->diff($fecha2));*/
//echo $dias;
//$diff = $fecha1->diff($fecha2);

// El resultados sera 3 dias
//echo $diff->days . ' dias';
//echo $fechaActual."\n";
//echo $fechaVencimiento."\n";

/*echo $fechaVenc."\n";
$fecha2=date("d-m-Y");
echo $fecha2."\n";
if($fecha2>$fechaVenc)
{

    echo "la fecha esta vencida";
}
else{
    echo "esta vigente\n";
}
echo "dias".(strToTime($fecha2)-strToTime($fechaVenc)/8400).""; 
*/?>