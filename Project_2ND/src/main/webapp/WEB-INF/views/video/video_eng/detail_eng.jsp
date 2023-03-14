<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/video/video_eng/detail_eng.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" />
<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
<title>video detail</title>
</head>
<body>
<div id="navbar">
<%@ include file="/WEB-INF/views/common/video_detail_navbar.jsp" %>
</div>

	<div class="video_all">
	
        <!-- video area start -->
		<div class="video_area">
			<video controls autoplay loop class="video"  height="800" width="1600">
				<source src="${dto_eng.video_url}" type="video/mp4">
			</video>
		</div>
        <!-- video area end -->

        <!-- movie info start -->
        <div class="info_area">
            <div class="movie_info">
                <div class="info_text" id="movie_info_text">
	                <p>${dto_eng.title}</p> <br><br>
					<p class="movie_summary">summary : ${dto_eng.summary}</p> <br><br>
					<p>${dto_eng.create_year} / ${dto_eng.create_country} / rating : ${dto_eng.grade}</p>
				</div>
            </div>
            <div class="actor_info">     
                	<div class="info_text" id="actor_info_text">
                		<td>main actor</td> <br><br>
                		<c:forEach var="dto" items="${detail_eng}">
                			<p>${dto.actor}</p> <br>
                		</c:forEach>
                	</div>
            </div>
		</div>
        <!-- movie info end -->

        <!-- button area start -->
        <div class="comunication_btn">
      
      		<!-- 보관함 구현을 위한 정보를 전송 02.16 김범수 -->
      		<input type="hidden" id="title_data" value="${dto_eng.title}"><!-- 찜하기 버튼 value - 02.28 김범수 -->
      		<c:set var="rental_id" value="${rental_id}"/>
			<c:choose>
				<c:when test="${rental_id ne null}"> <!-- rental_id가 null값이 아닐 경우 -->
        			<i class="fas fa-heart comu_btn" id="subscribe"></i>
				</c:when>
				<c:otherwise> <!-- rental_id가 null일 경우 -->
					<i class="far fa-heart comu_btn" id="subscribe"></i>
				</c:otherwise>
     		</c:choose>
            <p class="text">Wish</p>
            
            <c:choose>
            	<c:when test="${v_inter_info.v_idx ne '0' and v_inter_info.like ne '0'}">
            		<i class="fas fa-thumbs-up comu_btn" id="video_like"></i>
            	</c:when>
            	<c:otherwise>
            		<i class="far fa-thumbs-up comu_btn" id="video_like"></i>
            	</c:otherwise>
            </c:choose>
            <p class="text">like</p>
            <c:choose>
            	<c:when test="${v_inter_info.v_idx ne '0' and v_inter_info.unlike ne '0'}">
            		<i class="fas fa-thumbs-down comu_btn" id="video_bad"></i>
            	</c:when>
            	<c:otherwise>
            		<i class="far fa-thumbs-down comu_btn" id="video_bad"></i>
            	</c:otherwise>
            </c:choose>            
            <p class="text">unlike</p>            
            <i class="fa-solid fa-coins comu_btn" id="payment"></i>
            <p class="text">payment</p>
        </div>
        <!-- button area end -->

        <!-- comment wirte area start -->
        <form name="comt_write" method="post">
        	<c:if test="${sessionScope.nickname != null}">
	        	<input type="hidden" id="v_input" name="video_id" value="${dto.video_id}">
				<div class="comment_area">
					<input id="comment_input" type="text" autocomplete="off" spellcheck="false" name="commentary" placeholder="댓글을 작성해 주세요">
					<input id="comment_write_btn" type="button" value="write">
				</div>
			</c:if>
        </form>
        <!-- comment wirte area end -->

        <hr class="comt_list_hr">
        
        <!-- comment list area start -->
		<form name="comt_list" method="post">
			<div class="comment_list_area">
				<table class="comment_list">
					<c:forEach var="comt" items="${replyList}">
						<c:if test="${comt.depth=='0'}">
							<tr class="com_tr">
								<td class="com_title text">
								<!-- 댓글 이미지 작업 - 03.06 김범수 -->
								<div class="user_img_area">
									<c:choose>
										<c:when test="${comt.img != null && comt.img != ''}">
											<img src="${comt.img}" class="com_img">
										</c:when>
										<c:when test="${comt.img == null}">
											<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxmp7sE1ggI4_L7NGZWcQT9EyKaqKLeQ5RBg&usqp=CAU" class="default_img">
										</c:when>
									</c:choose>
								</div>
								<!-- com_name 클래스 부여 - 03.07 김범수 -->
								${comt.nickname}&nbsp;&nbsp;<fmt:formatDate value="${comt.create_date}" pattern="yyyy-MM-dd a HH:mm:ss" /></td>
							</tr>
							<tr>
								<td class="com_contents text">${comt.commentary}</td>
							</tr>
							<td class="comt_btn_td">
								<div class="comment_btn">
									<%-- 값을 못받아와서 페이지 내에 hidden으로 값 넣어줌 --%>
									<input type="hidden" id="v_input" name="video_id" value="${dto.video_id}">
									<input type="hidden" class="c_id_input" name="comment_id" value="${comt.comment_id}">
									<input type="hidden" class="c_pid_input" name="pid" value="${comt.pid}">
									<c:if test="${sessionScope.nickname != null}">
										<input type="button" class="cocom_write_btn" value="create reply">
									</c:if>
									<input type="button" class="cocom_list_btn" value="show reply">
									<c:if test="${sessionScope.nickname == comt.nickname}">
										<input type="button" class="comment_update" value="edit">
										<input type="button" class="comment_delete" value="delete">
									</c:if>
								</div>
								<%-- 답글 작성 자리 --%>
								<div class="cocomt_insert"></div>
								<%-- 댓글 수정 자리 --%>
								<div class="comt_edit"></div>
								<%-- 답글 목록 자리 --%>
								<div class="co_comment_list"></div>
								<hr id="com_list_hr">
							</td>
						</c:if>
					</c:forEach>
				</table>
	        </div>
        </form>
        <!-- comment list area end -->
        <hr>
	</div>

<script src="/resources/js/video/video_eng/detail_eng.js"></script>
<script>
// js에서 sessionScope 값에 대해 불러오질 못하고 c태그 자체를 기능이 아닌 text로 인식하여 기능이 작동하지 않아 jsp 내에 전역으로 변수생성
var session = '<c:out value="${sessionScope.nickname}"/>';
</script>
</body>
</html>