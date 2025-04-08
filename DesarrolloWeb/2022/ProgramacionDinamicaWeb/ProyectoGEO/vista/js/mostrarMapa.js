var watchId;  
var mapa = null;
var mapaMarcador = null;  

if (navigator.geolocation) {
        
        watchId = navigator.geolocation.watchPosition(mostrarPosicion(), mostrarErrores, opciones);   
       // mostrarPosicion(-38.9394214,-68.0582521);
} else {
        alert("Tu navegador no soporta la geolocalización, actualiza tu navegador.");
}

function mostrarPosicion(posicion) {
        var latitud = posicion.coords.latitude;
        var longitud = posicion.coords.longitude;
        var precision = posicion.coords.accuracy;

        var miPosicion = new google.maps.LatLng(latitud, longitud);
}
function mostrarCoordenadas(Lat, Lon){

    var latitud= parseFloat(Lat);
    var longitud=parseFloat(Lon);
    // alert ("latitud: "+ latitud + "Longitud: " + longitud)
        
    var miPosicion = new google.maps.LatLng(latitud, longitud);
    

    // Se comprueba si el mapa se ha cargado ya 
    if (mapa == null) {
        // Crea el mapa y lo pone en el elemento del DOM con ID mapa
        var configuracion = {center: miPosicion, zoom: 11, mapTypeId: google.maps.MapTypeId.HYBRID};
        mapa = new google.maps.Map(document.getElementById("mapa"), configuracion);

        // Crea el marcador en la posicion actual
        mapaMarcador = new google.maps.Marker({position: miPosicion, title:"Esta es tu posición"});
        mapaMarcador.setMap(mapa);

    } else {
        // Centra el mapa en la posicion actual
        mapa.panTo(miPosicion);
        // Pone el marcador para indicar la posicion
        mapaMarcador.setPosition(miPosicion);
    }
}   
        /*
        var fecha = new Date(posicion.timestamp);
        $('#posicion').empty();
        $('#posicion').append(" Latitud: " + latitud + " ");
        $('#posicion').append(" Longitud:" + longitud + " ");
        $('#posicion').append(" Precisión: " + precision + " metros "); 
        $('#posicion').append(" Fecha: " + fecha + " ");  
        }*/

function mostrarErrores(error) {
    switch (error.code) {
        case error.PERMISSION_DENIED:
            alert('Permiso denegado por el usuario'); 
            break;
        case error.POSITION_UNAVAILABLE:
            alert('Posición no disponible');
            break; 
        case error.TIMEOUT:
            alert('Tiempo de espera agotado');
            break;
        default:
            alert('Error de Geolocalización desconocido :' + error.code);
    }
}

var opciones = {
    enableHighAccuracy: true,
    timeout: 10000,
    maximumAge: 1000
};

function detener() {
    navigator.geolocation.clearWatch(watchId);
}
