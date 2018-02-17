$("document").ready(function () {
    $("#notes").click(loadData);
    console.log("Click notes");
});

function loadData() {
    console.log("Load");
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

    var noteList = $("<form class=\"mt-5\" id=\"listNotes\" method=\"GET\" action=\"editTextServlet\"></form>");
    //("<div id=\"listNotes\"></div>");
        //"<form id=\"listNotes\" class=\"form-inline\" method=\"GET\" action=\"editTextServlet\">");

    data.forEach(function (item, i, data) {
        noteList.append(
                        "<div class=\"divNotes\">" +
                            "<input type=\"hidden\" name=\"idNote\" value=\"" + item.noteId + "\"/>" +
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
                //"<textarea class='textNote'>" + $(this).html() + "</textarea>" +
                "<div id=\"replaceText\">" +
                    "<input type=\"text\" class=\"textNote\" name=\"textNote\" value=\"" + $(this).html() + "\">" +
                        "<div class=\"input-group\">" +
                            "<span class=\"input-group-btn\">" +
                                "<button class=\"btn btn-info\" id=\"saveText\">Save</button>" +
                                "<button class=\"btn btn-info\">Cancel</button>" +
                            "</span>" +
                        "</div>" +
                "</div>");


        $("#saveText").click(newData);
                function newData() {
                   $('#saveText').prop("disabled", true);
                   $.ajax("replacedText",
                   {
                       success: newtext,
                       type: "GET",
                       dataType: "text"
                   });
                }
                   function newtext(data, status, jqxhr) {
                        data = JSON.parse(data);
                        $("#replaceText").replaceWith("<div class=\"textNote\" name=\"textNote\">" + data.text + "</div>")
                   }
//        var text = $(this).html();
//        $("#replaceText").replaceWith("<div class=\"textNote\" name=\"textNote\">" + text + "</div>")
    });

                          //        function(){
                          //            console.log("Click");
                          //            $("#replaceText").replaceWith(
                          //                "<div class=\"textNote\" name=\"textNote\">" + text + "</div>"
                          //            );
                          //            console.log("replace");
                          //        }




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