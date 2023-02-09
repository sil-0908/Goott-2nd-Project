<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/video/detail.css">
<title>video detail</title>
</head>
<body>

	<div class="video_all">
		<!-- sectionA(영화/드라마 포스터가 있을 영역) start -->
		<div class="video_area">
			<video controls autoplay loop class="video">
				<source src="${data.VIDEO_URL}" type="video/mp4">
			</video>
		</div>
        <!-- sectionA end -->

        <!-- sectionB(영화/드라마에 대한 설명 & 출연진 / 장르) start -->        
        <div class="sectionB">
            <div class="storyDescription">영화/드라마에 대한 설명</div>
            <div class="storyinfo">출연진 / 장르</div>
		</div>
        <!-- sectionB end -->


        <!-- sectionC(구독 & 댓글추가 영역) start -->
        <div class="sectionC">
            <!-- section start -->
            <section>
                <div class="btn">
                    <button id="C_btn_subscribe">구독</button>
                    <button id="C_btn_good">좋아요</button>
                    <button class="C_btn_bad">나빠요</button>
                </div>
            </section>        
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
            <!-- section end -->
        </div>
        <!-- sectionC end -->



        <!-- sectionD(관련 재생 목록 (*캐러셀로 구현*)) start -->
        <div class="sectionD">
            <div class="sectionD_btn_img">
                <img id="carousel_before_btn" src="https://cdn.inflearn.com/public/main/profile/default_profile.png" alt="프로필"/>
                <div class="carousel_img">
                    <img src="https://cdn.inflearn.com/public/main/profile/default_profile.png" alt="프로필"/>
                    <img src="https://cdn.inflearn.com/public/main/profile/default_profile.png" alt="프로필"/>
                    <img src="https://cdn.inflearn.com/public/main/profile/default_profile.png" alt="프로필"/>
                </div>
                <img id="carousel_after_btn" src="https://cdn.inflearn.com/public/main/profile/default_profile.png" alt="프로필"/>
            </div>                    
        </div>
    <!-- sectionD end -->
  </div>
    
    
    
   
   
   
   
   
   
</body>
</html>