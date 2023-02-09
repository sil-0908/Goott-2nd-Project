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
			<span class="login"><span class="login_text">아이디 찾기</span></span>         
			<form>
				<div>
					<div class="input_text">
						<input type="email" name="email" placeholder="Email" autocomplete="off" 
						class="input_size" id="email_id">
					</div>
					<div>
						<button class="email_checkbtn">이메일 인증</button>
						<span id="email_text1" class="formSpans"></span>
					</div>
					<input type="button" value="아이디 찾기" class="login_submit_id">                    
				</div> 
			</form>
			<span class="division_line"></span> 

			<span class="login"><span class="login_text">비밀번호 찾기</span></span>
			<form>
				<div>
					<div class="input_text">
						<input type="text" name="id" placeholder="ID" autocomplete="off" class="input_size">
						<span id="id" class="formSpans"></span>
					</div>
					<div class="input_text">
						<input type="email" name="email" placeholder="Email" autocomplete="off" 
						class="input_size" id="email_pw">
					</div>
					<div>
						<button class="email_checkbtn">이메일 인증</button>
						<span id="email_text2" class="formSpans"></span>
					</div>
					<input type="button" value="비밀번호 찾기" class="login_submit_pw">
				</div> 
			</form>
		</div>
	</section>
	<footer>

	</footer>
</body>
</html>