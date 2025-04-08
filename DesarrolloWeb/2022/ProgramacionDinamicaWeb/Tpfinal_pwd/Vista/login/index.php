<?php
$dir = "";
$titulo = ".: Iniciar sesión :.";

include_once $dir . '../estructura/cabecera.php';
$datos = data_submitted();



?>
<script type="text/javascript" src="../js/login/index.js">
</script>
<br>
<div class="container border border-secondary principal mt-3 pt-3">
  <div class="d-flex justify-content-center align-items-center">
    <div class="container pt-4">

      <div class="row d-flex justify-content-center">

        <div class="col-12 col-md-8 col-lg-6">
          <div class="card bg-white">
            <div class="card-body p-5">
              <form id="ff" class="mb-3 mt-md-4 needs-validation" novalidate>

                <h5 class="fw-bold mb-2 text-uppercase text-center">Iniciar sesi&oacute;n</h5>

                <div class="mb-3">
                  <label for="usnombre" class="form-label ">Nombre</label>
                  <input type="text" class="form-control" id="usnombre" name="usnombre">
                </div>
                <!--
                  <div class="mb-3">
                    <label for="uspass" class="form-label ">Email</label>
                    <input type="email" class="form-control" id="usmail"name="usmail" >
                  </div>-->
                <div class="mb-3">
                  <label for="password" class="form-label ">Password</label>
                  <input type="hidden" class="form-control" id="uspass" name="uspass">
                  <input type="hidden" class="form-control" id="usdeshabilitado" name="usdeshabilitado" value="null">
                  <input type="password" class="form-control" id="password" name="password" placeholder="*******">
                </div>
                <div class="d-grid">
                  <button class="btn btn-outline-dark" type="button" onclick="iniciarSesion()">Enviar</button>
                  <?php
                  if (isset($datos) && isset($datos['msg']) && $datos['msg'] != null) {
                  ?>
                    <div class="alert alert-secondary mt-2" role="alert"> <?php

                     echo $datos['msg']; ?>

                    </div>
                  <?php } ?>
                </div>

              </form>
              <div>
                <p class="mb-0  text-center"><a href="../usuario/registrarseB.php" class="text-primary fw-bold">Registrate</a></p>
                <a class="btn btn-secondary" href="../home/index.php">Volver</a>
              </div>

            </div>
          </div>
        </div>
      </div>
    </div>

  </div>



</div>
</div>
</div>

<script src="../js/validacionFormulario.js"></script>
<?php
include_once '../estructura/pie.php';
?>