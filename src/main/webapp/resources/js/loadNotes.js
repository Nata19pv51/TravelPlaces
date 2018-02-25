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
        $("body").css({"background-image":"url(resources/images/Paris.jpg",
                      "background-repeat":"no-repeat",
                      "background-size":"cover"});
        var noteList = $("<div class=\"mt-5\" id=\"listNotes\">" +
                             "<button class=\"btn m-2 btn-primary\" id=\"addNote\">Add new</button>" +
                         "</div>");
        data.forEach(function (item, i, data) {
            var noteBox = $("<div class=\'divNotes mb-2\'> </div>");
            noteBox.append($("<input type=\"hidden\" class=\"idNote\" name=\"idNote\" value=\"" + item.noteId + "\"/>"))
            noteBox.append($("<h4 class=\"col-sm-4 timeNote\">" + item.time + "</h4>"))
            noteBox.append($("<div class=\"textNote\" name=\"textNote\">" + item.text + "</div>"))
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
        $(".divNotes").css({"background":"#B0E0E6",
                                    "border-color":"#4682B4",
                                    "border-style":"solid",
                                    "border-radius":"8px",
                                    "padding":"5px"});
        $("#addNote").click(addInput);
        $(".divNotes").click(function(){
            $(this).parent().submit()
        })
        function addInput() {
            $("#addNote").replaceWith("<div id=\"addDiv\">" +
                                            "<input class=\"form-control\" type=\"text\" id=\"textNote\" name=\"textNote\" placeholder=\"Text\">" +
                                            "<input class=\"form-control\" type=\"text\" id=\"coordinate\" name=\"coordinate\" placeholder=\"coordinate\">" +
                                            "<p id=\"photo\">Photo: </p>" +
                                            "<button class=\"btn m-2 btn-primary addRoute\" id=\"addNew\">Add note</button>" +
                                      "</div>");

            $("#addNew").click(addNewNote);
        }

        function addNewNote() {
            $.ajax({url: "newNoteServlet",
                    success: displayNewNote,
                    type: "GET",
                    dataType: "text",
                    data: {"text": $("#textNote").val(), "coordinate": $("#coordinate").val(), "photo": $("#photo").val()}
            });
        }

        function displayNewNote(data, status, jqxhr) {
            data = JSON.parse(data);
            $("#addDiv").replaceWith(
                "<button class=\"btn m-2 btn-primary\" id=\"add\">Add new</button>" +
                "<div class=\"divNotes mb-2\">" +
                "<input type=\"hidden\" class=\"idNote\" name=\"idNote\" value=\"" + data.noteId + "\"/>" +
                "<h4 class=\"col-sm-4 timeNote\">" + data.time + "</h4>" +
                "<div class=\"textNote\" name=\"textNote\">" + data.text + "</div>" +
                "</div>");

            $(".divNotes").css({"background":"#B0E0E6",
                                "border-color":"#4682B4",
                                "border-style":"solid",
                                "border-radius":"8px",
                                "padding":" 5px"});
        }

        

        //определить по элементу его номер в выборке:
        // var $set = $('ul li');
        // $('ul').on('click', 'li', function () {
        //     var n=$set.index(this);    
        //     console.log(n);
        // });

        // var $set = $("#listNotes .divNotes");
        // var element = $(".divNotes")
        // $("#listNotes").on('click', element, function () {
        //     var n=$set.index(this);    
        //     console.log(n);
        // });
        // $(".divNotes").click(openNote);
        // function openNote() {
        //     $.ajax({url: "oneNote.jsp",
        //             type: "GET",
        //             dataType: "text",
        //             data: {"idNote": $(".idNote").val()}
        //     });
        // }
    }

        // function getNote() {
        //     console.log("dblclick One Note");
            // $.ajax("openOneNoteServlet",
            //     {
            //         type: "GET",
            //         dataType: "text",
            //         data: { "id": $(".idNote").val() }
            //     });
            
        // }
        // $(".divNotes").click(function(){
        //         console.log("dblclick One Note");
        //         $.ajax("openOneNoteServlet",
        //             {
        //                 type: "GET",
        //                 dataType: "text",
        //                 data: { "id": $(".idNote").val() }
        //             });
                
        //     })                 


    //#FFE4C4
        //$("#i
    //    $("#notes").css({
    //                       "pointer-events":"none", /* делаем ссылку некликабельной */
    //                       "cursor":"default",  /* устанавливаем курсор в виде стрелки */
    //                       "color":"#999" /* цвет текста для нективной ссылки */
    //                      })
        //$("#delete").css('background', '#008000');





//        function oneNote(data, status, jqxhr){
//            console.log("oneNote function");
//           $("#div").empty();
//           data = JSON.parse(data);
//           var info = $("#div");
//           var noteList = $("<form class=\"mt-5\" id=\"listNotes\" method=\"GET\" action=\"editTextServlet\"></form>");
//           noteList.append(
//               "<div class=\"divNotes mb-2\">" +
//                   "<input type=\"hidden\" class=\"idNote\" name=\"idNote\" value=\"" + data.noteId + "\"/>" +
//                       "<h4 class=\"col-sm-4 timeNote\">" + data.time + "</h4>" +
//                   "<div class=\"textNote\" name=\"textNote\">" + data.text + "</div>" +
//               "</div>");
//           console.log("Fill date and text of note");
//           info.append(noteList);
//           $("#insert_div").html(info);
//           $(".divNotes").css({"background":"#B0E0E6",
//                              "border-color":"#4682B4",
//                              "border-style":"solid",
//                              "border-radius":"8px",
//                              "padding":"5px"});
//        }

//}
//);












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