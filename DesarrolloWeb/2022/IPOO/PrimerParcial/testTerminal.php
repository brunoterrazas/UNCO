<?php
include_once 'Responsable.php';
include_once 'Viaje.php';
include_once 'Empresa.php';
include_once 'Terminal.php';
$objResponsable= new Responsable("312312","Julio","Mendez","calle argentina sn","juas@gmail.com","116232343");
$objResponsable2= new Responsable("5612312","Enzo","Perez","calle argentina sn","juas@gmail.com","116232343");

$fechaActual=date ('d-m-y');
$hora_partida=date ('d-m-Y h:m:s');
$hora_llegada = "30-07-2022 05:59:00"; 
$objViaje=new Viaje("1","Las Grutas",$hora_partida,$hora_llegada,$fechaActual,20000,24,$objResponsable);
$objViaje2=new Viaje("2","Rio de Janeiro",$hora_partida,$hora_llegada,$fechaActual,20000,40,$objResponsable2);

echo $objViaje;
$objViaje->asignarAsientosDisponibles(12);
echo $objViaje;
$colViajes[0]=$objViaje;
$colViaje2[0]=$objViaje2;
$objEmpresa=new Empresa("E1","Seabourn Cruise Line",$colViajes);
$objEmpresa2=new Empresa("E2","Princess Cruises",$colViajes);



echo $objEmpresa;

?>