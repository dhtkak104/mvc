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
<script src="${path}/js/login.js" type="text/javascript"></script>
<link href="${path}/css/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/css/common.css" rel="stylesheet" type="text/css">
<link href="${path}/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
    <section class="login-area">
		<h2 class="hidden">login</h2>
		<div class="container">
			<div class="login_header">
				<p>로그인</p>
			</div>
			<div class="login_body">
				<form id="loginForm">
					<input type="text" name="email" placeholder="이메일" maxlength="100"> 
					<input type="password" name="password" placeholder="비밀번호" maxlength="100"> 
					<input type="submit" value="로그인">
						
					<div class="login_option">
						<div class="login_link_text">
							<a href="pwFind" class="login_link_pw">비밀번호 찾기</a> 
							<a href="join-view" class="login_link_join">회원가입</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>
</body>
</html>