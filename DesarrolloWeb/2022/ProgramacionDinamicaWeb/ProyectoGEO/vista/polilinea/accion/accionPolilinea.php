<?php
$dir = "../";
$titulo = "Ver Polilinea";
include_once $dir . '../estructura/header.php';
include_once $dir . '../../configuracion.php';
include_once $dir . '../../configAPI.php';

use Location\Coordinate;
use Location\Polyline;
use Location\Distance\Vincenty;
use Location\Distance\Haversine;
use Location\Formatter\Coordinate\DMS;

$arredatos = data_submitted();
if (isset($arredatos["coordenadas"])) {


  $objControl = new CtrlCoordenada();
  //Validamos las coordenadas
  if ($objControl->validarCoordenada($arredatos["coordenadas"])) {
    //creamos una instancia de la clase poligono
    $polyline = new Polyline();
    for ($i = 0; $i < count($arredatos["coordenadas"]); $i++) {
      //agregamos coordenada
      $polyline->addPoint(new Coordinate($arredatos["coordenadas"][$i]["latitud"], $arredatos["coordenadas"][$i]["longitud"]));
    }
?>
    <div class="container border border-secondary principal mt-3 pt-3">
      <h3 class="text-center">Ver Polil&iacute;nea</h3>
      <div id="mapa"></div>
      <script async src="https://maps.googleapis.com/maps/api/js?key=<?php echo $keyGMaps; ?>&callback=cargar"></script>
      <script>
         function cargar(){
           //Pasamos un array asociativo de php a javascript
            var datos = <?php  echo json_encode($arredatos["coordenadas"]); ?>;
            
            inicio(datos);
        }
      </script>
<script src="<?php echo $dir; ?>../js/cargarPolilinea.js"></script>
  <?php
    echo "PHPGeo tiene una implementación de polilíneas que se puede usar para calcular la longitud de un track GPS o una ruta. Una polilínea consta de al menos tres puntos. <br/>";

    echo "<h6>Longitud de la polil&iacute;nea</h6> " . $polyline->getLength(new Vincenty()) . " metros usando la clase Vincenty. <br/>" . $polyline->getLength(new Haversine()) . " metros usando la clase Haversine.<br>";
  }

  //Devuelve la longitud de cada segmento de la Polilínea, usando la clase Haversine    
  echo "<h6>Longitud de cada segmento</h6>";
  foreach ($polyline->getSegments() as $segment) {
      printf("%0.2f kilometros\n <br>",
      ($segment->getLength(new Haversine()) / 1000). "<br>");
  }
  //Devuelve la lista de puntos
  printf("<h6>Detalle en Grados, Minutos y Segundos de los %d puntos de la polilínea\n</h6>", $polyline->getNumberOfPoints());

  foreach ($polyline->getPoints() as $point) {
      echo $point->format(new DMS()). "<br>" . PHP_EOL;
  }

  ?> 
    <br/>
          <a href="../polilinea.php" class="btn btn-secondary mt-3 text-center">Ingrese otra polil&iacute;nea</a>
  <?php
} else {
  echo "Error, no se cargaron los datos.";
}
  ?>
    </div>
    <?php
    include_once $dir . '../estructura/footer.php';
    ?>