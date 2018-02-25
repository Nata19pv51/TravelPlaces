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
       routeList.append(
                       "<div class=\"divRoutes mb-2\">" +
                           "<input type=\"hidden\" class=\"idRoute\" name=\"idRoute\" value=\"" + item.idRoute + "\"/>" +
                               "<h4 class=\"col-sm-4 timeNote\">" + item.time + "</h4>" +
                           "<div class=\"textNote\" name=\"textNote\">" + item.name + "</div>" +
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
    $("#addDiv").replaceWith(
        "<button class=\"btn m-2 btn-primary\" id=\"add\">Add new</button>" +
        "<div class=\"divRoutes mb-2\">" +
        "<input type=\"hidden\" class=\"idRoute\" name=\"idRoute\" value=\"" + data.idRoute + "\"/>" +
        "<h4 class=\"col-sm-4 timeRoute\">" + data.time + "</h4>" +
        "<div class=\"textRoute\" name=\"textRoute\">" + data.name + "</div>" +
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



