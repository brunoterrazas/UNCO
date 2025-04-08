$(document).ready(function(){
  cargarRoles();
   });

   function cargarRoles()
   {
     $("#listaroles").load('accion/listarRoles.php?idmenu='+$("#idmenu").val());
  
   }


function darRol(idrol,idmenu) {
    var jqxhr = $.post('accion/dar_rol.php?idrol='+idrol+"&idmenu="+idmenu, function() {
        //alert( "success" );
      })
      .done(function(result) {
        var result = eval('(' + result + ')');
        if (!result.respuesta) {
          $.messager.alert({
            title: 'Error',
            msg: result.errorMsg
          });
        } else {
          $.messager.alert({
            title: 'Mensaje',
            msg: " se asignó nuevo rol"
          });
          //cargarCarrito();
          window.location.href = window.location.href;
        }
      })
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

  function eliminarRol(idrol,idmenu) {
    var jqxhr = $.post('accion/eliminar_rol.php?idrol='+idrol+"&idmenu="+idmenu, function() {
        //alert( "success" );
      })
      .done(function(result) {
        var result = eval('(' + result + ')');
        if (!result.respuesta) {
          $.messager.alert({
            title: 'Error',
            msg: result.errorMsg
          });
        } else {
          $.messager.alert({
            title: 'Mensaje',
            msg: "Se eliminó el rol"
          });
          
          window.location.href = window.location.href;
        }
      })
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


