<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
</head>
<body> 

 
 <i class="fa-solid fa-angle-right"></i>

<header>

<!-- navbar start -->
    <nav id="navbar">
        <h1 id="logo">LOGO</h1>
    </nav>
<!-- navbar end -->
        
</header>
      
 
  
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
     <h1 class="section_main_text">영화</h1>
      <div class="section">
       <div class="slider"> 
        <c:forEach var="row" items="${data}" begin="0" end="17">
	      <c:if test="${row.IMAGE_URL != null}">
	       <div class="conta">
			<img src="${row.IMAGE_URL}" alt="Image not found" onclick="location.href='/video/detail?videoId=' + ${row.VIDEO_ID}"  >
		   </div>
		  </c:if>
	   </c:forEach>
	   </div>
	  </div>
	     
       
       
<!-- section2 end -->

   

<!-- section3 start -->
        <h1 class="section_main_text">드라마</h1>
        <div class="section">
         <div class="slider"> 
           <c:forEach var="row" items="${data}">
	        <c:if test="${row.IMAGE_URL != null}">
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
    <div id="footer">
        <h1></h1>
    </div>
<!-- footer end -->
    
</footer>

<script >

<!-- 이미지 슬라이드  -->
   $('.slider').slick({
	  
	  slidesToShow: 6,
	  slidesToScroll:6,	 
	  prevArrow : "<button type='button' class='slick-prev'></button>",
	  nextArrow : "<button type='button' class='slick-next'></button>",	
	});
   
</script>
  


</body>
</html>
