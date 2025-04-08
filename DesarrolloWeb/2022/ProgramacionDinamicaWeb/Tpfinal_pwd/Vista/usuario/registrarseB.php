<?php
$titulo = ".: Registrarse :.";
$dir = "";
include($dir . "../estructura/cabecera.php");
?>

<script type="text/javascript" src="../js/usuario/registrarseB.js">
  </script>
  <div class="container border border-secondary principal mt-3 pt-3">
    <div class="d-flex justify-content-center align-items-center">
  <div class="container pt-4">
    <div class="row d-flex justify-content-center">
      <div class="col-12 col-md-8 col-lg-6">
        <div class="card bg-white">
          <div class="card-body p-5">
            <form name="ff" id="ff" class="mb-3 mt-md-4 needs-validation" novalidate>
              <h5 class="fw-bold mb-2 text-uppercase text-center">Registrarse</h5>
              <div class="mb-3">
                <label for="usnombre" class="form-label fw-bold">Nombre </label>
                <input type="text" class="form-control" id="usnombre" name="usnombre" placeholder="(min: 3 y max: 20  caracteres)" required>
              </div>
              <div class="mb-3">
                <label for="uspass" class="form-label fw-bold">Email</label>
                <input type="email" class="form-control" id="usmail" name="usmail" required>
              </div>
              <div class="mb-3">
                <label for="password" class="form-label fw-bold">Password </label>
                <input type="hidden" class="form-control" id="uspass" name="uspass" placeholder="">
                <input type="hidden" class="form-control" id="usdeshabilitado" name="usdeshabilitado" value="null">
                <input type="password" class="form-control" id="password" name="password" placeholder="(max: 8 caracteres)" required>
              </div>

              <div class="d-grid">
                <button class="btn btn-outline-dark" type="button" onclick="registrar();">Enviar</button>
              </div>
            </form>
            <div>
              <p class="mb-0  text-center"><a href="../login/index.php" class="text-primary fw-bold">Iniciar sesi&oacute;n</a></p>
            </div>

          </div>
        </div>
      </div>
    </div>
  </div>
</div>
  </div>
 
 <?php

include($dir . "../estructura/pie.php");
?>