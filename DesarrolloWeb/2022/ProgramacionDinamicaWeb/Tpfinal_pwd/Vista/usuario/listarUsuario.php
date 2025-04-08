<?php
$dir="../";
$titulo = "Gestión Usuarios";
include_once $dir."../Vista/estructura/cabeceraSegura.php";
include_once '../../configuracion.php';

?>

<div class="container border border-secondary principal mt-3 pt-3">
   <h6 class="text-left text-secondary">Listado de Usuarios</h6>
    <div id="listarUsuario" class="row text-muted m-0">
   
     </div>    
 </div>

       
    <script type="text/javascript" src="../js/usuario/listarUsuario.js">
  </script>
<?php
include ("../../Vista/estructura/pie.php");
?>
