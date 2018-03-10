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
    note.append("<div id=\"cordinateNote\" name=\"cordinateNote\">" + data.coordination + "</div>");
    //var imgBox = $("<div class=\"container row\" style=\"background: white\" id=\"images_box\"></div");
    //note.append(imgBox);
    
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
        "<div id=\"replaceText\">" +
        "<input type=\"text\" class=\"textNote text-left\" name=\"textNote\" value=\"" + $(this).html() + "\">" +
        "<div class=\"input-group\">" +
        "<span class=\"input-group-btn row\">" +
        "<button class=\"btn btn-info \" id=\"saveText\">Save</button>" +
        "<button class=\"btn btn-info col-sm-offset-3\" id=\"cancelSaveText\">Cancel</button>" +
        "</span>" +
        "</div>");
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