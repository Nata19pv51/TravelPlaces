$(document).ready(function() {
	$('#btnSign').blur(function() {
		$.ajax({
			url : 'GetUserServlet',
			data : {
				userName : $('#btnSign').val()
			},
			success : function(responseText) {
				$('#ajaxGetUserServletResponse').text(responseText);
			}
		});
	});
});