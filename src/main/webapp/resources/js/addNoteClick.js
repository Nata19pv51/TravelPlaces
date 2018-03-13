var markers = [];

function addNoteClick() {
    var urlArr;

    $("#addNote").replaceWith(
        "<div id=\"addDiv\">" +
        // "<input type=\"hidden\" class=\"idNote\" name=\"idNote\" value=\"" + data.routID + "\"/>" +
        "<input class=\"form-control\" type=\"text\" id=\"textNote\" name=\"textNote\" placeholder=\"Text\">" +
        //        "<input class=\"form-control\" type=\"text\" id=\"coordinate\" name=\"coordinate\" placeholder=\"coordinate\">" +
        // "<input class=\"form-control\" type=\"text\" id=\"coordinateLat\" name=\"coordinateLat\" placeholder=\"latitude\">" +
        // "<input class=\"form-control\" type=\"text\" id=\"coordinateLng\" name=\"coordinateLng\" placeholder=\"longitude\">" +
        "<p id=\"photo\">Photo: </p>" +
        "<div>" +
        "<h3>Upload</h3>" +
        "<form id=\"upload_form\" class=\"upload_box\" action=\"uploadPhotoServlet\" method=\"post\" enctype=\"multipart/form-data\">" +
        "<input id=\"input_box\" type=\"file\" name=\"file\" />" +
        "<br />" +
        "<br />" +
        "<input hidden=\"true\" id=\"submit_button\" type=\"submit\" value=\"Upload Image\" />" +
        "</form>" +
        "</div>" +
        "<div class=\"container row\" id=\"images_box\">" +
        // "<div id=\"hiddenInput\">" +
        // "</div>" +
        "</div>" +
        "<div id=\"map_canvas\"></div>" +
        "<button class=\"btn m-2 btn-primary addRoute\" id=\"addNew\">Add note</button>");

    //LOAD PHOTO:
    //***********************************************************************
    var options = {
        // http://jquery.malsup.com/form/#ajaxForm
        beforeSubmit: preSubmitCallback,  // pre-submit callback
        success: showResponse  // post-submit callback

        // other available options:
        //url:       url         // override for form's 'action' attribute
        //type:      type        // 'get' or 'post', override for form's 'method' attribute
        //dataType:  null        // 'xml', 'script', or 'json' (expected server response type)
        //clearForm: true        // clear all form fields after successful submit
        //resetForm: true        // reset the form after successful submit

        // $.ajax options can be used here too, for example:
        //timeout:   3000
    };

    // bind form using 'ajaxForm'
    $('#upload_form').ajaxForm(options);

    $("#input_box").change(selectImage);
    // pre-submit callback
    function preSubmitCallback(formData, jqForm, options) {
        $("#submit_button")[0].hidden = true;
        return true;
    }

    // post-submit callback
    function showResponse(responseText, statusText, xhr, $form) {
        // for normal html responses, the first argument to the success callback
        // is the XMLHttpRequest object's responseText property

        // if the ajaxForm method was passed an Options Object with the dataType
        // property set to 'xml' then the first argument to the success callback
        // is the XMLHttpRequest object's responseXML property

        // if the ajaxForm method was passed an Options Object with the dataType
        // property set to 'json' then the first argument to the success callback
        // is the json data object returned by the server
        $("#input_box").val("");
        var imagesBox = $("#images_box");
        var group = $("<div class=\"col-md-2\"></div>");
        imagesBox.append(group);
        group.append("<input hidden=\"true\" class=\"urlPhoto\" type=\"text\" value=\"" + responseText + "\" />");
        group.append("<img src=" + responseText + " class=\"img-thumbnail\" \>");
    }

    function selectImage() {
        $("#submit_button")[0].hidden = false;
    }
    //*******************************************************************************
    //Отобразить карту и взять координату
    initMap();

    $("#addNew").click(addNewNote);

    $("#map_canvas").css({
        "width": "100%",
        "height": "400px",
        "background-color": "grey"
    })
    // canvasMap();
    

}

function addNewNote() {
    var routID = -1
    var id = $("#routHiddenID")
    if (id.length != 0) {
        routID = id.val()
    }

    $.ajax({
        url: "newNoteServlet",
        success: displayNewNote,
        type: "GET",
        dataType: "text",
        //data: { "text": $("#textNote").val(), "coordinate": $("#coordinate").val(), "photo": $(".urlPhoto").val() }
        data: {
            "routID": routID,
            "text": $("#textNote").val(),
            //            "coordinate": $("#coordinate").val(),
            // "Lat": $("#coordinateLat").val(),
            // "Lng": $("#coordinateLng").val(),
            "Lat": markers[0].position.lat(),
            "Lng": markers[0].position.lng(),
            "photo": $(".urlPhoto").map(function () {
                return $(this).val();
            }).get().join(",")
        }
    });
}

function displayNewNote(data, status, jqxhr) {
    data = JSON.parse(data);
    var time = data.time;
    var date = new Date(time);
    var month = date.getMonth() + 1;
    date = date.getDate() + '.' + month + '.' + date.getFullYear() +
        '  ' + date.getHours() + ':' + date.getMinutes() + ':' + date.getSeconds();
    $("#addDiv").replaceWith(
        "<button class=\"btn m-2 btn-primary\" id=\"add\">Add new</button>" +
        "<div class=\"divNotes mb-2\">" +
        "<input type=\"hidden\" class=\"idNote\" name=\"idNote\" value=\"" + data.noteId + "\"/>" +
        "<div class=\"text-muted text-small text-left timeNote\"><p>" + date + "</p></div>" +
        "<div class=\"textNote text-left\" name=\"textNote\">" + data.text + "</div>" +
        "</div>");

    $(".divNotes").css({
        "background": "#B0E0E6",
        "border-color": "#4682B4",
        "border-style": "solid",
        "border-radius": "8px",
        "padding": " 5px"
    });
}

// function initMap() {
//     var map_option = {
//         center: { lat: -34.397, lng: 150.644 },
//         zoom: 10
//     };
//     var map = new google.maps.Map(document.getElementById('map_canvas'), map_option);
//     var infoWindow = new google.maps.InfoWindow({ map: map });

//     map.addListener('click', function (e) {
//         placeMarkerAndPanTo(e.latLng, map);
//     });

//     map.addListener('zoom_changed', function (e) {
//         // https://developers.google.com/maps/documentation/javascript/marker-clustering
//         var markerCluster = new MarkerClusterer(map, markers,
//             { imagePath: 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m' });
//     });

//     // Try HTML5 geolocation.
//     if (navigator.geolocation) {
//         navigator.geolocation.getCurrentPosition(function (position) {
//             var pos = {
//                 lat: position.coords.latitude,
//                 lng: position.coords.longitude
//             };

//             infoWindow.setPosition(pos);
//             infoWindow.setContent('Location found.');
//             map.setCenter(pos);
//         }, function () {
//             handleLocationError(true, infoWindow, map.getCenter());
//         });
//     } else {
//         // Browser doesn't support Geolocation
//         handleLocationError(false, infoWindow, map.getCenter());
//     }
// }

// function handleLocationError(browserHasGeolocation, infoWindow, pos) {
//     infoWindow.setPosition(pos);
//     infoWindow.setContent(browserHasGeolocation ?
//         'Error: The Geolocation service failed.' :
//         'Error: Your browser doesn\'t support geolocation.');
// }

// function placeMarkerAndPanTo(latLng, map) {
//     var marker = new google.maps.Marker({
//         position: latLng,
//         title: $("#textNote").val(),
//         map: map
//     });

//     // var infowindow = new google.maps.InfoWindow({
//     //     content: "Hi"
//     // });

//     // google.maps.event.addListener(marker, 'click', function () {
//     //     infowindow.open(map, marker);
//     // });
//     markers.push(marker)
// }