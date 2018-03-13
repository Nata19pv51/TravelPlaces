function setNotesContent(data, status, jqxhr) {
    console.log(data)
    data = JSON.parse(data)
    var info = $("#contener_div")
    $("header").hide();
    $("#contener_div").empty();
    $("body").css({
        "background-image": "#FFF5EE",
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
    $("#addNote").click(addNoteClick);
    $(".divNotes").click(function () {
        $(this).parent().submit()
    })
}