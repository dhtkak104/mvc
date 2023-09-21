<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value = "<%=request.getContextPath()%>"/>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>TEMP</title>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>  
<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.0.0/crypto-js.min.js"></script>
<script src="${path}/js/common/convertUtil.js" type="text/javascript"></script>
<script src="${path}/js/join.js" type="text/javascript"></script>
<link href="${path}/css/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/css/common.css" rel="stylesheet" type="text/css">
<link href="${path}/css/join.css" rel="stylesheet" type="text/css">
</head>
<body>
    <section class="join-area">
		<div class="container">
			<div class="join_header">
				<p><span>회원가입</span></p>	
			</div>
			<div class="join_body"> 
				<form id="joinForm">
					<div>
						<input type="text" name="email" id="email" placeholder="이메일" maxlength="100">
					</div>
					<div>
						<input type="password" name="password" id="password" placeholder="비밀번호" maxlength="100">
					</div>
					<div>
						<input type="text" name="userName" id="userName" placeholder="이름" maxlength="100">
					</div>
					<input type="submit" value="회원가입 완료">
				</form>
			</div>
			
		</div>
	</section>
</body>
</html>