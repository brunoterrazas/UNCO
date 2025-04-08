<?php 
$dir="../";
$titulo =" Asignar menuRol ";
include_once $dir."../Vista/estructura/cabeceraSegura.php";
include_once '../../configuracion.php';
$objAbmMenu = new AbmMenu();
$datos =data_submitted();
$obj = null;
//print_r ($datos);
//echo $datos['idusuario'];
$msj="";
if (isset($datos['idmenu'])){
    $listaMenu = $objAbmMenu->buscar($datos);
    //print_r($listaMenu);
    if (count($listaMenu)==1){
        $obj= $listaMenu[0];

        //print_r($obj);
    }
}else{
    $msj="No se envío ningún menu";

    echo("<script>location.href = 'permisosMenu.php';</script>");
}


?>
<script type="text/javascript" src="../js/menu/asignarMenu.js">
  </script>
 <div class="card mb-3">
 <div class="row g-0 d-flex align-items-center">
    <div class="col-lg-6">
    <div class="card-body py-5 px-md-5">

       
        <form class="needs-validation" id="form1" name="form1" method="post" action="accionEditarUsuario.php">
            <div class="form-group mb-4">
                <h5>Asignar permiso men&uacute;</h5>
                <?php echo $msj;?>
                <input type="text" class="form-control" id="idmenu" name="idmenu" placeholder="" value="<?php echo $obj->getIdmenu()?>" readonly required hidden>
                <label for="menombre">Nombre de enlace</label>
                <input type="text" class="form-control" id="menombre" name="menombre" placeholder="" value="<?php echo $obj->getMenombre()?>" readonly required>
            </div>
            <div class="form-group mb-4">
                <label for="medescripcion">Descripci&oacute;n</label>
                <input type="text" class="form-control" id="medescripcion" name="medescripcion" aria-describedby="emailHelp" placeholder="" value="<?php echo $obj->getMedescripcion()?>" readonly required>
                <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
            </div>


            <?php
            $objr = new ABMRol();
            $listaRol = $objr->buscar(null);
            ?>
            


                    <div class="row float-right">
                        <div class="col-md-12 float-right">
                    <?php 
                    if( count($listaRol)>0){
                        foreach ($listaRol as $obj) {
                            ?>
                            <a class="btn btn-success" role="button" href="javascript:void(0)" onclick="darRol(<?php echo $obj->getidrol();?>,<?php echo $datos['idmenu'];?>)">Dar Rol <?php echo $obj->getrodescripcion();?></a>
                        <?php
                        }
                    }
                    ?>
                            
                        </div>
                    </div>

            <div id="listaroles"class="form-group mb-4">
                
                
            </div>
           
            <!--
            <button type="submit" class="btn btn-primary mb-4">Modificar datos</button>-->

            
        </form>
      
    </div>
    </div>
 </div>
 </div>
 <?php
include ("../../Vista/estructura/pie.php");
?>
</div>