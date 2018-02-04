//$( document ).ready(function(){
//    $.getJSON('/noteServlet', function(data){
//        var output = '<ul class="result">';
//        $.each(data, function(key, val){
//            output += '<li>Hello</li>';
////            output += '<h2>' + val.idNote + '</h2>';
////            output += '<h2>' + val.dateCreation + '</h2>';
////            output += '</li>';
//        });
//        output += '</ul>';
//        $(#insertion).load(output);
//    });
//});

//$("document").ready(function() {
//    function loadData() {
//        $.ajax("noteServlet",
//               { success: setContent,
//                 type: "GET",
//                 dataType: "text" });
//    }
//});
//function setContent(data, status, jqxhr) {
//    $.getJSON('/noteServlet', function(data){
//            var output = '<ul class="result">';
//            $.each(data, function(key, val){
//                output += '<li>Hello</li>';
//    //            output += '<h2>' + val.idNote + '</h2>';
//    //            output += '<h2>' + val.dateCreation + '</h2>';
//    //            output += '</li>';
//            });
//            output += '</ul>';
//            $(#insertion).text(output);
//        });
//}





//$("document").ready(function() {
//    $("#notes").click(loadData);
//});
//
//function loadData() {
//    $.ajax("servletInNotes",
//           { success: setContent,
//             type: "GET",
//             dataType: "text" });
//}
//
//function setContent(data, status, jqxhr) {
//    $('#homeInformation').remove();
//    $("#insert_div").text(data);
//}



$("document").ready(function() {
    $("#notes").click(loadData);
});

function loadData() {
    $.ajax("servletInNotes",
           { success: setContent,
             type: "GET",
             dataType: "text" });
}

function setContent(data, status, jqxhr) {
    $('#homeInformation').remove();

    $.getJSON('/noteServlet', function(data){
            var output = '<ul class="result">';
            $.each(data, function(key, val){
                output += '<li>Hello</li>';
    //            output += '<h2>' + val.idNote + '</h2>';
    //            output += '<h2>' + val.dateCreation + '</h2>';
    //            output += '</li>';
            });
            output += '</ul>';
            $(#insert_div).append(output);
        });
}


//$("document").ready(function() {
//    $("#notes").click(setContent);
//});
//function setContent(data, status, jqxhr) {
//    $('#homeInformation').remove();
//}