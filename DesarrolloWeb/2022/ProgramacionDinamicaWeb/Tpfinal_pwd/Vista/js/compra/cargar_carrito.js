$(document).ready(function () {    
    
    $('.cantidad').keypress(function (e) {    

        var charCode = (e.which) ? e.which : event.keyCode    

        if (String.fromCharCode(charCode).match(/[^0-9]/g))    

            return false;                        

    });    

});   

        function cambiarCantidad(idcomprai, cantNueva, opcion) {
            var idcompraitem = parseInt(idcomprai);
            var cant = parseInt(cantNueva);
            var opc = parseInt(opcion);
            if (cantNueva != "") {
                $.post('accion/cambiar_cantidad.php?idcompraitem=' + idcompraitem + '&cantNueva=' + cant + '&opc=' + opc,
                    function(result) {
                   

                        if (result == 1) {
                           
                            cargarCarrito();


                        } else {

                            cargarCarrito();
                          
                        }
                    }, 'json');

              

            } else {
                cargarCarrito();

            }
        }
     