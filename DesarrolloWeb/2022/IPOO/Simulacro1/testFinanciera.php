<?php 
require_once 'Financiera.php';
require_once 'Prestamo.php';
require_once 'Persona.php';
require_once 'Cuota.php';



$persona1=new Persona("Pepe","Flores","234234","Bs As 12","dir@gmail.com","299634323",40000);
$persona2=new Persona("Luis","Suarez","345544","Bs As 123","ls22@gmail.com","299634323",4000);
$persona3=new Persona("Juan Cruz","Perez","234234","av. Argentina #232","jcaa@gmail.com","299634323",4000);
$prestamo1= new Prestamo(1,"C9991",50000,5,1,$persona1);
$prestamo2= new Prestamo(2,"C9992",50000,4,1,$persona2);
$prestamo3= new Prestamo(3,"C9992",50000,2,1,$persona2);
$colPrestamos[0]=$prestamo1;
$financiera=new Financiera($colPrestamos,"Calle Dr Ramon 233","Financiera Neuquen");
echo $financiera;
$financiera->incorporarPrestamo($prestamo2);
$financiera->incorporarPrestamo($prestamo3);
echo $financiera;
$financiera->otorgarPrestamoSiCalifica();
echo $financiera;

$cuota=$financiera->informarCuotaPagar(2);
if($cuota<>null){
    echo $cuota."\nMonto final a pagar:".$cuota->darMontoFinalCuota();
    
    }
    else{

        
    }
?>