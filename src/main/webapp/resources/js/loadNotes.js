$("document").ready(
//function () {
    //$("#notes").click(loadData);
    //$("#routes").click(loadRoutes);

    //console.log("Click notes");
    function loadData() {
       console.log("Load");
       //    $('#homeInformation').remove();
           //$('#notes').p
           $.ajax("noteServlet",
               {
                   success: setNotesContent,
                   type: "GET",
                   dataType: "text"
               });
    }
);
function setNotesContent(data, status, jqxhr) {
    console.log(data)
    data = JSON.parse(data)
    var info = $("#contener_div")
    $("header").hide();
    $("#contener_div").empty();
    $("body").css({
        "background-image": "url(resources/images/Paris.jpg",
        "background-repeat": "no-repeat",
        "background-size": "cover"
    });
    var noteList = $("<div class=\"mt-5\" id=\"listNotes\">" +
        "<button class=\"btn m-2 btn-primary\" id=\"addNote\">Add new</button>" +
        "</div>");
    data.forEach(function (item, i, data) {
        var time = item.time;
        var date = new Date(time);
        var month = date.getMonth()+1;
        date = date.getDate() + '.' + month + '.' + date.getFullYear() +
            '  ' + date.getHours() + ':' + date.getMinutes() + ':' + date.getSeconds();

        var noteBox = $("<div class=\'divNotes mb-2\'> </div>");
        noteBox.append($("<input type=\"hidden\" class=\"idNote\" name=\"idNote\" value=\"" + item.noteId + "\"/>"))
        noteBox.append($("<div class=\"text-muted text-small text-left timeNote\"><p>" + date + "</p></div>"))
        noteBox.append($("<div class=\"textNote text-left\" name=\"textNote\">" + item.text + "</div>"))
        var formBox = $("<form action=\"openOneNoteServlet\" method=\"get\"></form>")
        formBox.append(noteBox)
        noteList.append(formBox);
        console.log("Fill date and text of note");

        // var noteBox = $("<div class=\'divNotes mb-2\'> </div>");
        // noteBox.append($("<input type=\"hidden\" class=\"idNote\" name=\"idNote\" value=\"" + item.noteId + "\"/>"))
        // noteBox.append($("<h4 class=\"col-sm-4 timeNote\">" + item.time + "</h4>"))
        // noteBox.append($("<div class=\"textNote\" name=\"textNote\">" + item.text + "</div>"))
        // noteList.append(noteBox);
    });

    info.append(noteList);
    $("#insert_div").html(info);
    $(".divNotes").css({
        "background": "#B0E0E6",
        "border-color": "#4682B4",
        "border-style": "solid",
        "border-radius": "8px",
        "padding": "5px"
    });
    $("#addNote").click(addInput);
    $(".divNotes").click(function () {
        $(this).parent().submit()
    })
    function addInput() {
        $("#addNote").replaceWith("<div id=\"addDiv\">" +
            "<input class=\"form-control\" type=\"text\" id=\"textNote\" name=\"textNote\" placeholder=\"Text\">" +
            "<input class=\"form-control\" type=\"text\" id=\"coordinate\" name=\"coordinate\" placeholder=\"coordinate\">" +
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
        "<div id=\"images_box\">" +
            "<button class=\"btn m-2 btn-primary addRoute\" id=\"addNew\">Add note</button>" +
            "</div>");

        $("#addNew").click(addNewNote);
    }

    function addNewNote() {
        $.ajax({
            url: "newNoteServlet",
            success: displayNewNote,
            type: "GET",
            dataType: "text",
            data: { "text": $("#textNote").val(), "coordinate": $("#coordinate").val(), "photo": $("#photo").val() }
        });
    }

    function displayNewNote(data, status, jqxhr) {
        data = JSON.parse(data);
        var time = data.time;
        var date = new Date(time);
        var month = date.getMonth()+1;
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
}