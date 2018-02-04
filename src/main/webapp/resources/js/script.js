//var request;
//if(window.XMLHttpRequest){
//    request = new XMLHttpRequest();
//} else{
//        request = new ActiveXObject("Microsoft.XMLHTTP");
//}
//request.open('GET', 'noteServlet');
//request.onreadystatechange = function(){
//    if((request.readyState === 4) && (request.status === 200)){
//        var items = JSON.parse(request.responseText);
//        var output = '<ul>';
//        for(var key in items){
//            output += '<li>' + items[key].name + '</li>';
//        }
//        output += '</ul>';
//        document.getElementById('textNote').innerHTML = output;
//    }
//}
//request.send();

//$.getJSON('/noteServlet', function(data){
//    var output = '<ul class="result">';
//    $.each(data, function(key, val){
//        output += '<li>';
//        output += '<h2>' + val.idNote + '</h2>';
//        output += '<h2>' + val.dateCreation + '</h2>';
//        output += '</li>';
//    });
//    output += '</ul>';
//    $(#insertion).html(output);
//});

//$( document ).ready(function(){
//    $.getJSON('/noteServlet', function(data){
//        var output = '<ul class="result">';
//        $.each(data, function(key, val){
//            output += '<li>';
//            output += '<h2>' + val.idNote + '</h2>';
//            output += '<h2>' + val.dateCreation + '</h2>';
//            output += '</li>';
//        });
//        output += '</ul>';
//        $(#insertion).jsp(output);
//    });
//});
