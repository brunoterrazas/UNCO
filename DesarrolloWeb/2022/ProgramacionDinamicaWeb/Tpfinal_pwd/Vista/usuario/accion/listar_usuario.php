<?php 
include_once "../../../configuracion.php";
$objAbmUsuario = new ABMusuario();
$data = data_submitted();

        
        
$objAbmUsuario = new ABMUsuario();

$listaUsuario = $objAbmUsuario->buscar(null);
//print_r($listaUsuario);
if(count($listaUsuario)>0){
    ?>
    <table class="table table-light table-striped text-center table-hover table-bordered" cellspacing="0" width="100%">
        <thead>
            <tr class="text-secondary">
                <th scope="col">ID Usuario</th>
                <th scope="col">Nombre y Apellido</th>
                <!--<th scope="col">Contraseña</th>-->
                <th scope="col">Correo Electrónico</th>
                <th scope="col">Hab/Deshabilitado</th>
              
                <th scope="col"></th>
                  <!--<th scope="col"></th>
                -->                
            </tr>
        </thead>
        <tbody>
    <?php
            
            foreach ($listaUsuario as $objUsuario) {                         
                echo '<tr>
                    <th scope="row">'.$objUsuario->getidusuario().'</th>';
                echo '
                     <td>'.$objUsuario->getusnombre().'</td>';
               /* echo '
                <td>'.$objUsuario->getuspass().'</td>';*/
                echo '
                     <td>'.$objUsuario->getusmail().'</td>';
            
                echo '
                     <td>'.$objUsuario->getusdeshabilitado().'</td>';
                 if($objUsuario->getusdeshabilitado()==null){
                    echo '<td><a href="asignarRol.php?idusuario='.$objUsuario->getidusuario().'" class="btn btn-success">Dar rol</a> ';  
                    ?>
                    <a href="javascript:void(0)" class="btn btn-dark" role="button" onclick="desHabUsuario(<?php echo $objUsuario->getidusuario(); ?>)">Deshabilitar</a></td>
                    <?php
                 }else{
                    echo '<td></td>';
               // echo '<td><a href="accion/eliminar_usuario.php?idusuario'.$objUsuario->getidusuario().'" class="btn btn-dark">Deshabilitar</a></td>';                       
                    echo'</tr>';
                 }
             }                     
        //fin foreach
        echo '    </tbody>
    </table>';
}
else{
    echo "<h3>No hay usuarios registrados </h3>";
}                
?> 
   