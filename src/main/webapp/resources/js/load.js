$("document").ready(function () {
    $("#notes").click(loadData);
});

function loadData() {
    $('#homeInformation').remove();
    $.ajax("servletInNotes",
        {
            success: setNotesContent,
            type: "GET",
            dataType: "text"
        });
}

function setNotesContent(data, status, jqxhr) {
    data = JSON.parse(data)
    var info = $("#div")
    data.forEach(function (item, i, data) {
        info.append(
            "<p> USER ID: " + item.userId + "</p>" +
            "<p>Date of creation: " + item.time + "</p>" +
            "<p>Coord : " + item.coordination + "</p>" +
            "<p>Text : " + item.text + "</p>")
    });
    $("#insert_div").html(info);
}