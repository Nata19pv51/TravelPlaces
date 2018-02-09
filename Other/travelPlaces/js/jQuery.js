//$(document).ready(function() {
//	$('#btnSign').blur(function() {
//		$.ajax({
//			url : 'GetUserServlet',
//			data : {
//				userName : $('#btnSign').val()
//			},
//			success : function(responseText) {
//				$('#ajaxGetUserServletResponse').text(responseText);
//			}
//		});
//	});
//});

$.getJSON('noteServlet', function(data){
    var output = '<ul class="result">';
    $.each(data, function(key, val){
        output += '<li>';
        output += '<h2>' + val.idNote + '</h2>';
        output += '<h2>' + val.dateCreation + '</h2>';
        output += '</li>';
    });
    output += '</ul>';
    $(#insertion).html(output);
});
    
    
    
    
    
    <p class="form-control" type="text" id="textNote">Hello!</p>
                <div class="form-control">
                    <img src="logo4.jpg" id="photoNote" class="img-rounded" alt="Cinque Terre">
                </div>