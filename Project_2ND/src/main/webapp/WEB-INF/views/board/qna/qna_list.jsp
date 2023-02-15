<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/board/qna_list.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- **스트랩** -->
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<!-- ******* -->
<style type="text/css">
	li {list-style: none; float: left; padding: 6px;}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/common/navbar.jsp" %>

<div id="navArea"></div>

<div class="container" id="main_Con">
	<div class="row">
		<form name="form1">
			<select id="selectBox" name="option">
			  <option value="NICKNAME">닉네임</option>
			  <option value="SUBJECT">제목</option>
			  <option value="CONTENT">내용</option>
			  <option value="SUBJECT,CONTENT">제목+내용</option>	  
			</select>
			<input type="text" placeholder="검색" name="keyword">  
			<input id="searchBtn"type="button" value="검색">  
			<input type="hidden" name="page" value="1">
		</form>
		<div class="col-md-9">
			<table class="table table-list-search">
				<tr id="tHead">
					<td>질문번호</td>
					<td>작성자</td>
					<td>제목</td>
					<td>답변여부</td>
					<td>생성일자</td>
				</tr>
				<c:forEach var="list" items="${data}">
				<tr>
					<td>${list.question_id}</td>
					<td><a href="/qna/list/${list.question_id}">${list.nickname}</a></td>
					<td>${list.q_subject}</td>
					<c:if test="${list.answer!=null}">
						<td>완료</td>
					</c:if>
					<td>진행중</td>		
					<td>${list.q_create_date}</td>
				</tr>
				</c:forEach>
			</table>
			
			<form name="form2">
			<div id="pagination">
				<ul id="pageUL" class="btn-group pagination">
				    <c:if test="${pageMaker.prev}">
				    <li class="left">
				        <a class="left" href='<c:url value="/qna/list?page=${pageMaker.startPage-1}"/>'><i class="fa fa-chevron-left"></i></a>
				    </li>
				    </c:if>
				    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="pageNum">
				    <li class="curPage">
				        <a href='<c:url value="/qna/list?page=${pageNum}"/>'><i class="fa">${pageNum}</i></a>
				    </li>
				    </c:forEach>
				    <c:if test="${pageMaker.next && pageMaker.endPage >0}">
				    <li class="right">
				        <a class="right" href='<c:url value="/qna/list?page=${pageMaker.endPage+1}"/>'><i class="fa fa-chevron-right"></i></a>
				    </li>
				    </c:if>
				</ul>
			</div>
			
			<input id="pageH" type="hidden" name="page" value="${pageMaker.cri.page}">
			<input id="keywordH" type="hidden" name="keyword" value="${pageMaker.cri.keyword}">
			<input id="optionH" type="hidden" name="option" value="${pageMaker.cri.option}">
			</form>
			
			<input type="button" value="질문등록" onclick="location.href='/qna/create'">
		</div>
	</div>
</div>
<script>
//selectbox 선택한 값만 검색 - 02.07 장재호
$('#searchBtn').click(function(){
	if($('input[type=text]').val() == 'undefined' || $('input[type=text]').val() == ''){		
		alert("검색어를 입력하세요");
		return;
	}
	document.form1.submit();
});


//검색 시 페이징처리 처리 - 02.14 장재호
//1) 페이지 버튼 클릭 시 pageNum값을 가지고 form태그로 이동하도록 처리
//2) 화면에 검색키워드가 미리 남겨지도록 처리.
var pagination = document.querySelector("#pagination");
var pageUL = document.querySelector('#pageUL');
pagination.onclick = function() {
	event.preventDefault();
	if((event.target.className).indexOf("right") != -1){
		document.form2.page.value = Number(document.form2.page.value) +5;
		document.form2.submit();
		return;
	}else if((event.target.className).indexOf("left") != -1){
		document.form2.page.value = Number(document.form2.page.value) -5;
		document.form2.submit();
		return;
	}else if(event.target.tagName == 'A' || event.target.tagName == 'I'){
		document.form2.page.value = event.target.textContent;
		document.form2.submit();
	}
	else return;
}
</script>
<footer>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</footer>
</body>
</html>