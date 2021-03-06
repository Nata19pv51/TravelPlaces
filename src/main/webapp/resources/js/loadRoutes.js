$("document").ready(function loadRoutes() {
    console.log("Load routes");
    // $('#homeInformation').remove();
    $.ajax("allRoutesServlet",
        {
            success: setRoutesContent,
            type: "GET",
            dataType: "text"
        });
});


function setRoutesContent(data, status, jqxhr) {
    $("#allRoutes").empty();
    console.log(data)

    if(data == "{\"routes\": \"null\"}"){
        $("#add").click(addInputRoute);
    }
    else{
        data = JSON.parse(data)
        var info = $("#allRoutes");
        $("header").hide();
        $("body").css({ "background-image": "#FFF5EE", "background-repeat": "no-repeat", "background-size": "cover" });
        var routeList = $("<div class=\"mt-2\" id=\"listRoutes\"></div>");

        info.append(routeList);
        $("#add").replaceWith("<button class=\"btn m-2 btn-primary\" id=\"add\">Add route</button>");
        data.forEach(function (item, i, data) {
            var time = item.time;
            var date = new Date(time);
            var month = date.getMonth() + 1;
            date = date.getDate() + '.' + month + '.' + date.getFullYear() +
                '  ' + date.getHours() + ':' + date.getMinutes() + ':' + date.getSeconds();
            console.log(date);
            routeList.append(
                "<div class=\"divRoutes mb-2\">" +
                "<input type=\"hidden\" class=\"idRoute\" name=\"idRoute\" value=\"" + item.idRoute + "\"/>" +
                // "<input type=\"hidden\" class=\"idRoute\" name=\"idRoute\" value=<%= request.getParameter(\"idRoute\") %>/>" +
                "<div class=\"text-muted text-small text-left timeNote\">" + date + "</div>" +
                "<div class=\"textNote text-left\" name=\"textNote\">" + item.name + "</div>" +
                "</div>"
            );
            console.log("Fill route");

            //$("#insert_div").html(info);
            $(".divRoutes").css({
                "background": "#B0E0E6",
                "border-color": "#4682B4",
                "border-style": "solid",
                "border-radius": "8px",
                "padding": " 5px"
            });
            $("#add").click(addInputRoute);
            $(".divRoutes").click(function () {
                console.log($(this).children("input").val())

                $.ajax("showOneRouteServlet",
                    {
                        success: oneRouteShow,
                        type: "POST",
                        dataType: "text",
                        data: { "id": $(this).children("input").val() }
                    })

                // $(this).parent().submit();
                // oneRouteShow();
            })

        })
    }
}
function addInputRoute() {
    //$("#div").empty();
    $("#add").replaceWith(
        "<div id=\"add\">" +
            "<input class=\"form-control\" type=\"text\" id=\"titleRoute\" name=\"titleRoute\" placeholder=\"Title\">" +
            "<button class=\"btn m-2 btn-primary addRoute\" id=\"addRoute\">Add route</button>" +
        "</div>");

    $("#addRoute").click(addRoute);
}

function addRoute() {
    $.ajax({
        url: "newRouteServlet",
        success: setRoutesContent,
        type: "GET",
        dataType: "text",
        data: { "title": $("#titleRoute").val() }
    });
}