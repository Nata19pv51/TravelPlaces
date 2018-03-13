function initMap() {
    var map_option = {
        center: { lat: -34.397, lng: 150.644 },
        zoom: 10
    };
    var map = new google.maps.Map(document.getElementById('map_canvas'), map_option);
    var infoWindow = new google.maps.InfoWindow({ map: map });

    map.addListener('click', function (e) {
        placeMarkerAndPanTo(e.latLng, map);
    });

    map.addListener('zoom_changed', function (e) {
        // https://developers.google.com/maps/documentation/javascript/marker-clustering
        var markerCluster = new MarkerClusterer(map, markers,
            { imagePath: 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m' });
    });

    // Try HTML5 geolocation.
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            var pos = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };

            infoWindow.setPosition(pos);
            infoWindow.setContent('Location found.');
            map.setCenter(pos);
        }, function () {
            handleLocationError(true, infoWindow, map.getCenter());
        });
    } else {
        // Browser doesn't support Geolocation
        handleLocationError(false, infoWindow, map.getCenter());
    }
}

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
    infoWindow.setPosition(pos);
    infoWindow.setContent(browserHasGeolocation ?
        'Error: The Geolocation service failed.' :
        'Error: Your browser doesn\'t support geolocation.');
}

function placeMarkerAndPanTo(latLng, map) {
    var marker = new google.maps.Marker({
        position: latLng,
        title: $("#textNote").val(),
        map: map
    });

    // var infowindow = new google.maps.InfoWindow({
    //     content: "Hi"
    // });

    // google.maps.event.addListener(marker, 'click', function () {
    //     infowindow.open(map, marker);
    // });
    markers.push(marker)
}
