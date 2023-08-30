var serverUrl = document.location.origin;

$(function() {
	
});

function bbsDelete(bbsNo){
	var data = {bbsNo:bbsNo};
	
	$.ajax({
		url: '/bbs/delete',
		type: 'DELETE',
		data: JSON.stringify(data),
		dataType: 'json',
		contentType: 'application/json',
		success: function (data, txtStatus, xhr) {
			var code = xhr.status;
			if(200 <= code && code < 300) 
			{
				if(code == 204 || data) {
					$(location).attr('href', '/bbs');
				} else {
					alert("삭제실패");
				}
			}
			else {
				alert("삭제실패");
			}
		}
	});
}