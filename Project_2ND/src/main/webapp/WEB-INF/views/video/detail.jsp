<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/video/detail.css">
<link rel="stylesheet" href="/WEB-INF/views/common/navbar">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
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
        <!-- video area start -->

        <!-- movie info start -->
        <div class="info_area">
            <div class="movie_info">
                <div class="info_text" id="movie_info_text">
	                <p>${dto.title}</p> <br><br>
					<p>줄거리 : ${dto.summary}</p> <br><br>
					<p>${dto.create_year}년 / ${dto.country} / 관람등급 : ${dto.grade}</p>
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
        <!-- movie info start -->

        <!-- button area start -->
        <div class="comunication_btn">
            <i class="far fa-heart comu_btn" id="subscribe"></i>
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
        <div class="comment_area">
            <input id="comment_input" type="text" autocomplete="off" spellcheck="false" placeholder="댓글 달아볼테면 달아보든가ㅋ">
            <button id="comment_write_btn">작성</button>
        </div>
        <!-- comment wirte area start -->

        <hr>

        <!-- comment list area start -->
        <div class="comment_list_area">
            <table class="comment_list">
                <tr>
                    <td id="com_title">댓글제목&nbsp;&nbsp;</td>
                    <td id="com_data">댓글날짜</td>
                </tr>
                <tr>
                    <td id="com_contents">댓글내용</td>
                </tr>
            </table>
            <div class="comment_btn">
                <i class="far fa-thumbs-up comm_btn" id="like"></i>
                <p>좋아요</p>
                <i class="far fa-thumbs-down comm_btn" id="bad"></i>
                <p>싫어요</p>
                <button id="co_comment_btn">답글</button>
            </div>
        </div>
        <hr>
        <!-- comment list area start -->
        
	</div>
	
<script src="/resources/js/video/detail.js"></script>

</body>
</html>