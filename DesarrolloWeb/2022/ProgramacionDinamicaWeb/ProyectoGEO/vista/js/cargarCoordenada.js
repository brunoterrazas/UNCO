  
        
          function inicio(latitud, longitud) {
            var miMapa = new google.maps.Map(document.getElementById('mapa'), {
              center: { lat: parseFloat(latitud), lng: parseFloat(longitud) },
              zoom: 6

            });
            var marker = new google.maps.Marker({position: {lat: parseFloat(latitud), lng: parseFloat(longitud)}, map: miMapa, title:"Mi punto"});
            var coordenada = new google.maps.Coordinate({
              path: verticeCoordenada,
              map: miMapa,
              strokeColor: 'rgb(255, 0, 0)',
              fillColor: 'rgb(255, 255, 0)',
              strokeWeight: 4,
            });
            var popup = new google.maps.InfoWindow();
        
         
        coordenada.addListener('click', function (e) {
        popup.setContent('Contenido');
        popup.setPosition(e.latLng);
        popup.open(miMapa);
      });
    
          }