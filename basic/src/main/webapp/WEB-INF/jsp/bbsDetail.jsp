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
<script src="${path}/js/bbsDetail.js" type="text/javascript"></script>
<link href='https://cdn.rawgit.com/openhiun/hangul/14c0f6faa2941116bb53001d6a7dcd5e82300c3f/nanumbarungothic.css' rel='stylesheet' type='text/css'>
<link href="${path}/css/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/css/common.css" rel="stylesheet" type="text/css">
<link href="${path}/css/bbsDetail.css" rel="stylesheet" type="text/css">  
</head>
<body>
	<section class="bbs-view-area">
		<h2 class="hidden">bbs-detail-area</h2>
		<div class="container">
			<h3>공지사항</h3>
			<div class="view_head">
				<p class="title">${bbs.bbsTitle}</p>
				<ul class="clearfix">
					<li>${bbs.email}</li>
					<li>${bbs.userName}</li>
					<li>${bbs.views}</li>
				</ul>
			</div>
			<div class="view_cont">
				<pre class="bbsContents">${bbs.bbsContents}</pre>
			</div>
			
			<div class="view_bottom clearfix">
				<div class="btn_list">
					<a class="list_btn" href="/bbs">목록</a>
					<a href="/bbs/update-view?bbsNo=${bbs.bbsNo}">수정</a>
					<a onclick="bbsDelete(${bbs.bbsNo})">삭제</a>
				</div>
			</div>			
		</div>
	</section>
</body>
</html>