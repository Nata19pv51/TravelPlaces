var markers = [];

function addNoteClick() {
    var urlArr;
    //var route = "undefined";
    //var idRoute;

    $("#addNote").replaceWith(
        "<div id=\"addDiv\">" +
        //"<input type=\"hidden\" id=\"idRoute\" name=\"idNote\" value=\"" + data.idRoute + "\"/>" +
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
        "<button class=\"btn m-2 btn-primary addRoute\" id=\"addNew\">Add note</button>" +
        "<button class=\"btn m-2 btn-primary cancelRoute\" id=\"cancelNew\">Cancel</button>");
    //idRoute=$("#idRoute");
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

    $("#cancelNew").click(function () {
        hiddenRoutTag = $("#routHiddenID")
        if (hiddenRoutTag.length == 0) {
            console.log("Not found rout")
            $.ajax("noteServlet",
                {
                    success: setNotesContent,
                    type: "GET",
                    dataType: "text"
                });
        } else {
            console.log(hiddenRoutTag.val())
            $.ajax("showOneRouteServlet",
                {
                    success: oneRouteShow,
                    type: "POST",
                    dataType: "text",
                    data: { "id": hiddenRoutTag.val() }
                })
        }
    });
}

function addNewNote() {
    var routID = -1
    var id = $("#routHiddenID")
    if (id.length != 0) {
        routID = id.val()
    }

    if(routID == -1){
        $.ajax({
            url: "newNoteServlet",
            //success: displayNewNote,
            success: setNotesContent,
            type: "GET",
            dataType: "text",
            //data: { "text": $("#textNote").val(), "coordinate": $("#coordinate").val(), "photo": $(".urlPhoto").val() }
            data: {
                "routID": routID,
                "text": $("#textNote").val(),
                "Lat": markers[0].position.lat(),
                "Lng": markers[0].position.lng(),
                "photo": $(".urlPhoto").map(function () {
                    return $(this).val();
                }).get().join(",")
            }
        });
    }
    else{
        $.ajax({
            url: "newNoteServlet",
            //success: displayNewNote,
            success: oneRouteShow,
            type: "GET",
            dataType: "text",
            //data: { "text": $("#textNote").val(), "coordinate": $("#coordinate").val(), "photo": $(".urlPhoto").val() }
            data: {
                "routID": routID,
                "text": $("#textNote").val(),
                "Lat": markers[0].position.lat(),
                "Lng": markers[0].position.lng(),
                "photo": $(".urlPhoto").map(function () {
                    return $(this).val();
                }).get().join(",")
            }
        });
    }
    
}

function displayNewNote(data, status, jqxhr) {
    data = JSON.parse(data);
    var time = data.time;
    var date = new Date(time);
    var month = date.getMonth() + 1;
    date = date.getDate() + '.' + month + '.' + date.getFullYear() +
        '  ' + date.getHours() + ':' + date.getMinutes() + ':' + date.getSeconds();
    $("#addDiv").replaceWith(
        "<button class=\"btn m-2 btn-primary\" id=\"add\">Add note</button>" +
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