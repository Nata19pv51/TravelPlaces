$("document").ready(
//function () {
    //$("#routes").click(loadRoutes);
    $("#add").click(addNew);

    function loadRoutes() {
        console.log("Load routes");
        $('#homeInformation').empty();

        $.ajax("loadRoutesServlet",
            {
                success: setRoutesContent,
                type: "GET",
                dataType: "text"
            });
    });

    function setRoutesContent(data, status, jqxhr) {
        $("#div").empty();
        console.log(data)
        data = JSON.parse(data)
        var info = $("#div")
        $("header").hide();
        $("body").css({"background-image":"url(resources/images/Paris.jpg",
                      "background-repeat":"no-repeat",
                      "background-size":"cover"});

        var routeList = $("<form class=\"mt-5\" id=\"listRoutes\" method=\"GET\" action=\"editTextServlet\">" +
                            "<button class=\"btn m-2 btn-primary\" id=\"add\">Add new</button>" +
                         "</form>");
        data.forEach(function (item, i, data) {
            routeList.append(
                            "<div class=\"divRoutes mb-2\">" +
                                "<input type=\"hidden\" class=\"idRoute\" name=\"idRoute\" value=\"" + item.idRoute + "\"/>" +
                                    "<h4 class=\"col-sm-4 timeNote\">" + item.time + "</h4>" +
                                "<div class=\"textNote\" name=\"textNote\">" + item.name + "</div>" +
                            "</div>"
                         );
            console.log("Fill route");
        });

        info.append(routeList);
        $("#insert_div").html(info);
                   $(".divRoutes").css({"background":"#B0E0E6",
                                      "border-color":"#4682B4",
                                      "border-style":"solid",
                                      "border-radius":"8px",
                                      "padding":"5px"});
    }


    function addNew() {
        $("#div").empty();
        $.ajax(
        {
            url: "newRouteServlet",
            success: newRoute,
            type: "GET",
            dataType: "text",
            data: {"title": $(".titleRoute").val()}
        });
    }
    function newRoute(data, status, jqxhr) {
        var info = $("#div");
        $("header").hide();
        $("body").css({"background-image":"url(resources/images/Paris.jpg",
                      "background-repeat":"no-repeat",
                      "background-size":"cover"});

        var routeList = $("<input class=\"form-control\" type=\"text\" id=\"titleRoute\" name=\"titleRoute\" placeholder=\"Title\">" +
                          "<button class=\"btn m-2 btn-primary addNote\" id=\"addNote\">Add note</button>");
        info.append(routeList);
        $("#insert_div").html(info);
    }
//});


