
<?php
$titulo = ".: Home :.";
$dir = "";
include($dir . "../estructura/cabeceraSegura.php");
if (isset($_GET["tipo"])) {
  $param["tipo"] = $_GET["tipo"];
} else {
  $param["tipo"] = "null";
}


?>
<link rel="stylesheet" type="text/css" href="../css/estiloproductos.css">

<script src="../js/home/paginaSegura.js"></script>
<input type="hidden" id=tipo value="<?php echo $param["tipo"];?>">

	



<div id="productos" class="row container d-flex flex-wrap justify-content-center">

  
  

</div>

  


<?php

include($dir . "../estructura/pie.php");
?>