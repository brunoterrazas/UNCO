<?php
 $dir="";
 $titulo="Coordenada";
 include_once $dir.'../estructura/header.php';
 $cantCoordenadas=1;
 $arreAsoc[0]["latitud"]=-40.85;
$arreAsoc[0]["longitud"]=-65.15;
 ?>
 <div class="container border border-secondary principal mt-3 pt-3">

    <h3 class="text-center">Coordenada</h3>
    <div class="col-md-12">
        <p>La coordenada es la representaci&oacute;n de una ubicaci&oacute;n geogr&aacute;fica. </p>
        <h6>- Latidud: </h6>desde el 0° del paralelo del Ecuador hasta los 90° NORTE o los -90° SUR<br>
        <h6>- Longitud: </h6>desde el 0° del meridiano de Greenwich (Londres) hasta los 180° ESTE o los -180° OESTE.

    </div>
    
    <form method="post" class="row m-4 pl-3 pt-3 bg-light fw-bold needs-validation" action="accion/formato.php" novalidate>
    <div class="col-md-2">Ingrese coordenadas en formato decimal (ej. 41.12345) para ver su representaci&oacute;n en otro formato y para visualizar la ubicaci&oacute;n en un mapa</div>
    <div class="col-md-2"></div>  
        
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
        <div class="col-12 pt-5 p-5">
            <button class="btn btn-success d-grid gap-2 col-2 mx-auto" type="submit">Enviar</button>
        </div>
    </form>
    <br><br>
 </div>

 <script src="../js/validacionFormulario.js"></script>
<?php
 include_once $dir.'../estructura/footer.php';
?>