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
            "<p> ID: " + item.idNote +
            "Date of creation: " + item.dateCreation +
            // "Coordinate: " + item.coordinate +
            // "Text note: " + item.text + 
            "$</p>")
    });
    $("#insert_div").html(info);
}