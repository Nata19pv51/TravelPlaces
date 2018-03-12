$("document").ready(function loadNote() {
    var info = $("#div");
       $("body").css({
        "background-image": "#FFF5EE",
        "background-repeat": "no-repeat",
        "background-size": "cover"
    });
    $.ajax("showOneNoteServlet",
        {
            success: showOneNote,
            type: "GET",
            dataType: "text",
            data: { "id": $(".idNote").val() }
        })
 });

function showOneNote(data, status, jqxhr) {
    data = JSON.parse(data);
    var note = $(".divNotes");
    var time = data.time;
    var date = new Date(time);
    var month = date.getMonth()+1;
    date = date.getDate() + '.' + month + '.' + date.getFullYear() +
            '  ' + date.getHours() + ':' + date.getMinutes() + ':' + date.getSeconds();

    note.append("<a href=\"servletInNotes\" id=\"notes\" class=\"btn btn-success btn-sm m-2\">Return to the notes list</a>");
    note.append("<a href=\"deleteNoteServlet\" id=\"deleteNote\" class=\"btn btn-success btn-sm m-2\">Delete note</a>");
    note.append("<input type=\"hidden\" id=\"idNote\" name=\"idNote\" value=\"" + data.noteId + "\"/>");
    note.append("<div class=\"text-muted text-small text-left col-sm-4 timeNote\"><p>" + date + "</p></div>");
    note.append("<div class=\"textNote text-left\" name=\"textNote\">" + data.text + "</div>");
    // note.append("<div id=\"cordinateNote\" name=\"LatNote\">" + data.lat + "</div>");
    // note.append("<div id=\"cordinateNote\" name=\"LngNote\">" + data.lng + "</div>");
    //var imgBox = $("<div class=\"container row\" style=\"background: white\" id=\"images_box\"></div");
    //note.append(imgBox);
    var lt = data.lat;
    var lg = data.lng;
    var txt = data.text;
    showMap(lt, lg, txt);
    //инициализировать плагин fancybox для элементов <a>, имеющих класс
    //$("a.fancyimage").fancybox();

    $.ajax("photosOfOneNoteServlet",
        {
            success: showPhotos,
            type: "GET",
            dataType: "text",
            data: { "id": $("#idNote").val() }
        })

    $(".textNote").dblclick(editText);
    //$("#returnNotes").click();
    $("#deleteNote").click();  
    // $("#map_canvas").css({
    //     "position": "absolute"
    // }) 
}
function showMap(lt, lg, txt) {
        var map = new google.maps.Map(document.getElementById('map_canvas'), {
          zoom: 10,
          center: {lat: lt, lng: lg}
        });
        var marker = new google.maps.Marker({
            position: {
                lat: lt,
                lng: lg
            },
            title: txt,
            map: map
        });
    //https://bitbucket.org/IdeasV/travelplaces/src/31e304b53c56274c247782045ef229d00c9df377/WebTravelPlaces/src/main/webapp/js/map.js?at=master&fileviewer=file-view-default
    // var myTrip = [stavanger, amsterdam, london];
    // var flightPath = new google.maps.Polyline({
    //     path: myTrip,
    //     strokeColor: "#0000FF",
    //     strokeOpacity: 0.8,
    //     strokeWeight: 2
    // });
      }
function createGrid() {
    $(".gallery").css("width","100%")
    var options = {
        srcNode: 'img',             // grid items
        margin: '15px',             // margin in pixel
        width: '240px',             // grid item width in pixel
        max_width: '',              // dynamic gird item width
        resizable: true,            // re-layout if window resize
        transition: 'all 0.5s ease' // support transition for CSS3
    };
    $('.grid').gridify(options);
}

function showPhotos(data){
    var gallery = $("#subGallery");
    console.log(data);
    data = JSON.parse(data);
    data.forEach(function (item, i, data) {
        gallery.append("<a data-fancybox=\"gallery\" href=\"" + item.url + "\"><img class=\"img-fluid\" src=\"" + item.url + "\" /></a>");
    });
    createGrid();
}

function editText() {
    $(".textNote").prop("disabled", true);
    var firstText = $(this).html();
    $(this).replaceWith(
        "<div id=\"replaceText\" class=\"container row\">" +
        "<input type=\"text\" class=\"textNote text-left col-md-6 m-2\" name=\"textNote\" value=\"" + $(this).html() + "\">" +
        "<div class=\"input-group col-md-6\">" +
        //"<span class=\"input-group-btn\">" +
        "<button class=\"btn btn-success btn-sm mr-1 col-sm-8\" id=\"saveText\">Save</button>" +
        "<button class=\"btn btn-success btn-sm mr-1 col-sm-8\" id=\"cancelSaveText\">Cancel</button>" +
        //"<button class=\"btn btn-info col-sm-offset-3\" id=\"cancelSaveText\">Cancel</button>" +
        //"</span>" +
        "</div>");
        // $("#saveText").css({"width": "30px", "height": "40px"}); 
        // $("#cancelSaveText").css({"width": "30px", "height": "40px"}); 
    $("#saveText").click(newText);
    function newText() {
        $('#saveText').prop("disabled", true);
        $.ajax("replacedText",
            {
                success: newtext,
                type: "GET",
                dataType: "text",
                data: { "id": $(".idNote").val(), "text": $(".textNote").val() }
            });
    }
    function newtext(data, status, jqxhr) {
        data = JSON.parse(data);
        $("#replaceText").replaceWith("<div class=\"textNote text-left\" name=\"textNote\">" + data.text + "</div>")
    }

    $("#cancelSaveText").click(cancelSave);
    function cancelSave() {
        $('#cancelSaveText').prop("disabled", true);
        $("#replaceText").replaceWith("<div class=\"textNote text-left\" name=\"textNote\">" + firstText + "</div>")
    }
}