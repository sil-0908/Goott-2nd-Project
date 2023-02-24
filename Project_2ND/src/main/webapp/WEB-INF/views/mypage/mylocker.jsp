<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="http://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
<script type="text/javascript" src="http://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<link rel="stylesheet" href="/resources/css/mypage/mylocker.css">
<script src="https://kit.fontawesome.com/885ba80ba8.js" crossorigin="anonymous"></script>
</head>
<body>
	<!-- 내보관함 리스트 -02.18 김범수 -->
	<!-- 보관함 리스트 영역-->
	<div class="section">
		<!-- 내보관함 text -->
		<h1 class="mylocker_text">내보관함</h1>
		<!-- 내보관함 슬라이드 - 양옆 버튼 추가 + 버튼 누르면 케러셀처럼 넘어감-->
		<div class="slider">
			<!-- 내보관함 리스트 출력 영역-->
			<c:forEach var="movie" items="${dto}">
				<div class="video_div">
					<a href="/video/detail?video_id=${movie.video_id}"> <img src="${movie.image_url}" alt="Image not found"></a>
				</div> 
			</c:forEach>
		</div>
	</div>  
		
<script src="/resources/js/mypage/mylocker.js"></script>
</body>
</html>