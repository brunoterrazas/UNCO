    <?php
        $titulo = ".: Inicio :.";
        $dir = "";
        include($dir . "../estructura/cabecera.php");

        if (isset($_GET["tipo"])) {
            $param["tipo"] = $_GET["tipo"];
        } else {
            $param = null;
        }
    ?>

<link rel="stylesheet" type="text/css" href="../css/estiloproductos.css">
    <?php

        $objCtrlProducto = new ABMproducto();
        //pasamos este parametro para mostrar solo productos con stock
///$param["enstock"]=0; 
        $lista = $objCtrlProducto->buscar($param);
    ?>

    <div class="row container d-flex flex-wrap justify-content-center">

            <?php
            foreach ($lista as $objProducto) {
            ?>
                <div class="card pt-2" style="width:300px">
                    <h5 class="card-title text-center"><?php echo $objProducto->getPronombre(); ?></h5>
                    <div class="contenedorimagen">
                        <img class="card-img-top" src="<?php echo $objProducto->getUrlimagen(); ?>" alt="Card image">
                    </div>
                    <div class="card-body text-center">

                        <h6 class="card-text txt-secondary"><?php echo $objProducto->getProdetalle(); ?></h6>
                        <h4 class="card-text text-primary font-weight-bold"><?php echo $objProducto->getPrecio(); ?>$</h4>
                        <?php 
                        if($objProducto->getProcantstock()>0)
                        {
                        ?>
                        <h6 class="text-success font-weight-bold"><?php echo $objProducto->getProcantstock(); ?> disponibles</h6>
                        <?php }
                        else {?>
                        <h6 class="text-danger font-weight-bold">Sin stock</h6>
                        <?php 
                        }
                        ?>
                        
                        <a href="../login/index.php" class="btn btn-warning font-weight-bold">Agregar</a>
                    </div>
                </div>
            <?php } ?>

    </div>
             



<?php

    include($dir . "../estructura/pie.php");
?>