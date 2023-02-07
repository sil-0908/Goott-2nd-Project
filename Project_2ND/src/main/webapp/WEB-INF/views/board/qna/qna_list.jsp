<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/common/table.css">
<link rel="stylesheet" href="/resources/css/board/qna_list.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/common/navbar.jsp" %>
<div id="navArea"></div>

<div id="main_Con">
<form name="form1">
	<select id="selectBox" onChange="getSelect(this)">
	  <option value="NICKNAME">닉네임</option>
	  <option value="Q_SUBJECT">제목</option>
	  <option value="Q_CONTENT">내용</option>
	  <option value="Q_SUBJECT,Q_CONTENT">제목+내용</option>	  
	  <input id="optionV" type="hidden" name="option" value="NICKNAME">
	</select>
	<input type="text" placeholder="검색" name="keyword" value="${keyword}" />  
	<input type="button" value="검색" />  
</form>  
	<table>
		<tr id="tHead">
			<td>질문번호</td>
			<td>작성자</td>
			<td>제목</td>
			<td>답변여부</td>
			<td>생성일자</td>
		</tr>
		<c:forEach var="list" items="${data}">
		<tr>
			<td>${list.QUESTION_ID}</td>
			<td><a href="/qna/list/${list.QUESTION_ID}">${list.NICKNAME}</a></td>
			<td>${list.Q_SUBJECT}</td>
			<c:if test="${list.ANSWER!=null}">
				<td>완료</td>
			</c:if>
			<td>진행중</td>		
			<td>${list.Q_CREATE_DATE}</td>
		</tr>
		</c:forEach>
		<input type="button" value="질문등록" onclick="location.href='/qna/create'">
	</table>
</div>
<script>
//selectbox 선택한 값만 검색 - 02.07 장재호
const hidden = document.querySelector('#optionV');
function getSelect(e){
	const val = e.value;
	hidden.value = val;
}
$('input[type=button]').click(function(){
	console.log($('input[type=text]').val());
	if($('input[type=text]').val() == 'undefined' || $('input[type=text]').val() == ''){		
		alert("검색어를 입력하세요");
		return;
	}
	document.form1.submit();
});
</script>
</body>
</html>