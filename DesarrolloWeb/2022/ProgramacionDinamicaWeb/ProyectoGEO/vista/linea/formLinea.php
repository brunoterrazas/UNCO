<?php
$dir="";
$titulo="Linea";
include_once '../estructura/header.php';
$arreAsoc[0]["latitud"]=-41.10;
$arreAsoc[0]["longitud"]=-71.30;
$arreAsoc[1]["latitud"]=-40.85;
$arreAsoc[1]["longitud"]=-65.15;
$cantCoordenadas=2;
?>


<div class="container border border-secondary principal mt-3 pt-3">
    <h3 class="text-center">L&iacute;nea</h3>
    <div class="col-md-12">
        <p>La l&iacute;nea consta de 2 puntos.</p>
       
    </div>
    
    <form method="post" class="row m-3 p-4 pt-3 bg-light fw-bold needs-validation" action="accion/accionLinea.php" novalidate>
    <div class="col-md-3">
        Ingrese 2 coordenadas. <br>Un mapa mostrar&aacute; la l&iacute;nea que las une. 
    </div>
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
    </form>

</div>
</div>
<script src="../js/validacionFormulario.js"></script>
<?php
include_once '../estructura/footer.php';
?>