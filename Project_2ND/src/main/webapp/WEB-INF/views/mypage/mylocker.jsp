<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/mypage/mylocker.css">
<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
</head>
<body>
	<!-- 내보관함 리스트 -02.18 김범수 -->
	<!-- 보관함 리스트 영역-->
	<div class="hide">
		<!-- 내보관함 text -->
		<h1 class="section_main_text">내보관함</h1>

		<div class="section">
			<!-- 내보관함 슬라이드 -->
			<div class="slider"> 
				<c:forEach var="movie" items="${dto}">
					<div class="conta">
						<a href="/video/detail?video_id=${movie.video_id}"> <img src="${movie.image_url}" alt="Image not found"></a>
					</div> 
				</c:forEach>
			</div>
		</div>
	</div>  
		
<script src="/resources/js/mypage/mylocker"></script>
</body>
</html>