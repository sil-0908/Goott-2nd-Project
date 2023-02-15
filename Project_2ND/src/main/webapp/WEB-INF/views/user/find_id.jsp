<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/user/user_find_id.css">
<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
<script src="/resources/js/user/user_find_id.js"></script>
</head>
<body>
	<header>
		<div class="header_logo">
			<img src="/resources/img/user/logo.png" alt="">
		</div>
	</header>
	<section>
		<div class="section_loginform">
			<span class="login"><span class="login_text">아이디 찾기 </span></span>         
			<form>
				<div>
					<!-- 사용자의 이메일을 입력받음 -->
					<div class="input_text">
						<input type="email" name="email" placeholder="Email" autocomplete="off" 
						class="input_size" id="input_email1">
					</div>
					<div>
						<!-- 이메일 인증 -->
						<button class="email_checkbtn">이메일 인증</button>
						<span id="email_text1" class="formSpans"></span> <!-- 이메일 인증 상태 확인 -->
						<!-- 0209 인증번호 입력 / 확인버튼 추기 -->
						<br>
						<!-- 이메일로 받은 인증번호를 사용자가 입력-->
						<input type="text" placeholder="인증번호 입력" autocomplete="off" 
						class="authorkey" maxlength="6">
						<!-- 인증번호 발급해준 것과 사용자 입력값 비교 -->
						<button class="key_submit">확인</button>
					</div>
					<!-- 최종적으로 인증을 끝낸 후 아이디를 찾기  -->
					<input type="button" value="아이디 찾기" class="login_submit_id">
					<br>
					<span id="submit_id_text" class="formSpans"></span>                    
				</div> 
			</form>
			<!-- 구분선  -->
			<span class="division_line"></span> 
	
			<span class="login"><span class="login_text">비밀번호 찾기</span></span>
			<form>
				<div>
					<!-- 사용자가 아이디를 찾게되면 여기에 사용자의 아이디가 표시  -->
					<div class="input_text">
						
						<input type="text" name="id" placeholder="ID" autocomplete="off" 
						class="input_size" id="id" disabled = "disabled">
						
					</div>
					<br>
					<!-- 사용자가 입력한 email값이 그대로 들어옴  -->
					<div class="input_text">
						<input type="email" name="email" placeholder="Email" autocomplete="off" 
						class="input_size" id="input_email2" disabled = "disabled">
					</div>
					<input type="button" value="비밀번호 찾기" class="login_submit_pw">
					<br>
					<span id="submit_pw_text" class="formSpans"></span>       
				</div> 
			</form>
		</div>
	</section>
	<footer>

	</footer>
</body>
</html>