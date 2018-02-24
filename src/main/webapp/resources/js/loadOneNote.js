$("document").ready(function(){
    loadNote();
    $(".textNote").dblclick(editText);
});

function loadNote(){
    var info = $("#div");
    $("body").css({"background-image":"url(resources/images/Paris.jpg",
                  "background-repeat":"no-repeat",
                  "background-size":"cover"});

    $.ajax("getOneNoteServlet",
        {
            success: ,
            type: "GET",
            dataType: "text",
            data: { "id": $(".idNote").val(), "text": $(".textNote").val() }
        });              
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
        $(".divNotes").dblclick(getNote);
    });

    info.append(noteList);
    $("#insert_div").html(info);

}



function editText() {
    $(this).replaceWith(
        "<div id=\"replaceText\">" +
        "<input type=\"text\" class=\"textNote\" name=\"textNote\" value=\"" + $(this).html() + "\">" +
        "<div class=\"input-group\">" +
        "<span class=\"input-group-btn\">" +
        "<button class=\"btn btn-info\" id=\"saveText\">Save</button>" +
        "<button class=\"btn btn-info\">Cancel</button>" +
        "</span>" +
        "</div>");
    $("#saveText").click(newData);

    function newData() {
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
        $("#replaceText").replaceWith("<div class=\"textNote\" name=\"textNote\">" + data.text + "</div>")
    }
}