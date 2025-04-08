<div class="row">
    <div class="col-md-12 col-lg-8">
        <div class="items">
            <?php
            include_once "../../../configuracion.php";
            $datos = data_submitted();
            $objCntrlCI = new ABMcompraitem();
            $suma = 0;
            $objSesion = new Session();
            $idusuario = $objSesion->getUsuario()->getIdusuario();
            $param["idusuario"] = $idusuario;
            $param["idcompraestadotipo"] = 0;
            $param["cefechafin"] = "null";
            $objCntrlCE = new ABMcompraestado();
            //verificamos si hay una compra con estado en confección
            $objEstado = $objCntrlCE->verificarEstado($param);
            $idcompra = -1;
            $idcompraestado = -1;
            $items = [];
            if ($objEstado != null) {

                $idcompra = $objEstado->getObjCompra()->getIdcompra();
                $datos["idcompra"] = $idcompra;
                $idcompraestado = $objEstado->getIdcompraestado();
                $items = $objCntrlCI->buscar($datos);
            }

            if (count($items) > 0) {

                foreach ($items as $item) {
            ?>

                    <div class="product">
                        <div class="row">
                            <div class="col-md-3 d-flex" style="height:140px;">
                                <img src="<?php echo $item->getObjProducto()->getUrlimagen(); ?>" class="img-fluid mx-auto d-flex image">
                            </div>
                            <div class="col-md-8">
                                <div class="info">
                                    <div class="row">
                                        <div class="col-md-5 product-name">
                                            <div class="product-name">
                                                <a href="#"><?php echo $item->getObjProducto()->getProdetalle(); ?></a>
                                                <div class="product-info">
                                                    <div>Marca: <span class="value"><?php echo $item->getObjProducto()->getPronombre(); ?></span></div>

                                                    <div>Disponibles: <span class="value"><?php echo $item->getObjProducto()->getProcantstock() ?></span></div>

                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-4 d-flex align-items-start">

                                       
                                            <input type="tel"pattern="^[0-9_.-]*$" style="min-width:30px;" value="<?php echo $item->getCicantidad(); ?>" class="cantidad form-control quantity-input text-center" onchange="cambiarCantidad(<?php echo  $item->getIdcompraitem(); ?>,this.value,3);" required>
                                        
                                        </div>
                                        <div class="col-md-2 text-success fw-bold">
                                            <span><?php echo $item->getObjProducto()->getPrecio(); ?>$</span>
                                        </div>
                                        <div class="col-md-1">
                                            <button class="btn btn-danger" onclick="eliminarItem(<?php echo  $item->getObjProducto()->getIdproducto(); ?>,<?php echo  $item->getIdcompraitem(); ?>,<?php echo $item->getCicantidad(); ?>)"><i class="bi bi-trash3-fill"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3-fill" viewBox="0 0 16 16">
                                                        <path d="M11 1.5v1h3.5a.5.5 0 0 1 0 1h-.538l-.853 10.66A2 2 0 0 1 11.115 16h-6.23a2 2 0 0 1-1.994-1.84L2.038 3.5H1.5a.5.5 0 0 1 0-1H5v-1A1.5 1.5 0 0 1 6.5 0h3A1.5 1.5 0 0 1 11 1.5Zm-5 0v1h4v-1a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5ZM4.5 5.029l.5 8.5a.5.5 0 1 0 .998-.06l-.5-8.5a.5.5 0 1 0-.998.06Zm6.53-.528a.5.5 0 0 0-.528.47l-.5 8.5a.5.5 0 0 0 .998.058l.5-8.5a.5.5 0 0 0-.47-.528ZM8 4.5a.5.5 0 0 0-.5.5v8.5a.5.5 0 0 0 1 0V5a.5.5 0 0 0-.5-.5Z" />
                                                    </svg></i></button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
            <?php
                    $suma = $suma + $item->getObjProducto()->getPrecio() * $item->getCicantidad();
                }
            } ?>
            <div class="summary">
                <h2 class="text-start fs-4" class="">Resumen</h2>
                <!--<label>ID Compra:</label>-->
                <h3 class="text-start">ID Compra:&nbsp;<?php echo $idcompra; ?></h3>
                <h3 class="text-start">ID Estado compra:&nbsp;<?php echo $idcompraestado; ?></h3>
                <div class="summary-item">
                    <p class="text-start fs-4">Total: <span class="text-start text-success fs-4"><?php echo $suma; ?>$</span></p>
                </div>


                <button type="button" onclick="comprar('La compra se realizo correctamente!',1)" class="btn btn-primary btn-lg btn-block">Comprar</button>
            
            </div>
        </div>
    </div>



    <script>
 $(document).ready(function () {    
    
    $('.cantidad').keypress(function (e) {    

        var charCode = (e.which) ? e.which : event.keyCode    

        if (String.fromCharCode(charCode).match(/[^0-9]/g))    

            return false;                        

    });    

});   

        function cambiarCantidad(idcomprai, cantNueva, opcion) {
            var idcompraitem = parseInt(idcomprai);
            var cant = parseInt(cantNueva);
            var opc = parseInt(opcion);
            if (cantNueva != "") {
                $.post('accion/cambiar_cantidad.php?idcompraitem=' + idcompraitem + '&cantNueva=' + cant + '&opc=' + opc,
                    function(result) {
                   

                        if (result == 1) {
                           
                            cargarCarrito();


                        } else {

                            cargarCarrito();
                          
                        }
                    }, 'json');

              

            } else {
                cargarCarrito();

            }
        }
     
    </script>