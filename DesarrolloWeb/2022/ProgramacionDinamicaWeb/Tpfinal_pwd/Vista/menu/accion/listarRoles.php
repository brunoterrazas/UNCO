<?php
include_once '../../../configuracion.php';
$objAbmMenu = new AbmMenu();
$datos = data_submitted();
                   
                   $listaTabla = $objAbmMenu->darRoles($datos);
                   
        
                ?>
                                    <div class="table-responsive">
                        <table class="table table-striped table-sm">
                            <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Acciones</th>
                            </tr>
                            </thead>
                            <tbody>
                    
                    <?php
                    if( count($listaTabla)>0){
                        foreach ($listaTabla as $objTabla) {
                            echo '<tr><td>'.$objTabla->getobjrol()->getidrol().'</td>';
                            echo '<td>'.$objTabla->getobjrol()->getrodescripcion().'</td>';
                            ?>

                            <td><a class="btn btn-danger" role="button" href="javascript:void(0)" onclick="eliminarRol(<?php echo $objTabla->getobjrol()->getidrol();?>,<?php echo $objTabla->getObjMenu()->getIdMenu();?>)">Quitar Rol </a></td>
                            


                        </tr>
                        <?php

                        
                        }
                    }

                    ?>
                            </tbody>
                        </table>
                        <a class="btn btn-secondary" role="button" href="permisosMenu.php" >Volver </a>
                    </div>
