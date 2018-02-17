$("document").ready(function () {
    console.log("Natasha");
    $("#register").click(getData);

});
function getData() {
    console.log("Inna");
    $.ajax(
        {
            url: "registeredServlet",
            success: registerUser,
            type: "POST",
            dataType: "text",
            data: { "login": $("#loginReg").val(), "password": $("#passwordReg").val(), "email": $("#emailReg").val()}
        });
}
function registerUser(data, status, jqxhr) {
    data = JSON.parse(data);
    console.log(data);
    if(data == "no"){
        $("#registerForm").replaceWith("Enter another login!");
        console.log("Hello");
    }
    else{
        $("#registerForm").replaceWith("You have successfully registered!");
        $("#navigate").replaceWith("<div class=\"navbar-nav mr-auto\">" +
                                       "<a class=\"nav-item nav-link active\" id=\"homePage\" href=\"homePageServlet\">Home</a>" +
                                       "<a class=\"nav-item nav-link\" href=\"#\">Routes</a>" +
                                       "<a class=\"nav-item nav-link\" id=\"notes\" href=\"#\">Notes</a>" +
                                       "<a class=\"nav-item nav-link\" href=\"#\">Gallery</a>" +
                                       "<a class=\"nav-item nav-link\" href=\"#\">Map</a>" +
                                   "</div><!-- navbar-nav -->");
        console.log("Word");
        $('#registerScript').replaceWith("<script id=\"loadScript\" src=\"resources/js/load.js\"></script>");
        console.log("Nidialkova");
    }

}