<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="http://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
<script type="text/javascript" src="http://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<link rel="stylesheet" href="/resources/css/video/list.css">
<script src="https://kit.fontawesome.com/885ba80ba8.js" crossorigin="anonymous"></script>
</head>
<body> 
    
<!-- navbar start -->
    <nav id="navbar">
        <h1 id="logo">LOGO</h1>
          <!-- menu start -->
        <div class="menu">
            <ul class="menu_ul">
                <li class="menu_text_li" id="menu1">
                    <p>MOVIE</p>
                    <ul class="drop_menu_ul">
                        <li class="drop_menu_li">ROMANCE</li>
                        <li class="drop_menu_li">SF/FANTASY</li>
                        <li class="drop_menu_li">ACTION</li>
                        <li class="drop_menu_li">COMEDY</li>
                        <li class="drop_menu_li">HORROR</li>
                        <li class="drop_menu_li">CRIME</li>
                    </ul>
                </li>
                <li class="menu_text_li" id="menu2">
                    <p>DRAMA</p>
                    <ul class="drop_menu_ul">
                        <li class="drop_menu_li">ROMANCE</li>
                        <li class="drop_menu_li">SF/FANTASY</li>
                        <li class="drop_menu_li">ACTION</li>
                        <li class="drop_menu_li">COMEDY</li>
                        <li class="drop_menu_li">HORROR</li>
                        <li class="drop_menu_li">CRIME</li>
                    </ul>
                </li>
            </ul>
        </div>
<!-- menu end -->

<!-- search start -->
        <div class="search_area">
            <input type="search" id="search">
            <i class="fas fa-search fa-lg icons" id="search_icon"></i>
        </div>
<!-- search end -->

<!-- my info start -->
        <div class="info">
            <ul class="info_ul">
                <li class="info_li">
                    <i class="fas fa-user fa-2x icons" id="info_icon"></i>
                    <ul class="drop_menu_ul">
                        <li class="drop_menu_li">내채널</li>
                        <li class="drop_menu_li">회원정보수정</li>
                        <li class="drop_menu_li">Language</li>
                        <li class="drop_menu_li">고객센터</li>
                        <li class="drop_menu_li">로그아웃</li>
                    </ul>
                </li>
            </ul>
        </div>
<!-- my info end -->


    </nav>
   
<!-- navbar end -->
        

      
 
  
<!-- main video start -->
    
    
  
    <div id="main_video">  
     <video muted autoplay loop id="bg_video">
      <c:forEach var="row" items="${data}"  begin="4" end="4" step="1" varStatus="status">
         <source src="${row.VIDEO_URL} " type="video/mp4">
       </c:forEach> 
     </video>
    </div>
  
<!-- main video end -->



   <div id="section_all">
  


<!-- section2 start -->
     <h1 class="section_main_text" id="main_text">영화</h1>
      <div class="section">
       <div class="slider"> 
        <c:forEach var="row" items="${data}" begin="0" end="17">
	      <c:if test="${row.CATEGORY_ID == '1'}"> 
	       <div class="conta">
			<img src="${row. IMAGE_URL}" alt="Image not found" onclick="location.href='/video/detail?videoId=' + ${row.VIDEO_ID}"  >
		   </div>
		  </c:if> 
	   </c:forEach>
	   </div>
	  </div>
	     
       
       
<!-- section2 end -->

   

<!-- section3 start -->
        <h1 class="section_main_text">애니메이션</h1>
        <div class="section">
         <div class="slider"> 
           <c:forEach var="row" items="${data}">
	        <c:if test="${row.CATEGORY_ID == '3'}">
		     <div class="conta">
			  <img src="${row.IMAGE_URL}" alt="Image not found" onclick="location.href='/video/detail?videoId=' + ${row.VIDEO_ID}">
			 </div>
			</c:if>
	       </c:forEach>
	     </div>
        </div>
      </div> 
<!-- section3 end -->
          
     

<!-- adv area start -->
   <!--  <div id="adv_area">
        <p>두둥 광고 </p>
    </div> -->
<!-- adv area end -->

<footer>

<!-- footer start -->
   <!--  <div id="f_Con1">
	<div id="f_Con2">	
		<h1>김범수</h1><span>보고싶다</span>
	</div>
	<div id="map"></div>
</div> -->
<!-- footer end -->
    
</footer>


<script >

<!-- 이미지 슬라이드  -->
   $('.slider').slick({
	  
	  slidesToShow:6,
	  slidesToScroll:6,	 
	  prevArrow: "<button type='button' class='slick-arrow'><i class='fa-solid fa-angle-left'></i></button>",
	  nextArrow: "<button type='button' class='slick-next'><i class='fa-solid fa-angle-right'></i></button>",
	});
  
const search_input = document.querySelector('#search'),
search_i = document.querySelector('#search_icon');
	
  search_i.addEventListener('click', function() {
	     search_input.classList.toggle("view");
	  });
	

  
/* 	   
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
   mapOption = { 
       center: new kakao.maps.LatLng(37.48195693074062, 126.89815006835722), // 지도의 중심좌표
       level: 2 // 지도의 확대 레벨
   };
   
var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

//일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
var mapTypeControl = new kakao.maps.MapTypeControl();

//지도에 컨트롤을 추가해야 지도위에 표시됩니다
//kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

//지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

var iwContent = '<div style="padding:5px;">구트아카데미</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
   iwPosition = new kakao.maps.LatLng(37.48195693074062, 126.89815006835722), //인포윈도우 표시 위치입니다
   iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

//인포윈도우를 생성하고 지도에 표시합니다
var infowindow = new kakao.maps.InfoWindow({
   map: map, // 인포윈도우가 표시될 지도
   position : iwPosition, 
   content : iwContent,
   removable : iwRemoveable
});
     
//아래 코드는 인포윈도우를 지도에서 제거합니다
//infowindow.close();        

//아래 코드는 지도 위의 마커를 제거하는 코드입니다
//marker.setMap(null);   
    */
   
</script>
  