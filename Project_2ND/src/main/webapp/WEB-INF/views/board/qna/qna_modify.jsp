<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/board/qna_create.css">
</head>
<body>
<%@ include file="/WEB-INF/views/common/navbar.jsp" %>
	<!-- navArea : navbar 여백 잡는 공간 -->
	<div id="navArea"></div>
	
	<form name="form1" method="post">
		<!-- 전체 컨테이너 -->
		<div id="main_Con">
			<div id="title_Con"> 
				<h1>제목</h1>
				<textarea id="title" name="q_subject"></textarea>
			</div>
			<div id="content_Con">
				<h1>내용</h1>
				<textarea id="content" name="q_content"></textarea>
			</div>
		</div>
		<input type="button" value="등록" onclick="qModify()">
	</form>
</body>
<script src="/resources/js/board/qna_modify.js"></script>
</html>