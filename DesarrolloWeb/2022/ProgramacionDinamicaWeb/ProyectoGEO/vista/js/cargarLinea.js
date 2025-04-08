
        function inicio(datos,latPuntoMedio,lonPuntoMedio) {
            verticesLinea = [];
            for (i = 0; i < datos.length; i++) {
              //Agregamos cada coordenada 
              verticesLinea.push({
                lat: parseFloat(datos[i].latitud),
                lng: parseFloat(datos[i].longitud)
              });
            }
            var miMapa = new google.maps.Map(document.getElementById('mapa'), {
              center: {
                lat: parseFloat(verticesLinea[1].lat),
                lng: parseFloat(verticesLinea[1].lng)
              },
              zoom: 6
            });
  
            var polilinea = new google.maps.Polyline({
              path: verticesLinea,
              map: miMapa,
              strokeColor: 'rgb(255, 0, 0)',
              fillColor: 'rgb(255, 255, 0)',
              strokeWeight: 4,
            });
            var marcadorPuntoMedio = new google.maps.Marker({
            position: {lat: parseFloat(latPuntoMedio), lng: parseFloat(lonPuntoMedio)},
            map: miMapa,
        title: 'Punto medio: lat'+parseFloat(latPuntoMedio)+' lng: '+ parseFloat(lonPuntoMedio)
          });
            var popup = new google.maps.InfoWindow();
  
            polilinea.addListener('click', function(e) {
              popup.setContent('Contenido');
              popup.setPosition(e.latLng);
              popup.open(miMapa);
            });
  
          }