<?php
$dir="";
$titulo="Polilinea";
include_once '../estructura/header.php';

$arreAsoc[0]["latitud"]=-41.10;
$arreAsoc[0]["longitud"]=-71.30;
$arreAsoc[1]["latitud"]=-42.96;
$arreAsoc[1]["longitud"]=-71.20;
$arreAsoc[2]["latitud"]=-43.20;
$arreAsoc[2]["longitud"]=-65.30;
$arreAsoc[3]["latitud"]=-42.80;
$arreAsoc[3]["longitud"]=-65.00;
$arreAsoc[4]["latitud"]=-41.9;
$arreAsoc[4]["longitud"]=-65.3;
$arreAsoc[5]["latitud"]=-40.75;
$arreAsoc[5]["longitud"]=-65.2;
$arreAsoc[6]["latitud"]=-39;
$arreAsoc[6]["longitud"]=-65;
$arreAsoc[7]["latitud"]=-38;
$arreAsoc[7]["longitud"]=-63;
$arreAsoc[8]["latitud"]=-37;
$arreAsoc[8]["longitud"]=-64;
$arreAsoc[9]["latitud"]=-36;
$arreAsoc[9]["longitud"]=-66;
if(isset($_POST["cantCoordenadas"]))
{
    $cantCoordenadas=$_POST["cantCoordenadas"];
}
else{
$cantCoordenadas=3;
}
?>


<div class="container border border-secondary principal mt-3 pt-3">
    <h3 class="text-center">Polil&iacute;nea</h3>
    <p>La polil&iacute;nea es una lista de ubicaciones, m&iacute;nimo 3 pares de coordenadas. </p>
    <form method="post" class="row m-3 p-4 pt-3 bg-light fw-bold needs-validation" action="accion/accionPolilinea.php" novalidate>
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
        <a href="polilinea.php" class="btn-secondary mt-3 text-center">Ingresar otra cantidad de coordenadas</a>
    </form>

</div>
</div>
<script src="../js/validacionFormulario.js"></script>
<?php
include_once '../estructura/footer.php';
?>