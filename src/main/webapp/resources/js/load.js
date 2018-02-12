$("document").ready(function () {
    $("#notes").click(loadData);
});

function loadData() {
    $('#homeInformation').remove();
    $('#notes').prop("disabled", true);
    $.ajax("servletInNotes",
        {
            success: setNotesContent,
            type: "GET",
            dataType: "text"
        });
}

function setNotesContent(data, status, jqxhr) {
    console.log(data)
    data = JSON.parse(data)
    var info = $("#div")
    info.append(
        "<div class=\"text-center mb-5\" id=\"searcharea\">" +
            "<div>" +
                "<label for=\"search\">Live Search</label>" +
                "<p>Enter the info about note</p>" +
                "<input type=\"search\" name=\"search\" id=\"search\" placeholder=\"Info\"/>" +
            "</div>" +
        "</div>");

    var noteList = $("<div id=\"listNotes\"></div>");
        //"<form id=\"listNotes\" class=\"form-inline\" method=\"GET\" action=\"editTextServlet\">");

    data.forEach(function (item, i, data) {
        noteList.append(
                        "<div class=\"divNotes\">" +
                            "<p class=\"invisible id\" name=\"id\">" + item.noteId + "</p>" +
                            "<h4>" + item.time + "</h4>" +
                            "<div class=\"textNote\" name=\"textNote\">" + item.text + "</div>" +
                        "</div>"
                     );
        console.log("Fill date and text of note");
    });

    info.append(noteList);

    $("#insert_div").html(info);

    $(".textNote").dblclick(function() {
        $(this).replaceWith(
            "<form class=\"form-inline\" method=\"GET\" action=\"editTextServlet\">" +
                "<textarea class='textNote'>" + $(this).html() + "</textarea>" +
                    "<div class=\"input-group\">" +
                        "<span class=\"input-group-btn\">" +
                            "<button class=\"btn btn-info\" type=\"submit\">Save</button>" +
                            "<button class=\"btn btn-info\">Cancel</button>" +
                        "</span>" +
                    "</div>" +
        "</form>"
        );
    });
}
        //var textNote = $(".textNote");

        //$("body").off( "dblclick", "#insert_div").find( "#insert_div" );

//        i++;
//        if(i == 1){
//           // $("#insert_div").unbind();
//
//            $("body").off( "dblclick", "#insert_div").find( "#insert_div" );
//
//            console.log("world!");
//            //$("#insert_div").on("dblclick", "td:not(.disabled)", false);
////            $(".textNote").bind('dblclick',function(){
////                console.log("world!");
////                return false;
////            });
//        }
        //

    //onClick="this.disabled='true'";



//        info.append(
////            "<li>" +
//            "<div id=\"edit\">" +
//                "<h4>" + item.time + "<h4>" +
//                "<div id=\"textNote\">" + item.text + "</div>" +
//            "</div>")});
//            "<p> USER ID: " + item.userId + "</p>" +
//            "<p>Date of creation: " + item.time + "</p>" +
//            "<p>Coord : " + item.coordination + "</p>" +
//            "<p>Text : " + item.text + "</p>")




//function edit() {
//    $.ajax("servletInNotes",
//        {
//            success: editText,
//            type: "GET",
//            dataType: "text"
//        });
//}
//
//function editText() {
//    data = JSON.parse(data)
//    data.forEach(function (item, i, data) {
//        $('#textNote').replaceWith("<textarea id=\"textNote2\">" + item[i].text + "</textarea>");
//    });
//}




// var note_div = $("div")
//        note_div.html = "<h4>" + item.time + "<h4>" +
//                        "<div id=\"textNote\">" + item.text + "</div>";
//
//        note_div.dblclick(function() {
//                        console.log("Hello");
//                //        $('div#textNote').each(function() {
//                //          $(this).replaceWith("<textarea id='textNote'>" + $(this).html() + "</textarea>")
//                //        });
//                      });