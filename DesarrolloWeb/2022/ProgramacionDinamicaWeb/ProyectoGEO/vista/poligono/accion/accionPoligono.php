<?php
$dir = "../";
$titulo = "Ver Poligono";
include_once $dir . '../estructura/header.php';
include_once $dir . '../../configuracion.php';
include_once $dir . '../../configAPI.php';


use Location\Coordinate;
use Location\Polygon;
use Location\Distance\Vincenty;
use Location\Distance\Haversine;
use Location\Formatter\Coordinate\DMS;
use Location\Formatter\Polygon\GeoJSON;
?><div class="container border border-secondary principal mt-3 pt-3">
    <?php
    $arredatos = data_submitted();
     if(isset($arredatos["coordenadas"]))
     {
        
  
        $objControl = new CtrlCoordenada();
        //Validamos las coordenadas
        if ($objControl->validarCoordenada($arredatos["coordenadas"])) {
        //Creamos una instancia de la clase poligono
        $polygon = new Polygon();
        //Agregamos cada coordenada al poligono 
        for ($i = 0; $i < count($arredatos["coordenadas"]); $i++) {
          /*Usamos el metodo addPoint(latitud,longitud) para agregar las coordenadas del poligono*/  
          $polygon->addPoint(new Coordinate($arredatos["coordenadas"][$i]["latitud"], $arredatos["coordenadas"][$i]["longitud"]));
        }
  
    ?>
        <h3 class="text-center">Ver Poligono</h3>
       
        <div id="mapa"></div>

        <script async src="https://maps.googleapis.com/maps/api/js?
key=<?php echo $keyGMaps; ?>&callback=cargar"></script>
        <script>         
        function cargar(){
           //Pasamos un array asociativo de php a javascript
            var datos = <?php  echo json_encode($arredatos["coordenadas"]); ?>;
              inicio(datos);
                }
        </script>
        <script src="<?php echo $dir; ?>../js/cargarPoligono.js"></script>
    <?php
        //Devuelve el cálculo del área y el perímetro del polígono
        printf(
            '<h6>Área del Polígono </h6> %f m² <br> <h6>Perímetro del Polígono</h6> %f m%s (Clase Vinventy)<br>',
            $polygon->getArea(),
            $polygon->getPerimeter(new \Location\Distance\Vincenty()),
            
            PHP_EOL
        );
        echo $polygon->getPerimeter(new Haversine()) . " m (Clase Haversine)<br>";

        //Devuelve la longitud de cada segmento del Polígono, usando la clase Haversine    
        echo "<h6>Longitud de cada segmento</h6>";
        foreach ($polygon->getSegments() as $line) {
            printf(" %0.3f m\n <br>", $line->getLength(new Haversine()));
        }
        //Devuelve la lista de puntos
        printf("<h6>Detalle en Grados, Minutos y Segundos de los %d puntos del polígono:\n</h6>", $polygon->getNumberOfPoints());

        foreach ($polygon->getPoints() as $point) {
            echo $point->format(new DMS()). "<br>" . PHP_EOL;
        }

        ?>
        
          <a href="../poligono.php" class="btn btn-secondary mt-3 text-center">Ingrese otro pol&iacute;gono</a>
        <br/>  
        <?php
    } else {
        echo "<h2>Error, al cargar las coordenadas</h2>";
    }

}
else{
    echo "<h2>No se cargo ningun dato</h2>";
}
    ?>
</div>
<?php

include_once $dir . '../estructura/footer.php';
?>