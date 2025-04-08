
function registrar() {
  if (validarEmail() && validarNombre() && validarPassword()) {
    var password = document.getElementById("password").value;
    var passhash = CryptoJS.MD5(password).toString();

    document.getElementById("uspass").value = passhash;
    document.getElementById("password").value = "";
    $("#ff").form("submit", {
          url: "accion/alta_usuario.php",
      onSubmit: function () {
        return $(this).form("validate");
      },
      success: function (result) {
        var result = eval("(" + result + ")");

        if (!result.respuesta) {
          $.messager.alert({
            title: "Error",
            msg: result.errorMsg,
          });
        } else {
          //alert("se registro correctamente")
          $.messager.alert({
            title: "Bienvenido",
            msg: "se registro correctamente",
          });
          $("#usmail").removeClass("is-valid");
          $("#usnombre").removeClass("is-valid");
          $("#password").removeClass("is-valid");
          $("#usmail").removeClass("is-invalid");
          $("#usnombre").removeClass("is-invalid");
          $("#password").removeClass("is-invalid");
         
          document.getElementById("usmail").value = "";
          document.getElementById("usnombre").value = "";
          setTimeout(function(){
            window.location.href = "../login/index.php";
          }, 1200);
          
        }
      },
    });
  } else {
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
function validarNombre() {
  //Almacenamos los valores
  var txtnombre = $("#usnombre").val();

  //Comprobamos la longitud de caracteres
  if (txtnombre.length >= 3 && txtnombre.length <= 20) {
    res = true;
    $("#usnombre").removeClass("is-invalid");
    $("#usnombre").addClass("is-valid");
  } else {
    $("#usnombre").removeClass("is-valid");
    $("#usnombre").addClass("is-invalid");
    res = false;
  }
  return res;
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
