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
        var urlArr;

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
        "<div class=\"container row\" id=\"images_box\">" +
            // "<div id=\"hiddenInput\">" +
            // "</div>" +

        "</div>" +
        "<button class=\"btn m-2 btn-primary addRoute\" id=\"addNew\">Add note</button>");
        
        //LOAD PHOTO:
        //***********************************************************************
        var options = {
            // http://jquery.malsup.com/form/#ajaxForm
            beforeSubmit: preSubmitCallback,  // pre-submit callback
            success: showResponse  // post-submit callback
    
            // other available options:
            //url:       url         // override for form's 'action' attribute
            //type:      type        // 'get' or 'post', override for form's 'method' attribute
            //dataType:  null        // 'xml', 'script', or 'json' (expected server response type)
            //clearForm: true        // clear all form fields after successful submit
            //resetForm: true        // reset the form after successful submit
    
            // $.ajax options can be used here too, for example:
            //timeout:   3000
        };
    
        // bind form using 'ajaxForm'
        $('#upload_form').ajaxForm(options);
    
        $("#input_box").change(selectImage);
        // pre-submit callback
        function preSubmitCallback(formData, jqForm, options) {
            $("#submit_button")[0].hidden = true;
            return true;
        }

        // post-submit callback
        function showResponse(responseText, statusText, xhr, $form) {
            // for normal html responses, the first argument to the success callback
            // is the XMLHttpRequest object's responseText property

            // if the ajaxForm method was passed an Options Object with the dataType
            // property set to 'xml' then the first argument to the success callback
            // is the XMLHttpRequest object's responseXML property

            // if the ajaxForm method was passed an Options Object with the dataType
            // property set to 'json' then the first argument to the success callback
            // is the json data object returned by the server
            $("#input_box").val("")
            var imagesBox = $("#images_box");
            var group = $("<div class=\"col-md-2\"></div>");
            imagesBox.append(group);
            group.append("<input hidden=\"true\" class=\"urlPhoto\" type=\"text\" value=\"" + responseText + "\" />"); 
            group.append("<img src=" + responseText + " class=\"img-thumbnail\" \>");

            // $(".imgContainer").css({
            //     // "position": "relative"
            // });
            // $(".closeIcon").css({
            //     "z-index": "2",
            //     // "position": "absolute"
            // });
            // $(".addedImage").css({
            //     "z-index": "1",
            //     // "position": "absolute"
            // });

            // $(".imgContainer").mouseover(function(){
            //     $(".closeIcon")[0].hidden = false;
            //     // alert('Вы поместили курсор в зону элемента foo.');
            // })
            // $(".imgContainer").mouseout(function(){
            //     $(".closeIcon")[0].hidden = true;
            // })
        }

        function selectImage() {
            $("#submit_button")[0].hidden = false;
        }
        //*******************************************************************************

        $("#addNew").click(addNewNote);
    }

    function addNewNote() {
        $.ajax({
            url: "newNoteServlet",
            success: displayNewNote,
            type: "GET",
            dataType: "text",
            //data: { "text": $("#textNote").val(), "coordinate": $("#coordinate").val(), "photo": $(".urlPhoto").val() }
            data: {
                "text": $("#textNote").val(),
                "coordinate": $("#coordinate").val(),
                "photo": $(".urlPhoto").map(function () {
                    return $(this).val();
                }).get().join(",")
            }
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