<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<link href="/resources/css/user/user_mydetail.css" rel="stylesheet">
</head>
<body>

<form name="form1" method="post" action="info_modify"> <!-- "info_modify"페이지에 데이터 전송 -->

	
		<!-- 수정가능한 페이지로 이동   -->
		<button type="button" id="btnWrite" onclick="location.href='user/info_modify'">수정하기</button>
		<button type="button" id="">비밀번호 변경</button> <!-- ajax로 변경가능하도록 설계 예정 -->
	
	<ul>
		<li>아이디 : 
			<input type="text" name="id" value="${data.id}" disabled>
		</li>
		<li>이메일 : 
			<input type="email" name="email" value="${data.email}" disabled>
		</li>
		<li>닉네임 : 
			<input type="text" name="nickname" value="${data.nickname}" disabled>
		</li>	
		<li>휴대전화 : 
			<input type="text" name="phone_num" value="${data.phone_num}" disabled>
		</li>
	</ul>
	
</form>

	<script src="/resources/js/user/user_mydetail.js"></script>
</body>
</html>