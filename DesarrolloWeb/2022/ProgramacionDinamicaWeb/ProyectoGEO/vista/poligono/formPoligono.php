<?php
$dir="";
$titulo="Poligono";
include_once '../estructura/header.php';
$arreCoord=[];
$lat1=-41.10;
$lon1=-71.30;
$lat2=-38.96;
$lon2=-68.10;
$lat3=-36.20;
$lon3=-70.50;
$lat4=-39.50;
$lon4=-71.40;
$arreAsoc[0]["latitud"]=-40.15;
$arreAsoc[0]["longitud"]=-71.90;
$arreAsoc[1]["latitud"]=-41.15;
$arreAsoc[1]["longitud"]=-71.90;
$arreAsoc[2]["latitud"]=-41.15;
$arreAsoc[2]["longitud"]=-71.15;
$arreAsoc[3]["latitud"]=-40.50;
$arreAsoc[3]["longitud"]=-70.70;
$arreAsoc[4]["latitud"]=-38.95;
$arreAsoc[4]["longitud"]=-68.02;
$arreAsoc[5]["latitud"]=-37.8;
$arreAsoc[5]["longitud"]=-68.22;
$arreAsoc[6]["latitud"]=-36.10;
$arreAsoc[6]["longitud"]=-70.55;
$arreAsoc[7]["latitud"]=-36.4;
$arreAsoc[7]["longitud"]=-71;
$arreAsoc[8]["latitud"]=-36.7;
$arreAsoc[8]["longitud"]=-71.1;
$arreAsoc[9]["latitud"]=-38.6;
$arreAsoc[9]["longitud"]=-70.90;
if(isset($_POST["cantCoordenadas"]))
{
    $cantCoordenadas=$_POST["cantCoordenadas"];
}
else{
$cantCoordenadas=4;
}
?>

<div class="container border border-secondary principal mt-3 pt-3">
    <h3 class="text-center">Pol&iacute;gono</h3>
    <p>El pol&iacute;gono es similar a una polil&iacute;nea, requiere de un m&iacute;nimo de 3 pares de coordenadas pero sus puntos inicial y final est&aacute;n conectados.</p>
    <form method="post" class="row m-3 p-4 pt-3 bg-light fw-bold needs-validation" action="accion/accionPoligono.php" novalidate>
<?php 

for($i=0;$i<$cantCoordenadas;$i++)
 {
  ?>
   <div class="col-md-3 border border-secondary  rounded pb-2">

  <label for="coordenadas[<?php echo $i; ?>][latitud]" class="form-label">Latitud</label>
  <input type="number" class="form-control" name="coordenadas[<?php echo $i; ?>][latitud]" min="-90" max="90" step="any" value="<?php echo $arreAsoc[$i]["latitud"];?>" required>
  <label for="coordenadas[<?php echo $i; ?>][longitud]" class="form-label">Longitud </label>
  <input type="number" class="form-control" name="coordenadas[<?php echo $i; ?>][longitud]" min="-180"  max="180" step="any" value="<?php echo $arreAsoc[$i]["longitud"];?>" required>
  </div>
<?php 
  }?>  

         <input id="accion" name="accion" value="nuevo" type="hidden">
        <div class="col-12 pt-5">
            <button class="btn btn-success d-grid gap-2 col-3 mx-auto" type="submit">Enviar</button>
        </div>
         <a href="poligono.php" class="btn-secondary mt-3 text-center">Ingresar otra cantidad de coordenadas</a>
    </form>

</div>
</div>
<script src="../js/validacionFormulario.js"></script>
<?php
include_once '../estructura/footer.php';
?>