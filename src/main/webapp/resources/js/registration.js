$("document").ready(function () {
    $("#register").click(getData);
});
function getData() {
    $.ajax(
        {
            url: "registeredServlet",
            success: registerUser,
            type: "POST",
            dataType: "text",
            data: { "login": $("#loginReg").val(), "password": $("#passwordReg").val(), "email": $("#emailReg").val() }
        });
}
function registerUser(data, status, jqxhr) {
    data = JSON.parse(data);
    if (data.userAbsent == "no") {
        alert("Suchr login exists!");
    }
    else {
        alert("You have successfully registered!")
        window.location.replace("index.jsp");
    }

}