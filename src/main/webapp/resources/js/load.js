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
    data = JSON.parse(data)
    var info = $("#div")
    info.append(
        "<div class=\"text-center mb-5\" id=\"searcharea\">" +
            "<div>" +
                "<label for=\"search\">Live Search</label>" +
                "<p>Enter the info about note</p>" +
                "<input type=\"search\" name=\"search\" id=\"search\" placeholder=\"Info\"/>" +
            "</div>" +
        "</div>" +
        "<div id=\"listNotes\">");

    data.forEach(function (item, i, data) {
        info.append("<div class=\"divNotes\">" +
                        "<h4>" + item.time + "</h4>" +
                        "<div class=\"textNote\">" + item.text + "</div>" +
                     "</div>");
        console.log("Fill date and text of note");
//        $(".textNote").dblclick(function() {
//           console.log("Hello");
//           $('div#textNote').each(function() {
//                $(this).replaceWith("<textarea id='textNote'>" + $(this).html() + "</textarea>")
//           });
//        });
    });
    info.append("</div>")
    $("#insert_div").html(info);

    $(".textNote").dblclick(function() {
              console.log("Hello");
             $(this).replaceWith("<textarea id='textNote'>" + $(this).html() + "</textarea>");
        });
}

function edit(){
    console.log("Hello");
    $('div#textNote').each(function() {
        $(this).replaceWith("<textarea id='textNote'>" + $(this).html() + "</textarea>");
    });
}
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