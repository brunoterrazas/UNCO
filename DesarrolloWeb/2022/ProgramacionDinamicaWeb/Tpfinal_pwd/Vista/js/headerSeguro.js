		
  function cerrarSesion(){

        $.messager.confirm('Confirmar','Esta seguro de cerrar sesión?', function(r){
            if (r){
                $.post('../login/accion/cerrarSesion.php',
                   function(result){


                    if (result.respuesta){
                           
                        location.href = '../login/index.php?msg=Vuelva a visitarnos!';
                        
                    } else {
                        $.messager.show({    // show error message
                            title: 'Error',
                            msg: 'No pudo cerrar sesion'
                      });
                    }
                },'json');
            }
        });
   
}
