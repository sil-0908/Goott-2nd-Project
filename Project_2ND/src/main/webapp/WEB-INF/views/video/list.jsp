<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/video/list.css">
</head>
<body> 
  
	<!-- main video start -->
    
	<div id="main_video">
		<video muted autoplay loop id="bg_video">
		<c:forEach var="row" items="${data}"  begin="4" end="4" step="1" varStatus="status">
			<source src="${row.VIDEO_URL} " type="video/mp4">
		</c:forEach> 
		</video>
	</div>
  
	<!-- main video end -->

	<hr id="main_hr">
	<div id="section_all">
	<hr>
		<!-- section2 start -->
        <h1 class="section_main_text">영화</h1>
        <div class="section">
	        <c:forEach var="row" items="${data}" begin="6" end="17">
				<c:if test="${row.IMAGE_URL != null}">
					<img src="${row.IMAGE_URL}" alt="Image not found" onclick="location.href='/video/detail?videoId=' + ${row.VIDEO_ID}">
				</c:if>
		   </c:forEach>
        </div>
		<!-- section2 end -->

    <hr>

		<!-- section3 start -->
		<h1 class="section_main_text">드라마</h1>
		<div class="section">
			<c:forEach var="row" items="${data}">
				<c:if test="${row.IMAGE_URL != null}">
					<img src="${row.IMAGE_URL}" alt="Image not found" onclick="location.href='/video/detail?videoId=' + ${row.VIDEO_ID}">
				</c:if>
			</c:forEach>
		</div>
<!-- section3 end -->
	</div>

<!-- adv area start -->
	<div id="adv_area">
		<p>두둥 광고 </p>
	</div>
<!-- adv area end -->
 


</body>
</html>