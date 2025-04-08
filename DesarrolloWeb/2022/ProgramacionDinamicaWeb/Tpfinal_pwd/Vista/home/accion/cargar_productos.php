<?php 
/*echo "<br><br><br><br><br><br><br>";
echo "incluyo dentro del div productos";
*/
include_once "../../../configuracion.php";
$data = data_submitted();
$objSesion = new Session();

$idusuario=$objSesion->getUsuario()->getidusuario();


$objCtrlProducto = new ABMproducto();
$param=null;

//$data["tipo"]=null;
if(isset($data["tipo"])&&$data["tipo"]!="null")
{
     $param["tipo"]=$data["tipo"];
 
}
//pasamos este parametro para mostrar solo productos con stock
//$param["enstock"]=0; 
$lista = $objCtrlProducto->buscar($param);



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
            <a href="javascript:void(0)" class="btn btn-warning font-weight-bold" onclick="agregarItem(<?php echo  $objProducto->getIdproducto(); ?>,1)">Agregar</a>
            
        </div>
    </div>
<?php } ?>

