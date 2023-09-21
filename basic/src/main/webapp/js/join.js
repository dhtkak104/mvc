$(function() {
	
	$("#joinForm").submit(function(e){	 
		e.preventDefault();
		var formData = new FormData($(this)[0]);
		for (let value of formData.values()) {
			if (value.trim() === ''){
				alert('모든 항목을 입력해주세요.');
				return;
			}
		}
		
	 	var emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
		if(!emailRegex.test(formData.get('email'))) {
			alert('이메일을 다시 확인해주세요.');
			return;	
		}
				
		var data = {
            email: formData.get('email'),
            password: formData.get('password'),
            userName: formData.get('userName'),
        };

		$.ajax({
			url: '/join',
			type: 'POST',
			data: JSON.stringify(data),
			dataType: 'json',
			contentType: 'application/json',
			success: function (data, txtStatus, xhr) {
				var code = xhr.status;
				if(200 <= code && code < 300) 
				{
					if(data){
						$(location).attr('href', '/login-view');
					} else {
						alert("이미 사용하는 이메일 주소가 존재합니다.");
					}
				}
				else {
					alert("회원가입 실패");
				}
			}
		});
		return false;
	});
	
});