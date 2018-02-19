$("document").ready(function () {
    $("#notes").click(loadData);

    console.log("Click notes");
});

function loadData() {
    console.log("Load");
    $('#homeInformation').remove();
    //$('#notes').prop("disabled", false);

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
    $("header").hide();
    $("body").css({"background-image":"url(resources/images/Paris.jpg",
                  "background-repeat":"no-repeat",
                  "background-size":"cover"});

    var noteList = $("<form class=\"mt-5\" id=\"listNotes\" method=\"GET\" action=\"editTextServlet\">" +
                        "<button class=\"btn m-2 btn-primary\" id=\"add\">Add new</button>" +
                     "</form>");
    data.forEach(function (item, i, data) {
        noteList.append(
                        "<div class=\"divNotes mb-2\">" +
                            "<input type=\"hidden\" class=\"idNote\" name=\"idNote\" value=\"" + item.noteId + "\"/>" +
                                "<h4 class=\"col-sm-4 timeNote\">" + item.time + "</h4>" +
                            "<div class=\"textNote\" name=\"textNote\">" + item.text + "</div>" +
                        "</div>"
                     );
        console.log("Fill date and text of note");
    });

    info.append(noteList);
//#FFE4C4
    $("#insert_div").html(info);

    $(".divNotes").css({"background":"#B0E0E6",
                       "border-color":"#4682B4",
                       "border-style":"solid",
                       "border-radius":"8px",
                       "padding":"5px"});

//    $("#notes").css({
//                       "pointer-events":"none", /* делаем ссылку некликабельной */
//                       "cursor":"default",  /* устанавливаем курсор в виде стрелки */
//                       "color":"#999" /* цвет текста для нективной ссылки */
//                      })
    //$("#delete").css('background', '#008000');
    $(".textNote").dblclick(function() {
        $(this).replaceWith(
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
    });

    $(".divNotes").click(getNote);
    function getNote(){
        console.log("Click One Note");
       $.ajax(
       {
           url: "getOneNoteServlet",
           success: oneNote,
           type: "POST",
           dataType: "text",
           data: {"id": $(".idNote").val()}
       });
    }
    function oneNote(data, status, jqxhr){
        console.log("oneNote function");
       $("#div").empty();
       data = JSON.parse(data);
       var info = $("#div");
       var noteList = $("<form class=\"mt-5\" id=\"listNotes\" method=\"GET\" action=\"editTextServlet\"></form>");
       noteList.append(
           "<div class=\"divNotes mb-2\">" +
               "<input type=\"hidden\" class=\"idNote\" name=\"idNote\" value=\"" + data.noteId + "\"/>" +
                   "<h4 class=\"col-sm-4 timeNote\">" + data.time + "</h4>" +
               "<div class=\"textNote\" name=\"textNote\">" + data.text + "</div>" +
           "</div>");
       console.log("Fill date and text of note");
       info.append(noteList);
       $("#insert_div").html(info);
    }
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