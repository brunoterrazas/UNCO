<?php 
include_once 'Categoria.php';
include_once 'Equipo.php';
include_once 'Partido.php';
include_once 'Futbol.php';
include_once 'Basket.php';
include_once 'Torneo.php';
$objCategoria1=new Categoria(1,"Menores",0.11);
$objCategoria2=new Categoria(2,"Juveniles",0.17);
$objCategoria3=new Categoria(3,"Mayores",0.23);
$objE1=new Equipo("Real Madrid","Marcelo Mendez",$objCategoria1,11);
$objE2=new Equipo("Barcelona","Marcelo Mendez",$objCategoria1,11);
$objE3=new Equipo("Atletico Madrid","Marcelo Mendez",$objCategoria1,11);
$objE4=new Equipo("Chelsea","Marcelo Mendez",$objCategoria1,11);
$objE5=new Equipo("Manchester City","Marcelo Mendez",$objCategoria1,11);
$objE6=new Equipo("Real Sociedad","Marcelo Mendez",$objCategoria1,11);
$objE7=new Equipo("San","Mart",$objCategoria1,12);
$objE8=new Equipo("Real","Marcelo Mendez",$objCategoria1,12);
$objE9=new Equipo("Madrid","Marcelo Mendez",$objCategoria1,12);
$objE10=new Equipo("Saint Germain","Marcelo Mendez",$objCategoria1,12);
$objE11=new Equipo("San Lorenzo","Marcelo Mendez",$objCategoria1,12);
$objE12=new Equipo("Olimpiakos","Marcelo Mendez",$objCategoria1,12);
$objPart1 = new Basket($objE7 ,$objE8,'2020-10-10',1,80,120,30,75); 
$objPart2 = new Basket($objE9 ,$objE10,'2020-10-25',2,81,110,30,70);
$objPart3 = new Basket($objE11 ,$objE12,'2020-11-25',3,115,85,30,110);
$objPart4 = new Futbol($objE1 ,$objE2,'2020-10-25',4,3,2,11);
$objPart6 = new Futbol($objE5 ,$objE6,'2020-11-30',5,2,3,11);
$objTorneo=new Torneo(10000);
echo $objTorneo;
echo"Cargar partidos.....\n";
$colPartidos=$objTorneo->getColPartidos(); 
$colPartidos[]=$objPart1;
$colPartidos[]=$objPart2;
$colPartidos[]=$objPart3;
$colPartidos[]=$objPart4;
$colPartidos[]=$objPart6;
$objTorneo->setColPartidos($colPartidos);
echo $objTorneo;
$fecha = date('d-m-Y');
$partido=$objTorneo->ingresarPartido($objE1, $objE2, "10-11-2020","basket"); 
if($partido!=null)
echo $partido;
else{echo "error partido";}
echo"\n";
echo $objTorneo;
$colGanadoresFutbol=$objTorneo->darGanadores("futbol");
echo "\nGANADORES FUTBOL\n";

foreach($colGanadoresFutbol as $ganador)
{
    echo  "Equipo Ganador:".$ganador->__toString();    
}

echo"calcularPremio\n";
$arre=$objTorneo->calcularPremioPartido($objPart1);
//print_r($arre);

$cadena="";
foreach($arre as $key=>$value)
{
            
    $cadena.= "".$key."\n".$value;
}
echo $cadena;
?>