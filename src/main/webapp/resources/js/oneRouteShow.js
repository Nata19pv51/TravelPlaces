function oneRouteShow(data, status, jqxhr) {
    console.log(data);
    data = JSON.parse(data);
    $("#divNotes").html("");
    //var routHiddenID = 0;

    $("header").hide();
    var noteList = $("<div class=\"mt-5\" id=\"listNotes\">" +
        "<button class=\"btn m-2 btn-primary\" id=\"addNote\">Add note</button>" + "</div>");
    if (data['routID']) {
        noteList.append("<input id=\"routHiddenID\" type=\"hidden\" class=\"idNote\" name=\"idRoute\" value=\"" + data['routID'] + "\"/>");
        $("#divNotes").append("<p>Nothing to show</p>");
        $("#divNotes").append(noteList);
        //routHiddenID = $("#routHiddenID").val();
    } else {
        noteList.append("<input id=\"routHiddenID\" type=\"hidden\" class=\"idNote\" name=\"idRoute\" value=\"" + data[0].routID + "\"/>");
        $("#divNotes").append(noteList);
        //routHiddenID = $("#routHiddenID").val();
        var myTrip = new Array();
        var placeName = new Array();
        data.forEach(function (item, i, data) {
            var time = item.time;
            var date = new Date(time);
            var month = date.getMonth() + 1;
            date = date.getDate() + '.' + month + '.' + date.getFullYear() +
                '  ' + date.getHours() + ':' + date.getMinutes() + ':' + date.getSeconds();

            var noteBox = $("<div class=\'noteBox mb-2\'> </div>");
            noteBox.append($("<input type=\"hidden\" class=\"idNote\" name=\"idNote\" value=\"" + item.noteId + "\"/>"))
            noteBox.append($("<div class=\"text-muted text-small text-left timeNote\"><p>" + date + "</p></div>"))
            noteBox.append($("<div class=\"textNote text-left\" name=\"textNote\">" + item.text + "</div>"))
            var formBox = $("<form action=\"openOneNoteServlet\" method=\"get\"></form>")
            formBox.append(noteBox)
            noteList.append(formBox);
            console.log("Fill date and text of note");
            //добавляем широту и высоту координаты в массив:
            myTrip.push({ lat: item.lat, lng: item.lng });
            placeName.push(item.text);
        });

        //рисуем карту с маркерами путя:
        myMap(myTrip, placeName);

        $(".noteBox").css({
            "background": "#B0E0E6",
            "border-color": "#4682B4",
            "border-style": "solid",
            "border-radius": "8px",
            "padding": "5px"
        });
        $(".noteBox").click(function () {
            $(this).parent().submit()
        })
    }

    $("#addNote").click(addNoteClick);
    
    // $("#addNote").click(
    //     function(){
    //         $.ajax("sendIdRouteServlet",
    //             {
    //                 success: addNoteClick,
    //                 type: "POST",
    //                 dataType: "text",
    //                 data: { "id": routHiddenID.value }
    //             })
    //     });
    
    
    // $("#cancelNote").click(
    //     function () {
    //         console.log($(this).children("input").val())

    //         $.ajax("showOneRouteServlet",
    //             {
    //                 success: oneRouteShow,
    //                 type: "POST",
    //                 dataType: "text",
    //                 data: { "id": $("#routHiddenID").val() }
    //             })

    //         // $(this).parent().submit();
    //         // oneRouteShow();
    //     }
    // )

    function myMap(myTrip, placeName) {
        var mapCanvas = document.getElementById("map_canvas");
        var mapOptions = { center: myTrip[0], zoom: 4 };
        var map = new google.maps.Map(mapCanvas, mapOptions);
        // var marker1 = new google.maps.Marker({
        //     position: {
        //         lat: myTrip[0].lat,
        //         lng: myTrip[0].lng
        //     },
        //     title: placeName[0],
        //     map: map
        // });
        // var marker2 = new google.maps.Marker({
        //     position: {
        //         lat: myTrip[myTrip.length - 1].lat,
        //         lng: myTrip[myTrip.length - 1].lng
        //     },
        //     title: placeName[placeName.length - 1],
        //     map: map
        // });

        var markers = new Array();
        $.each(myTrip, function(index,value) {
            markers.push(new google.maps.Marker({
                position: {
                    lat: myTrip[index].lat,
                    lng: myTrip[index].lng
                },
                title: placeName[index],
                map: map
            }));
        });
            

        var flightPath = new google.maps.Polyline({
            path: myTrip,
            strokeColor: "#0000FF",
            strokeOpacity: 0.8,
            strokeWeight: 2
        });
        flightPath.setMap(map);
    }


}


//  function showOneNote(data, status, jqxhr) {
//     data = JSON.parse(data);
//     var route = $(".divRoutes");
//     var time = data.time;
//     var date = new Date(time);
//     var month = date.getMonth()+1;
//     date = date.getDate() + '.' + month + '.' + date.getFullYear() +
//             '  ' + date.getHours() + ':' + date.getMinutes() + ':' + date.getSeconds();

//     route.append("<a href=\"servletInNotes\" id=\"notes\" class=\"btn btn-success btn-sm m-2\">Return to the notes list</a>");
//     route.append("<a href=\"deleteNoteServlet\" id=\"deleteNote\" class=\"btn btn-success btn-sm m-2\">Delete note</a>");
//     route.append("<input type=\"hidden\" id=\"idNote\" name=\"idNote\" value=\"" + data.noteId + "\"/>");
//     route.append("<div class=\"text-muted text-small text-left col-sm-4 timeNote\"><p>" + date + "</p></div>");
//     route.append("<div class=\"textNote text-left\" name=\"textNote\">" + data.text + "</div>");
//     route.append("<div id=\"cordinateNote\" name=\"cordinateNote\">" + data.coordination + "</div>");
//     //var imgBox = $("<div class=\"container row\" style=\"background: white\" id=\"images_box\"></div");
//     //note.append(imgBox);

//     //инициализировать плагин fancybox для элементов <a>, имеющих класс
//     //$("a.fancyimage").fancybox();

//     $.ajax("photosOfOneNoteServlet",
//         {
//             success: showPhotos,
//             type: "GET",
//             dataType: "text",
//             data: { "id": $("#idNote").val() }
//         })
//     $(".textNote").dblclick(editText);
//     //$("#returnNotes").click();
//     $("#deleteNote").click();   
// }

