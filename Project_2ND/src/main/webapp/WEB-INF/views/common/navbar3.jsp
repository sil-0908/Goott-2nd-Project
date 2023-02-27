<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/common/navbar3.css">
    <!-- Fontawesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />

</head>
<body>
<!-- 세션에 아이디 값을 가지고 있을 경우 (로그인이 되어있을 경우)와 없을 때 넘어가는 경우가 다르게 설정  0227 장재호 -->
<input id="sessionID" type="hidden" value="${sessionScope.user_id}">
<!-- navbar start -->
    <nav id="navbar">
        <div class="logo">
            <img src="/resources/img/user/logo.png" id="logo" onclick="back()" alt="">
        </div>

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
<script src="/resources/js/common/nav.js"></script>
</body>
</html>