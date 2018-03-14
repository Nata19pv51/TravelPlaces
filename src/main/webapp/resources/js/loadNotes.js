$("document").ready(function loadData() {
    console.log("Load");
    $.ajax("noteServlet",
        {
            success: setNotesContent,
            type: "GET",
            dataType: "text"
        });
});