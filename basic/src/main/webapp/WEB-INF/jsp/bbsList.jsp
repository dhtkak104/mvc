<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--JSTL 사용 선언 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--JSTL 변수 선언 --%>     
<c:set var="path" value = "<%=request.getContextPath()%>"/>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>TEMP</title>
<%-- jQuery 사용 선언 --%>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
<%-- js 사용선언: <script src="경로" type="text/javascript"></script> --%> 
<script src="${path}/js/bbsList.js" type="text/javascript"></script>
<%-- 웹폰트 사용 선언 --%>
<link href='https://cdn.rawgit.com/openhiun/hangul/14c0f6faa2941116bb53001d6a7dcd5e82300c3f/nanumbarungothic.css' rel='stylesheet' type='text/css'>
<%-- css 사용선언: <link href="경로" rel="stylesheet" type="text/css"> --%> 
<link href="${path}/css/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/css/common.css" rel="stylesheet" type="text/css">
<link href="${path}/css/bbsList.css" rel="stylesheet" type="text/css">  
</head>
<body>
	<%-- header.jsp 가져오기 --%>
	<jsp:include page="header.jsp"/> 
	<section class="bbs-area">
		<h2 class="hidden">bbs-list-area</h2>
		<div class="container">
			<h3>게시판</h3>
			<div class="option">
				<a class="add_btn" href="/bbs/insert-view">추가</a>
				<form action="bbs" method="get">
					<input type="text" name="keyword" placeholder="검색어를 입력해주세요." value="">
					<input type="submit" value="검색">
				</form>
			</div>
			<table>
				<caption>제목, 작성자, 게시일</caption>
				<colgroup>
					<col style="width:*%">
					<col style="width:10%">
				</colgroup>
				<thead>
					<tr>
						<th>제목</th>
						<th>작성자</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${bbs}" var="item">
						<tr onClick="selectBbsDetail(${item.bbsNo})">
							<td class="leftAlign">${item.bbsTitle}</td>
							<td class="leftAlign">${item.userName}</td>
						</tr>		
					</c:forEach>								
				</tbody>
			</table>
		</div>
	</section>
</body>
</html>