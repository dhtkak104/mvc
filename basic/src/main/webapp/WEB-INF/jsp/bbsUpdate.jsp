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
<script src="${path}/js/common/convertUtil.js" type="text/javascript"></script>  
<script src="${path}/js/bbsUpdate.js" type="text/javascript"></script>
<link href='https://cdn.rawgit.com/openhiun/hangul/14c0f6faa2941116bb53001d6a7dcd5e82300c3f/nanumbarungothic.css' rel='stylesheet' type='text/css'>
<link href="${path}/css/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/css/common.css" rel="stylesheet" type="text/css">
<link href="${path}/css/bbsUpdate.css" rel="stylesheet" type="text/css">  
</head>
<body>
	<section class="bbs-view-area">
		<h2 class="hidden">bbs-update-area</h2>
		<div class="container">
			<h3>공지사항 수정</h3>
			<form id="saveForm">
				<input type="hidden" name="bbsNo" value="${bbs.bbsNo}">
				<div class="view_head">
					<input type="text" name="bbsTitle" placeholder="제목을 입력해주세요." maxlength="100" value="${bbs.bbsTitle}">
				</div>
				<div class="view_mid">
					<input type="text" name="userName" placeholder="이름을 입력해주세요." maxlength="100" value="${bbs.userName}">
				</div>
				<div class="view_cont">
					<textarea rows="15" cols="165" name="bbsContents" placeholder="내용을 입력해주세요.(2000자 이내)">${bbs.bbsContents}</textarea>
				</div>
				<div class="view_bottom clearfix">
					<input type="submit" value="저장">
					<a onclick="history.back()">취소</a>	
				</div>	
			</form>		
		</div>
	</section>

</body>
</html>