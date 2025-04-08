$(document).ready(function() {
    cargarCarrito();
   
 
  }

);

function cargarCarrito() {

  $("#contenido").load('accion/cargar_carrito.php');
}

function comprar(mensaje, idcompraestadotipo) {
  var jqxhr = $.post('accion/confirmar_compra.php?idcompraestadotipo=' + idcompraestadotipo , function() {
      //alert( "success" );
    })
    .done(function(result) {
      var result = eval('(' + result + ')');
      if (!result.respuesta) {
        $.messager.show({
          title: 'Error',
          msg: result.errorMsg
        });
      } else {
        
        
        $.messager.show({
          title: 'Mensaje',
          msg: mensaje 
        });
        cargarCarrito();
 
      }
    }, 'json')
    .fail(
      function() {

        $.messager.alert({
          title: 'Error',
          msg: "No se pudo ejecutar"
        });

      }
    )
    .always(function() {
      // alert( "finished" );
    });


}

function eliminarItem(idproducto, idcompraitem, cicantidad) {
  

  $.messager.confirm('Confirm', 'Seguro que desea eliminar el menu?', function(r) {
    if (r) {
      $.post('accion/eliminar_item_carrito.php?idproducto=' + idproducto + '&idcompraitem=' + idcompraitem + '&cicantidad=' + cicantidad,
        function(result) {
       

          if (result.respuesta) {
          
       cargarCarrito();
        
           
          } else {
            $.messager.show({ 
              title: 'Error',
              msg: result.errorMsg
            });
          }
        }, 'json');
    }
  });

}


 