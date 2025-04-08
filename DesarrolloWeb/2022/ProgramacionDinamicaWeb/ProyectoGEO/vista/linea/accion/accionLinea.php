<?php
$dir="../";
$titulo="Ver Linea";
include_once $dir.'../estructura/header.php';
include_once $dir . '../../configuracion.php';
include_once $dir . '../../configAPI.php';
use Location\Coordinate;
use Location\Distance\Vincenty;
use Location\Distance\Haversine;
use Location\Line;
use Location\CardinalDirection\CardinalDirectionDistancesCalculator;

$arredatos = data_submitted();
if (isset($arredatos["coordenadas"]))
 {
 
  // print_r($arredatos["coordenadas"]);
  
  $line = new Line(new Coordinate($arredatos["coordenadas"][0]["latitud"], $arredatos["coordenadas"][0]["longitud"]), new Coordinate($arredatos["coordenadas"][1]["latitud"], $arredatos["coordenadas"][1]["longitud"]));

  $midpoint = $line->getMidPoint();
  ?>
  <div class="container border border-secondary principal mt-3 pt-3">
  <h3 class="text-center">Ver Linea</h3>
  <div id="mapa"></div>
    <script async src="https://maps.googleapis.com/maps/api/js?key=<?php echo $keyGMaps; ?>&callback=cargar"></script>
    <script>
        function cargar(){
           //Pasamos un array asociativo de php a javascript
            var datos = <?php  echo json_encode($arredatos["coordenadas"]); ?>;
            var latPuntoMedio=<?php echo  $midpoint->getLat();?>;
            var lonPuntoMedio=<?php echo  $midpoint->getLng();?>;
            inicio(datos,latPuntoMedio,lonPuntoMedio);
        }

    </script>
<script src="<?php echo $dir; ?>../js/cargarLinea.js"></script>
  <?php 

      //invocación del método para calcular la longitud de la línea usando 2 las dos clase disponible, Vincenty y Haversine.
  echo "<h6>Longitud de la Línea</h6> ".$line->getLength(new Vincenty())." metros usando la clase Vincenty.<br> ".$line->getLength(new Haversine())." metros usando la clase Haversine.<br> ";
  //método de la línea para cálcular el punto medio de la línea. Muestra las coordenadas y la distancia en metros.
  $midpoint = $line->getMidPoint();
  printf(
    '<h6>Punto medio de la línea</h6> Se encuentra a %.3f grados de latitud y a %.3f grados de longitud.%s<br>',
    $midpoint->getLat(),
    $midpoint->getLng(),
    PHP_EOL
  );

  printf(
    '<h6>Distancia desde cada punto</h6> 
    Desde el primer punto es %.1f metros y desde el segundo punto es %.1f metros.%s (Vincenty)<br>',
    $line->getPoint1()->getDistance($midpoint, new Vincenty()),
    $line->getPoint2()->getDistance($midpoint, new Vincenty()),
    PHP_EOL
  );
  printf(
    'Desde el primer punto es %.1f metros y desde el segundo punto es %.1f metros.%s (Haversine) <br>',
    $line->getPoint1()->getDistance($midpoint, new Haversine()),
    $line->getPoint2()->getDistance($midpoint, new Haversine()),
    PHP_EOL
);

  $calculator = new Haversine();
  $cardinalDirectionDistancesCalculator = new CardinalDirectionDistancesCalculator();

  $result = $cardinalDirectionDistancesCalculator->getCardinalDirectionDistances($line->getPoint1(), $line->getPoint2(), $calculator);

  echo '<h6>Distancia Cardinal: (Haversine)</h6> Norte=' . ($result->getNorth()/1000). ' Km;<br/> Este=' . ($result->getEast()/1000). ' Km;<br/> Sur=' . ($result->getSouth()/1000). ' Km;<br/> Oeste=' . ($result->getWest()/1000) . ' Km.<br/>';
}
  else{
      echo "Error, no se cargaron los datos.";
}
?>

<br>

          <a href="../formLinea.php" class="btn btn-secondary mt-3 text-center">Cambiar valores de coordenadas</a>
</div>
<?php
include_once $dir.'../estructura/footer.php';
?>