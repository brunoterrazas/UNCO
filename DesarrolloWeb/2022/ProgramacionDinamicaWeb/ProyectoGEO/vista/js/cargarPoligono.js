
            function inicio(datos) {

                var verticesPoligono1 = [];
                for (i = 0; i < datos.length; i++) {
                    //Agregamos cada coordenada 
                    verticesPoligono1.push({lat: parseFloat(datos[i].latitud), lng: parseFloat(datos[i].longitud)
                    });
                }
          
                

                var miMapa = new google.maps.Map(document.getElementById('mapa'), {
                    center: { //Definimos un centro
                        lat: parseFloat(verticesPoligono1[1].lat),
                        lng: parseFloat(verticesPoligono1[1].lng)
                    },
                    zoom: 6
                });

                var poligono = new google.maps.Polygon({
                    path: verticesPoligono1,
                    map: miMapa,
                    strokeColor: 'rgb(255, 0, 0)',
                    fillColor: 'rgb(255, 255, 0)',
                    strokeWeight: 4,
                });
                var popup = new google.maps.InfoWindow();

                poligono.addListener('click', function(e) {
                    popup.setContent('<?php echo "Perimetro: ".$polygon->getPerimeter(new Vincenty())." metros"; ?>');
                    popup.setPosition(e.latLng);
                    popup.open(miMapa);
                });
               
            }
        