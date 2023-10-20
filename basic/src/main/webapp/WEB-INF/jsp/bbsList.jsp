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
					<c:forEach items="${bbs.bbsList}" var="item">
						<tr onClick="selectBbsDetail(${item.bbsNo})">
							<td class="leftAlign">${item.bbsTitle}</td>
							<td class="leftAlign">${item.userName}</td>
						</tr>		
					</c:forEach>								
				</tbody>
			</table>
			<%-- page navigation bar pack of 5 --%>
			<div class="page">
				<%-- 
					[처음] : 제일 첫 페이지
					[이전] : 이전 startPage (startPage 1,6,11,16...)					 
				--%>	
				<c:if test="${bbs.startPage!=1}">
					<a href="bbs?currentPage=1
						<c:if test="${bbs.keyword!=null}">						
							&keyword=${bbs.keyword}							
						</c:if>
					">[처음]</a>
					<a href="bbs?currentPage=${bbs.startPage-1}&keyword=${bbs.keyword}">[이전]</a>
				</c:if> 
				<%-- 
					startPage ~ (endPage or pageTotalCnt) For문 돌며 페이징 네비바의 페이지 번호 표현 	
					
					cf. bbs.endPage < bbs.pageTotalCnt ? bbs.endPage : bbs.pageTotalCnt 조건설명
						페이징 네비바의 마지막 페이징은 pageTotalCnt 사용, 나머지 페이징은 endPage 사용하기 위함
						
						ex) 게시글 101개, 페이지당 10개씩 게시물 노출, 페이징 5개씩 표현 
					 		currentPage  : 10	11	
					 		endPage 	 : 10	15	
					  		pageTotalCnt : 11	11  
				--%>
				<c:forEach var="pageNo" begin="${bbs.startPage}" end="${bbs.endPage < bbs.pageTotalCnt ? bbs.endPage : bbs.pageTotalCnt}">
					<c:choose>
						<c:when test="${pageNo == bbs.currentPage}">
							<b class="currentPage">${pageNo}</b>
						</c:when>
						<c:otherwise>
							<a class="remainPage" href="bbs?currentPage=${pageNo}
								<c:if test="${bbs.keyword!=null}">						
									&keyword=${bbs.keyword}							
								</c:if>
							">${pageNo}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach> 
				<%-- 
					[다음] : 다음 endPage (endPage 5,10,15,20...)
					[마지막] : 제일 마지막 페이지 					 
					
					cf. bbs.endPage < bbs.pageTotalCnt 조건설명
						endPage : 현재페이지 페이징 네비바의 가장 마지막 페이지 번호 
						pageTotalCnt : 게시글 표현할 수 있는 실제 총 페이지 번호
					 	
					 	ex) 게시글 101개, 페이지당 10개씩 게시물 노출, 페이징 5개씩 표현 
					 		currentPage  : 10	11	
					 		endPage 	 : 10	15	
					  		pageTotalCnt : 11	11 					
				--%>
				<c:if test="${bbs.endPage < bbs.pageTotalCnt}">
					<a href="bbs?currentPage=${bbs.endPage+1}
						<c:if test="${bbs.keyword!=null}">						
							&keyword=${bbs.keyword}							
						</c:if>
					">[다음]</a>
					<a href="bbs?currentPage=${bbs.pageTotalCnt}
						<c:if test="${bbs.keyword!=null}">						
							&keyword=${bbs.kewword}							
						</c:if>
					">[마지막]</a>
				</c:if>
			</div>
		</div>
	</section>
</body>
</html>