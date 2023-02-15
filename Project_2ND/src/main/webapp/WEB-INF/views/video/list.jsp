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
                 <li class="drop_menu_li" onclick="toggleSubMenu('actionSubMenu')">ACTION</li>
                 <li class="drop_menu_li" onclick="toggleSubMenu('dramaSubMenu')">DRAMA</li>
                 <li class="drop_menu_li" onclick="toggleSubMenu('fantasySubMenu')">FANTASY</li>
                 <li class="drop_menu_li" onclick="toggleSubMenu('sfSubMenu')">SF</li>
                 <li class="drop_menu_li" onclick="toggleSubMenu('crimeSubMenu')">CRIME</li>
               </ul>
                </li>
                <li class="menu_text_li" id="menu2" onclick="ani_q()"> 
                    <p>애니메이션</p>    
                    <!-- <ul class="drop_menu_ul">
                        <li class="drop_menu_li">ROMANCE</li>
                        <li class="drop_menu_li">SF/FANTASY</li>
                        <li class="drop_menu_li">ACTION</li>
                        <li class="drop_menu_li">COMEDY</li>
                        <li class="drop_menu_li">HORROR</li>
                        <li class="drop_menu_li">CRIME</li>
                    </ul> -->
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
			<c:forEach var="list" items="${dto}"  begin="4" end="4" step="1" varStatus="status">
				<source src="${list.video_url} " type="video/mp4">
			</c:forEach> 
		</video>
	</div>
  
<!-- main video end -->

	<div id="section_all">
	 
	<!-- movie category -->
		<div class="hide">
			<h1 class="section_main_text">영화</h1>
			<div class="section">
				<div class="slider"> 
					<c:forEach var="movie" items="${dto}">
						<c:if test="${movie.category_id == '1'}">
							<div class="conta">
								<a href="/video/detail?video_id=${movie.video_id}"> <img src="${movie.image_url}" alt="Image not found"></a>
							</div>
						</c:if> 
					</c:forEach>
				</div>
			</div>
		</div>  
		
		<!-- action genre -->
		<div id="actionSubMenu" class="sub-menu" style="display:none">
			<h1 class="section_main_text">액션</h1>
			<div class="section">
				<c:forEach var="row" items="${dto}">
					<c:if test="${row.genre_id == '1'}"> 
						<div class="conta">
							<a href="/video/detail?video_id=${row.video_id}"> <img src="${row.image_url}" alt="Image not found"></a>
	                     </div>
					</c:if> 
				</c:forEach>
			</div> 
		</div>    
		<!-- action genre end -->       
	                         
		<!-- drama genre -->
		<div id="dramaSubMenu" class="sub-menu" style="display:none">
			<h1 class="section_main_text">드라마</h1>
			<div class="section">
				<c:forEach var="row" items="${dto}">
					<c:if test="${row.genre_id == '2'}"> 
						<div class="conta">
							<a href="/video/detail?video_id=${row.video_id}"> <img src="${row.image_url}" alt="Image not found"></a>
						</div>
					</c:if> 
				</c:forEach>
			</div> 
		</div>   
		<!-- drama genre end -->        
	                
		<!-- fantasy genre -->
		<div id="fantasySubMenu" class="sub-menu" style="display:none">
			<h1 class="section_main_text">판타지</h1>
			<div class="section">
				<c:forEach var="row" items="${dto}">
					<c:if test="${row.genre_id == '3'}"> 
						<div class="conta">
							<a href="/video/detail?video_id=${row.video_id}"> <img src="${row.image_url}" alt="Image not found"></a>
						</div>
					</c:if> 
				</c:forEach>
			</div> 
		</div>     
		<!-- fantasy genre end -->
	                 
		<!-- SF genre  -->
		<div id="sfSubMenu" class="sub-menu" style="display:none">
			<h1 class="section_main_text">SF</h1>
			<div class="section">
				<c:forEach var="row" items="${dto}">
					<c:if test="${row.genre_id == '4'}"> 
						<div class="conta">
							<a href="/video/detail?video_id=${row.video_id}"> <img src="${row.image_url}" alt="Image not found"></a>
						</div>
					</c:if> 
				</c:forEach>
			</div> 
		</div>          
		<!-- SF genre end  -->      
	               
		<!-- crime genre -->
		<div id="crimeSubMenu" class="sub-menu" style="display:none">
			<h1 class="section_main_text">범죄</h1>
			<div class="section">
				<c:forEach var="row" items="${dto}">
					<c:if test="${row.genre_id == '5'}"> 
						<div class="conta">
							<a href="/video/detail?video_id=${row.video_id}"> <img src="${row.image_url}" alt="Image not found"></a>
						</div>
					</c:if> 
				</c:forEach>
			</div> 
		</div>           
		<!-- crime genre end -->    
	                      
	<!-- movie category end -->

		<!-- animation category -->
		<div class="hide">
			<h1 class="section_main_text">애니메이션</h1>
			<div class="section">
				<div class="slider"> 
					<c:forEach var="row" items="${dto}">
						<c:if test="${row.category_id == '3'}">
							<div class="conta">
								<a href="/video/detail?video_id=${row.video_id}"> <img src="${row.image_url}" alt="Image not found"></a>
							</div>
						</c:if>
					</c:forEach>
				</div>
		</div>
		<!-- animation section end -->
		</div> 
	</div>
	<!-- animation category end -->
          
     

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


<script src="/resources/js/video/list.js"></script>

</body>
</html>
