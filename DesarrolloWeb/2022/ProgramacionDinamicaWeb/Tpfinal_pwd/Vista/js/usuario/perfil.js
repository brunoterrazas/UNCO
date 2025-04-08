function editar()
{
    $('#btnEditar').hide();
    $('#usmail').removeAttr('readonly'); 
    $('#password').removeAttr('readonly');
    $('#password').val('');
   // $('#btnEditar').addAttr('hidden');
    $('#btnEnviar').removeAttr('hidden');
}
function actualizar() {

  if(validarEmail()&&validarPassword())
  {
    var password = document.getElementById("password").value;
    ;
    var passhash = CryptoJS.MD5(password).toString();
   
    document.getElementById("uspass").value = passhash;
    document.getElementById("password").value = "";
    

    $('#ff').form('submit', {
     
      url: 'accion/edit_usuario.php',
      onSubmit: function() {
        return $(this).form('validate');
      },
      success: function(result) {
        var result = eval('(' + result + ')');

        if (!result.respuesta) {
          $.messager.show({
            title: 'Error',
            msg: result.errorMsg
          });

        } else {
          
          $.messager.alert({
            title: 'Mensaje',
            msg: "se actualizo correctamente"
          });
          window.location.href = window.location.href;
       
         
        }
      }
    });
  }else{
    $.messager.alert({
      title: "Mensaje de error",
      msg: "Ingrese los datos correctamente",
    });
  }
  }
  function validarEmail() {
    var exito;
    if (
      $("#usmail").val().indexOf("@", 0) == -1 ||
      $("#usmail").val().indexOf(".", 0) == -1
    ) {
      //alert('El correo electrónico introducido no es correcto.');
      exito = false;
      $("#usmail").removeClass("is-valid");
      $("#usmail").addClass("is-invalid");
    } else {exito = true;
      $("#usmail").removeClass("is-invalid");
      $("#usmail").addClass("is-valid");
    }
    return exito;
  }
 
  function validarPassword() {
    var res;
    //Almacenamos los valores
    var txt = $("#password").val();
  
    //Comprobamos la longitud de caracteres
    if (txt.length >= 1 && txt.length <= 8) {
      res = true;
      $("#password").removeClass("is-invalid");
      $("#password").addClass("is-valid");
    } else {
      //alert('Minimo 1 caracteres y Maximo 8 caracteres');
      res = false;
      $("#password").removeClass("is-valid");
      $("#password").addClass("is-invalid");
      $.messager.alert({
        title: "Contraseña incorrecta",
        msg: "Max: 8 caracteres",
      });
    }
    return res;
  }