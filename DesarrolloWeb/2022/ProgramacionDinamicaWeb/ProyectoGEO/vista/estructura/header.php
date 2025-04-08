<html>
<head>
  <meta charset="UTF-8">
  <title><?php echo $titulo;?></title>
  <script type="text/javascript" src="https://maps.google.com/maps/api/js?sensor=true"></script>
  <link rel="stylesheet" href="<?php echo $dir?>../css/bootstrap.css">
  <link rel="stylesheet" href="<?php echo $dir?>../css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="<?php echo $dir?>../css/estilos.css">
  <link rel="stylesheet" type="text/css" href="<?php echo $dir?>../css/estilo.css">
  <script src="<?php echo $dir?>../js/bootstrap.bundle.js"></script>
  <!--<script type="text/javascript" src="vista/js/mostrarMapa.js"></script>-->

</head>
<body>
  <header class="container-fluid" > 
    <div class="pt-5">
      <h3 class="text-secondary text-center">Librer&iacute;a PHPGEO</h3>
    </div>
    <div class="pt-5">
      <ul class="nav nav-tabs navbar-light bg-light">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="<?php echo $dir?>../home/index.php">Inicio</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">TP Librer&iacute;as</a>
            <ul class="dropdown-menu">
              <li>

                <a class="dropdown-item" href="<?php echo $dir?>../coordenada/formCoordenada.php"><i class="bi bi-geo-alt"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-geo-alt" viewBox="0 0 16 16">
  <path d="M12.166 8.94c-.524 1.062-1.234 2.12-1.96 3.07A31.493 31.493 0 0 1 8 14.58a31.481 31.481 0 0 1-2.206-2.57c-.726-.95-1.436-2.008-1.96-3.07C3.304 7.867 3 6.862 3 6a5 5 0 0 1 10 0c0 .862-.305 1.867-.834 2.94zM8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10z"/>
  <path d="M8 8a2 2 0 1 1 0-4 2 2 0 0 1 0 4zm0 1a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
</svg></i> Coordenada</a>
              </li>
             <!-- <li>
                <a class="dropdown-item" href="<?php //echo $dir?>cuaCoord.php">Mostrar 4 coordenadas</a>
              </li>-->
              <li>
                <a class="dropdown-item" href="<?php echo $dir?>../linea/formLinea.php"><i class="bi bi-dash-lg"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-dash-lg" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M2 8a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 0 1h-11A.5.5 0 0 1 2 8Z"/>
</svg></i> L&iacute;nea</a>
              </li>
            <!--  <li>
                <a class="dropdown-item" href="<?php echo $dir?>perimetro.php">Perimetro Poligono</a>
              </li>-->
              <li>
                <a class="dropdown-item" href="<?php echo $dir?>../polilinea/polilinea.php"><i class="bi bi-chevron-compact-down"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-compact-down" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M1.553 6.776a.5.5 0 0 1 .67-.223L8 9.44l5.776-2.888a.5.5 0 1 1 .448.894l-6 3a.5.5 0 0 1-.448 0l-6-3a.5.5 0 0 1-.223-.67z"/>
</svg></i> Polil&iacute;nea</a>
              </li>
              <li>
                <a class="dropdown-item" href="<?php echo $dir?>../poligono/poligono.php"><i class="bi bi-pentagon"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pentagon" viewBox="0 0 16 16">
  <path d="M7.685 1.545a.5.5 0 0 1 .63 0l6.263 5.088a.5.5 0 0 1 .161.539l-2.362 7.479a.5.5 0 0 1-.476.349H4.099a.5.5 0 0 1-.476-.35L1.26 7.173a.5.5 0 0 1 .161-.54l6.263-5.087Zm8.213 5.28a.5.5 0 0 0-.162-.54L8.316.257a.5.5 0 0 0-.631 0L.264 6.286a.5.5 0 0 0-.162.538l2.788 8.827a.5.5 0 0 0 .476.349h9.268a.5.5 0 0 0 .476-.35l2.788-8.826Z"/>
</svg></i> Pol&iacute;gono</a>
              </li>
            </ul>
          </li>
          <li class="nav-item">
        <a class="nav-link" target="_blank" href="<?php echo $dir?>../../PHPGEO y API google maps.pdf">Documentaci&oacute;n</a>
            </li>
            
      </ul>
    </div>
    </header>