<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/video/detail.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" />
<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
<title>video detail</title>
</head>
<body>

	<div class="video_all">
	
        <!-- video area start -->
		<div class="video_area">
			<video controls autoplay loop class="video">
				<source src="${dto.video_url}" type="video/mp4">
			</video>
		</div>
        <!-- video area end -->

        <!-- movie info start -->
        <div class="info_area">
            <div class="movie_info">
                <div class="info_text" id="movie_info_text">
	                <p>${dto.title}</p> <br><br>
					<p>줄거리 : ${dto.summary}</p> <br><br>
					<p>${dto.create_year}년 / ${dto.create_country} / 관람등급 : ${dto.grade}</p>
				</div>
            </div>
            <div class="actor_info">     
                	<div class="info_text" id="actor_info_text">
                		<td>주연배우</td> <br><br>
                		<c:forEach var="dto" items="${detail}">
                			<p>${dto.actor}</p> <br>
                		</c:forEach>
                	</div>
            </div>
		</div>
        <!-- movie info end -->

        <!-- button area start -->
        <div class="comunication_btn">
      
      		<!-- 보관함 구현을 위한 정보를 전송 02.16 김범수 -->
      		<c:set var="rental_id" value="${rental_id}"/>
			<c:choose>
				<c:when test="${rental_id ne null}"> <!-- rental_id가 null값이 아닐 경우 -->
        			<i class="fas fa-heart comu_btn" id="subscribe"></i>
				</c:when>
				<c:otherwise> <!-- rental_id가 null일 경우 -->
					<i class="far fa-heart comu_btn" id="subscribe"></i>
				</c:otherwise>
     		</c:choose>
            <p>찜하기</p>
            <i class="far fa-thumbs-up comu_btn" id="like"></i>
            <p>좋아요</p>
            <i class="far fa-thumbs-down comu_btn" id="bad"></i>
            <p>싫어요</p>
            <i class="fa-solid fa-coins comu_btn" id="payment"></i>
            <p>결제</p>
        </div>
        <!-- button area end -->

        <!-- comment wirte area start -->
        <form name="comt_write" method="post">
        	<input type="hidden" id="v_input" name="video_id" value="${dto.video_id}">
	        <div class="comment_area">
	            <input id="comment_input" type="text" autocomplete="off" spellcheck="false" name="commentary" placeholder="댓글을 작성해 주세요">
	            <input id="comment_write_btn" type="button" value="작성하기">
	        </div>
        </form>
        <!-- comment wirte area end -->

        <hr>
        
        <!-- comment list area start -->
        <div class="comment_list_area">
			<c:forEach var="comt" items="${c_dto}">
				<table class="comment_list">
					<tr>
						<td id="com_title">${comt.nickname}&nbsp;&nbsp;</td>
						<td id="com_data"><fmt:formatDate value="${comt.create_date}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
					<tr>
						<td id="com_contents">${comt.commentary}</td>
					</tr>
				</table>
					<div class="comment_btn">
		                <i class="far fa-thumbs-up comm_btn" id="like"></i>
		                <p>좋아요</p>
		                <i class="far fa-thumbs-down comm_btn" id="bad"></i>
		                <p>싫어요</p>
		                <button id="co_comment_btn">답글</button>
					</div>
			</c:forEach>
        </div>
        <hr>
        <!-- comment list area end -->
<%--  --%>
	</div>
	
<script src="/resources/js/video/detail.js"></script>
</body>
</html>