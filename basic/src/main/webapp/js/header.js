var serverUrl = document.location.origin;

$(function() {
	
});

function logout(){
	var data = {};
	
	$.ajax({
		url: '/logout',
		type: 'POST',
		data: JSON.stringify(data),
		dataType: 'json',
		contentType: 'application/json',
		success: function (data, txtStatus, xhr) {
			var code = xhr.status;
			if(200 <= code && code < 300) 
			{
				if(data) {
					$(location).attr('href', '/bbs');
				} else {
					alert("로그아웃 실패");
				}
			}
			else {
				alert("로그아웃 실패");
			}
		}
	});
}