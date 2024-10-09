<?php 
include_once 'Categoria.php';
include_once 'Equipo.php';
include_once 'Partido.php';
include_once 'Futbol.php';
include_once 'Basket.php';
include_once 'Torneo.php';
include_once 'Nacional.php';
include_once 'Provincial.php';
include_once 'MinisterioDeporte.php';
$objCategoria1=new Categoria(1,"Menores",0.11);
$objCategoria2=new Categoria(2,"Juveniles",0.17);
$objCategoria3=new Categoria(3,"Mayores",0.23);
$objE1=new Equipo("Real Madrid","Marcelo Mendez",$objCategoria1,11);
$objE2=new Equipo("Barcelona","Marco Polo",$objCategoria1,11);
$objE3=new Equipo("Atletico Madrid","Marcela",$objCategoria1,11);
$objE4=new Equipo("Chelsea","Marcelo Mendez",$objCategoria1,11);
$objE5=new Equipo("Manchester City","Marcelo Mendez",$objCategoria1,11);
$objE6=new Equipo("Real Sociedad","Marcelo Mendez",$objCategoria1,11);
$objE7=new Equipo("San","Mart",$objCategoria1,12);
$objE8=new Equipo("Real","Marcelo Mendez",$objCategoria1,12);
$objE9=new Equipo("Madrid","Marcelo Mendez",$objCategoria1,12);
$objE10=new Equipo("Saint Germain","Lopez",$objCategoria1,12);
$objE11=new Equipo("San Lorenzo","Morena",$objCategoria1,12);
$objE12=new Equipo("Olimpiakos","Mark",$objCategoria1,12);
$objPart1 = new Basket($objE7 ,$objE8,'2020-10-10',1,80,120,30,75); 
$objPart2 = new Basket($objE9 ,$objE8,'2020-10-25',2,81,110,30,70);
$objPart3 = new Basket($objE11 ,$objE12,'2020-11-25',3,115,85,30,110);
$objPart4 = new Futbol($objE1 ,$objE2,'2020-10-25',4,3,2,11);
$objPart6 = new Futbol($objE5 ,$objE6,'2020-11-30',5,3,2,11);
$objPart7 = new Futbol($objE1 ,$objE3,'2020-10-25',4,2,1,11);
$objTorneo=new Nacional(1,10000,[]);



echo $objTorneo;
echo"Cargar partidos.....\n";
$colPartidos=$objTorneo->getColPartidos(); 
/*$colPartidos[]=$objPart1;
$colPartidos[]=$objPart2;
$colPartidos[]=$objPart3;*/
$colPartidos[]=$objPart4;
$colPartidos[]=$objPart6;
$colPartidos[]=$objPart7;
$objTorneo->setColPartidos($colPartidos);

echo"\n";
echo $objTorneo;
//echo "\nGANADORES\n";
$arreGanador=$objTorneo->obtenerEquipoGanadorTorneo();
//print_r($arreGanador);

foreach($arreGanador as $key=>$value)
{
            
    $cadena.= "\n".$key."\n".$value;
}
echo $cadena;
$premioNacional=$objTorneo->obtenerPremioTorneo();
echo "\nPremio: ".$premioNacional;
echo"\n TORNEO PROVINCIAL\n";
$colPartidosProv[]=$objPart1;
$colPartidosProv[]=$objPart2;
$colPartidosProv[]=$objPart3;
$objTorneoProv=new Provincial(1,10000,$colPartidosProv,"Neuquén");
echo $objTorneoProv;

$arreGanadorProv=$objTorneoProv->obtenerEquipoGanadorTorneo();
$cadena2="";
foreach($arreGanadorProv as $key=>$value)
{
            
    $cadena2.= "\n".$key."\n".$value;
}

echo $cadena2;
$premioProvincial=$objTorneoProv->obtenerPremioTorneo();
echo "\nPremio provincial: ".$premioProvincial;

$objMinDep=new MinisterioDeporte(2022,[]);
$ArrayAsociativo["idTorneo"]=1;
$ArrayAsociativo["premio"]=20000;
$objMinDep->registrarTorneo($colPartidos,"nacional",$ArrayAsociativo);
$ArrayAsociativo["idTorneo"]=2;
$ArrayAsociativo["premio"]=20000;
$ArrayAsociativo["provincia"]="Neuquen";
$objMinDep->registrarTorneo($colPartidosProv,"provincial",$ArrayAsociativo);

$colTorneos=$objMinDep->getColTorneos();
print_r($colTorneos);
?>