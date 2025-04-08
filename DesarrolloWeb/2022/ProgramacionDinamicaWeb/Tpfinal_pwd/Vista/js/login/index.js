function iniciarSesion() {
    var password = document.getElementById("password").value;
    ;
    var passhash = CryptoJS.MD5(password).toString();
   
    document.getElementById("uspass").value = passhash;
    document.getElementById("password").value = "";
    //document.getElementById("usmail").value ="";  

    $('#ff').form('submit', {
     
      url: 'accion/accionSesion.php',
      onSubmit: function() {
        return $(this).form('validate');
      },
      success: function(result) {
        var result = eval('(' + result + ')');
       var mensaje="Vuelva a ingresar los datos"
        if (!result.respuesta) {
          $.messager.show({
            title: 'Error',
            msg: mensaje
            });
          location.href = '../login/index.php?msg='+mensaje;
        } else {
          $.messager.show({
            title: '......Iniciando sesión......',
            msg: "Logueado correctamente"
          });
          location.href = '../home/paginaSegura.php';

          $('#ff').form('clear');
        
        }
      }
    });
  }

  function clearForm() {
    $('#ff').form('clear');
  }