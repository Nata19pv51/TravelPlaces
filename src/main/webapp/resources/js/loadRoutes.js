$("document").ready(function loadRoutes() {
    console.log("Load routes");
    // $('#homeInformation').remove();
    $.ajax("allRoutesServlet",
        {
            success: setRoutesContent,
            type: "GET",
            dataType: "text"
        });
}
);


function setRoutesContent(data, status, jqxhr) {
   $("#div").empty();
   console.log(data)
   data = JSON.parse(data)
   var info = $("#div")
   $("header").hide();
   $("body").css({"background-image":"url(resources/images/Paris.jpg)", "background-repeat":"no-repeat", "background-size":"cover"});
   var routeList = $("<div class=\"mt-5\" id=\"listRoutes\">" +
                       "<button class=\"btn m-2 btn-primary\" id=\"add\">Add new</button>" +
                    "</div>");


   data.forEach(function (item, i, data) {
       var time = item.time;
       var date = new Date(time);
       var month = date.getMonth()+1;
       date = date.getDate() + '.' + month + '.' + date.getFullYear() +
                    '  ' + date.getHours() + ':' + date.getMinutes() + ':' + date.getSeconds();

    //    var date = new Date(data.list[i].time);
    //    date = time.getDate() + '.' + time.getMonth()+1 + '.' + time.getFullYear();
        console.log(date);
       routeList.append(
                       "<div class=\"divRoutes mb-2\">" +
                           "<input type=\"hidden\" class=\"idRoute\" name=\"idRoute\" value=\"" + item.idRoute + "\"/>" +
                           "<div class=\"text-muted text-small text-left timeNote\">" + date + "</div>" +
                           "<div class=\"textNote text-left\" name=\"textNote\">" + item.name + "</div>" +
                       "</div>"
                    );
       console.log("Fill route");
       info.append(routeList);
       $("#insert_div").html(info);
                  $(".divRoutes").css({"background":"#B0E0E6",
                                     "border-color":"#4682B4",
                                     "border-style":"solid",
                                     "border-radius":"8px",
                                     "padding":" 5px"});
       $("#add").click(addInput);
   })
}

function addInput() {
    //$("#div").empty();
    $("#add").replaceWith("<div id=\"addDiv\">" +
                            "<input class=\"form-control\" type=\"text\" id=\"titleRoute\" name=\"titleRoute\" placeholder=\"Title\">" +
                            "<button class=\"btn m-2 btn-primary addRoute\" id=\"addRoute\">Add route</button>" +
                          "</div>");

    $("#addRoute").click(addRoute);
}


function addRoute() {
    $.ajax({url: "newRouteServlet",
            success: displayNewRoute,
            type: "GET",
            dataType: "text",
            data: {"title": $("#titleRoute").val()}
    });
}
function displayNewRoute(data, status, jqxhr) {
    data = JSON.parse(data);

    var time = data.time;
    var date = new Date(time);
    var month = date.getMonth()+1;
    date = date.getDate() + '.' + month + '.' + date.getFullYear() +
                    '  ' + date.getHours() + ':' + date.getMinutes() + ':' + date.getSeconds();

    $("#addDiv").replaceWith(
        "<button class=\"btn m-2 btn-primary\" id=\"add\">Add new</button>" +
        "<div class=\"divRoutes mb-2\">" +
        "<input type=\"hidden\" class=\"idRoute\" name=\"idRoute\" value=\"" + data.idRoute + "\"/>" +
        "<div class=\"text-muted text-small text-left timeRoute\">" + date + "</div>" +
        "<div class=\"textRoute text-leftt\" name=\"textRoute\">" + data.name + "</div>" +
        "</div>");

        $(".divRoutes").css({"background":"#B0E0E6",
                                     "border-color":"#4682B4",
                                     "border-style":"solid",
                                     "border-radius":"8px",
                                     "padding":" 5px"});

    // var routeList = $("<input class=\"form-control\" type=\"text\" id=\"titleRoute\" name=\"titleRoute\" placeholder=\"Title\">" +
    //     "<button class=\"btn m-2 btn-primary addRoute\" id=\"addRoute\">Add route</button>");
    // info.append(routeList);
    // $("#insert_div").html(info);
}



