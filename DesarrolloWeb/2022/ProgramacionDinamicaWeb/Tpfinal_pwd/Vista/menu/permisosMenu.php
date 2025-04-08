<?php
$dir="../";
$titulo = "Listar Men&uacute;";
include_once $dir."../Vista/estructura/cabeceraSegura.php";
include_once '../../configuracion.php';

?>

<div class="container border border-secondary principal mt-3 pt-3">
  
    <div class="row text-muted m-0">
    <h6 class="text-left text-secondary">Listado de Men&uacute; y roles</h6>
    <?php 
        
        
        $objAbmmenu = new ABMmenu();

        $listaMenu = $objAbmmenu->buscar(null);
        //print_r($listaMenu);
        if(count($listaMenu)>0){
            ?>
            <table class="table table-light table-striped text-center table-hover fs-6 table-bordered" cellspacing="0" width="100%">
                <thead>
                    <tr class="text-secondary fs-6">
                        <th scope="col">ID Men&uacute;</th>
                        <th scope="col">Nombre</th>
                        <!--<th scope="col">Contraseña</th>-->
                        <th scope="col">Descripción de URL</th>
                        <th scope="col">Hab/Deshabilitado</th>
                      
                        <th scope="col"></th>
                          <!--<th scope="col"></th>
                        -->                
                    </tr>
                </thead>
                <tbody>
                <?php
                    
                    foreach ($listaMenu as $objMenu) {                         
                        echo '<tr>
                        <th scope="row">'.$objMenu->getIdmenu().'</th>';
                        echo '
                        <td>'.$objMenu->getMenombre().'</td>';
                       /* echo '
                        <td>'.$objMenu->getuspass().'</td>';*/
                        echo '
                        <td>'.$objMenu->getMedescripcion().'</td>';
                        echo '
                        <td>'.$objMenu->getMedeshabilitado().'</td>';
                         if($objMenu->getMedeshabilitado()==null)
                        echo '<td><a href="asignarMenu.php?idmenu='.$objMenu->getIdmenu().'" class="btn btn-success">Dar rol</a></td>';
                        else
                        echo '<td></td>';
                        //echo '<td><a href="accion/eliminar_usuario.php?idusuario'.$objUsuario->getidusuario().'" class="btn btn-success">Deshabilitar</a></td>';
                       /*  echo '<td><a href="accionBuscarPersona.php?NroDni='.$objTabla->getNroDni().'" class="btn btn-primary"><i class="bi bi-pencil-square"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                        <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                        <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
                      </svg></i></a></td>';
                        //personaresult.php?accion=borrar&NroDni='.$objTabla->getNroDni().'
                        echo '<td><a href="ActualizarDatosPersona.php?accion=borrar&NroDni='.$objTabla->getNroDni().'" class="btn btn-warning"><i class="bi bi-trash-fill"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">
                        <path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>
                      </svg></i></a></td></tr>'; 
                      */  
                           echo'</tr>';
                  
                     }
                    //fin foreach
                    echo '    </tbody>
                    </table>';
                }
                else{

                    echo "<h3>No hay personas registradas </h3>";
                }
                
                ?>
            
        
</div>

</div>

<?php
include ("../../Vista/estructura/pie.php");
?>
