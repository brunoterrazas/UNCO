<?php
$dir = "";
$titulo = "Mis compras";
include_once $dir . "../estructura/cabeceraSegura.php";
//include_once '../../configuracion.php';

?>
<script type="text/javascript" src="../js/compra/miscompras.js"></script>
<div class="container border border-secondary principal mt-3 pt-3">
  <h6 class="text-left text-secondary">Mis compras</h6>
  <div class="row text-muted m-0">
    <?php


    $objAbmcompra = new ABMcompra();
    $param["idusuario"] = $idusuario;
    $listacompra = $objAbmcompra->buscar($param);
    //print_r($listaUsuario);
    if (count($listacompra) > 0) {
    ?>
      <table class="table table-light table-striped text-center table-hover table-bordered" cellspacing="0" width="100%">
        <thead>
          <tr>
            <th scope="col">ID compra</th>
            <th scope="col">Fecha</th>
            <th scope="col">Estado</th>
            <th scope="col"></th>
            <!--<th scope="col"></th>
                        -->
          </tr>
        </thead>
        <tbody>
          <?php

          foreach ($listacompra as $objCompra) {
            $idcompra = $objCompra->getIdcompra();
            $param["idusuario"] = $idusuario;
            $param["idcompra"] = $idcompra;
            $param["cefechafin"] = "null";
            $param["idcompraet"] = 0;

            $objCntrlCE = new ABMcompraestado();
            $arreCE = $objCntrlCE->buscar($param);
            if (count($arreCE) == 1) {
              $estado = $arreCE[0]->getObjcompraestadotipo()->getCetdescripcion();
              $idcompraestado = $arreCE[0]->getIdcompraestado();

              echo '<tr>
                           <th scope="row">' . $idcompra . '</th>';
              echo '
                           <td>' . $objCompra->getCofecha() . '</td>';
              /* echo '
                           <td>'.$objUsuario->getuspass().'</td>';*/

              echo '
                           <td>' . $estado . '</td>';
              echo '<td>' ?><button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#exampleModal" onclick=" cargarCompra(<?php echo  $idcompra ?>,<?php echo  $idcompraestado ?>);">
                Ver compra
              </button><?php echo '</td>';


                        echo '</tr>';
                      }
                    }
                    //fin foreach
                    echo '    </tbody>
                    </table>';
                  } else {

                    echo "<h3>No tiene compras registradas </h3>";
                  }

                        ?>

        <!-- Button trigger modal -->


        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog modal-xl">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Compra </h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                <section class="shopping-cart dark">
                  <div class="container">

                    <div id="contenido" class="content">

                    </div>

                </section>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
              </div>
            </div>
          </div>
        </div>
  </div>
</div>


  <?php
  include("../../Vista/estructura/pie.php");
  ?>
