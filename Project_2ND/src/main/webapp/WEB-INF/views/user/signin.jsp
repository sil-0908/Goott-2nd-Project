<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 구글 api -->
<meta name="google-signin-client_id" content="967788525797-huq32simk5h35o6faii7nlbi86822e6l.apps.googleusercontent.com">
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
</head>
<body>
<form method="post" action="signin_check">
	이메일 : <input type="email" name="email">
	비밀번호 : <input type="password" name="password">
	<input type="submit" value="로그인">
</form>
	<a id="kakao-login-btn"></a>
    <a href="http://developers.kakao.com/logout">Logout</a> 
	<div class="g-signin2" data-onsuccess="onSignIn"></div>
	<a href="#" onclick="signOut();">Sign out</a>
	
	<script type='text/javascript'>
        //<![CDATA[
        // 사용할 앱의 JavaScript 키를 설정해 주세요.
        Kakao.init('2510b2e9fc85aeb4625d6a9d9d7b881b');
        // 카카오 로그인 버튼을 생성합니다.
        Kakao.Auth.createLoginButton({
            container: '#kakao-login-btn',
            success: function (authObj) {
                alert(JSON.stringify(authObj));
                $.ajax({
                	url : 'kakao',
                	type : 'post',
                	data : {'kakao' : JSON.stringify(authObj)},
                	dataType : 'text'
                });
            },
            fail: function (err) {
                alert(JSON.stringify(err));
            }
        });
      	//]]>
        
        function onSignIn(googleUser) {
        	  var profile = googleUser.getBasicProfile();
        	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
        	  console.log('Name: ' + profile.getName());
        	  console.log('Image URL: ' + profile.getImageUrl());
        	  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
        	}
        
          function signOut() {
            var auth2 = gapi.auth2.getAuthInstance();
            auth2.signOut().then(function () {
              console.log('User signed out.');
            });
          }
    </script>
</body>
</html>