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
<script src="${path}/js/header.js" type="text/javascript"></script>
<link href='https://cdn.rawgit.com/openhiun/hangul/14c0f6faa2941116bb53001d6a7dcd5e82300c3f/nanumbarungothic.css' rel='stylesheet' type='text/css'>
<link href="${path}/css/header.css" rel="stylesheet" type="text/css">  
</head>
<body>
	<nav class="clearfix">
		<h1 class="logo">
			<a href="/bbs"><img src="/img/logo_m.png" alt="logo"></a>
		</h1>
		<ul class="nav-list">
			<li><a href="/bbs">게시판</a></li>
			<li><a href="/schools">학교정보</a></li>
			<li><a href="/bbs">게시판</a></li>
			<li><a href="/bbs">게시판</a></li>
			<c:choose>		
			    <c:when test="${not empty sessionScope.user.userName}">
				    <ul class="headerDrop">
				    	<li class="headerLI">
				        	<a><span>${sessionScope.user.userName}</span>님</a>
				        	<div class="profile">
				        		<c:choose>	
					        		<c:when test="${not empty sessionScope.user.profilePath}">
					        			<img class="profile" src="${sessionScope.user.profilePath}">
					        		</c:when>
					        		<c:otherwise>
										<img class="profile" src="/img/defaultProfile.jpg">
					        		</c:otherwise>
				        		</c:choose>	
				    		</div>
				        	<br><br>
				        	<ul class="headerDown">	
								<li onClick="logout()">로그아웃</li>
							  	<li>마이페이지</li>					      	
							</ul>
						</li>
					</ul>
			    </c:when>
			    <c:otherwise>		    
					<li><a href="/login-view">회원가입 및 로그인</a></li>				
			    </c:otherwise>	
			</c:choose>		
		</ul>			
	</nav>	
</body>
</html>