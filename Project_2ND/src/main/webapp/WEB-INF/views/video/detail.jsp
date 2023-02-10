<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
				<source src="${data.VIDEO_URL}" type="video/mp4">
			</video>
		</div>
        <!-- video area start -->

        <!-- movie info start -->
        <div class="info_area">
            <div class="movie_info">
                <div class="info_text" id="movie_info_text">
	                <td>${data.TITLE}</td> <br><br>
					<td>줄거리 : ${data.SUMMARY}</td> <br><br>
					<td>${data.CREATE_YEAR}년 / ${data.CREATE_COUNTRY} / 관람등급 : ${data.GRADE}</td>
				</div>
            </div>
            <div class="actor_info">
                <div class="info_text" id="actor_info_text">${data.ACTOR_ID}</div>
            </div>
		</div>
        <!-- movie info start -->


        <!-- comment area start -->
        <div class="comunication_btn">
            <i class="far fa-hand-point-up comu_btn" id="subscribe"></i>
            <p>구독</p>
            <i class="far fa-thumbs-up comu_btn" id="liek"></i>
            <p>좋아요</p>
            <i class="far fa-thumbs-down comu_btn" id="bad"></i>
            <p>싫어요</p>
        </div>
        <div class="comment">
            <div class="C_review">
                <img  id="C_review_img" src="https://cdn.inflearn.com/public/main/profile/default_profile.png" alt="프로필"/>
                <div class="C_review_comment">
                    <input id="input_comment" type="search" autocomplete="off" spellcheck="false" role="combobox" placeholder="댓글창" aria-live="polite">
                    <div class="C_review_comment_btn">
                        <input type="button" value="취소" id= "" onclick='alert("정말 취소하시겠습니까?")'/> 
                        <input type="button" value="답글" id= "" onclick='alert("정말 답글을 올리겠습니까?")'/> 
                    </div>
                </div>
            </div>     
            <section class="C_review_comment_border">
                <span> 댓글 게시판영역 </span>
            </section>
        </div>
        <!-- comment area start -->
        
        
	</div>
   
</body>
</html>