<?php
$dir="../";
$titulo="Ver Coordenada";
include_once $dir.'../estructura/header.php';
include_once $dir . '../../configuracion.php';
include_once $dir.'../../configAPI.php';
use Location\Coordinate;
use Location\Formatter\Coordinate\DMS;



 
?>
  <div class="container border border-secondary principal mt-3 pt-3">
<?php

$arredatos = data_submitted();
if (isset($arredatos["coordenadas"]))
 {

      $latitud = $arredatos["coordenadas"][0]["latitud"] ;
      $longitud =  $arredatos["coordenadas"][0]["longitud"] ;
      //echo "Datos enviados: <br> $Latitud <br> $Longitud <br>";
      $coordinate = new Coordinate($latitud, $longitud); 
      $formatter = new DMS();
      ?>
      
      <h3 class="text-center">Punto en el mapa</h3>
      <div id="mapa"></div>
        <script async src="https://maps.googleapis.com/maps/api/js?key=<?php echo $keyGMaps; ?>&callback=cargar"></script>
        <script>
          function cargar(){
           //Pasamos las coordenadas de php a javascript
            var latitud = <?php  echo $latitud; ?>;
            var longitud = <?php echo $longitud; ?>;
            inicio(latitud, longitud);
        }
        
        </script>  
    
    <div class="container-fluid">  
      <h6>Cambio del formato decimal, latitud <?php echo $latitud; ?> y longitud  <?php echo $longitud; ?> a:  </h6> 
      Grados, Minutos y Segundos :<br/> <?php echo $coordinate->format($formatter) . PHP_EOL; ?><br>

      Grados, Minutos y Segundos con detalle de los puntos cardinales : <br>
    
    <?php
    $formatter->setSeparator('  (N: Norte / S: Sur),<br>')
        ->useCardinalLetters(true)
        ->setUnits(DMS::UNITS_ASCII);

    echo $coordinate->format($formatter) . PHP_EOL."  (E: Este / W: Oeste)<br>";
    ?>
    </div>
   
    <script type="text/javascript" src="https://maps.google.com/maps/api/js?sensor=true"></script>
    <link rel="stylesheet" type="text/css" href="<?php echo $dir?>../css/estilo.css">
    <script type="text/javascript" src="<?php echo $dir?>../js/mostrarMapa.js"></script>
    <script type="text/javascript">
      mostrarCoordenadas(<?php echo $latitud;?>,<?php echo $longitud;?>);
    </script>
   <script src="<?php echo $dir; ?>../js/cargarCoordenada.js"></script>
   <br>

<a href="../formCoordenada.php" class="btn btn-secondary mt-3 text-center">Cambiar valores de coordenadas</a>
   
      
    <?php }else{
      echo "No se recibieron datos<br />";
  }
?>
  </div>
    
<?php 
include_once $dir.'../estructura/footer.php';
?>