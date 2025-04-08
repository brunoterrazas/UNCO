<?php
 $dir="";
 $titulo="Coordenada";
 include_once $dir.'../estructura/header.php';
 $maxCoordenadas=10;
 ?>
 <div class="container border border-secondary principal mt-3 pt-3">
 <div class="">
    <h3 class="text-center">Definir polil&iacute;nea</h3>
    <div class="col-md-12">
       

    </div>
    
    <form method="post" class="row m-4 pl-3 pt-3 bg-light fw-bold  needs-validation" action="formPolilinea.php" novalidate>
    <div class="col-md-2"></div>
    <div class="col-md-2"></div>  
        
    <div class="col-md-3 border border-secondary pb-2 gap-2">

          

            <label for="cantCoordenadas" class="form-label">Ingrese cantidad de coordenadas</label>
            <input type="number" class="form-control" id="cantCoordenadas" name="cantCoordenadas" min="3" max="<?php echo $maxCoordenadas; ?>" step='1' value="3" required>
            <div class="invalid-feedback">
                Ingrese valor min:3 y max:<?php  echo $maxCoordenadas;?>
            </div>
            <div class="valid-feedback">
                Correcto!
            </div>
        </div>
        <div class="col-12 pt-5 p-5">
            <button class="btn btn-success d-grid gap-2 col-2 mx-auto" type="submit">Enviar</button>
        </div>
       
    </form>
    <br><br>
 </div>
 </div>
 <script src="../js/validacionFormulario.js"></script>
<?php
 include_once $dir.'../estructura/footer.php';
?>