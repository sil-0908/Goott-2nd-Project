<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
<script>
	const naverLogin = new naver.LoginWithNaverId({
		clientId: "XMsvnx3R1_T_0aXB93xf",
		callbackUrl: "http://localhost:8080/user/naverLogin",
		isPopup: false, /* 팝업을 통한 연동처리 여부 */
	    callbackHandle: true
	});

	naverLogin.init();/* 설정정보를 초기화하고 연동을 준비 */

	window.addEventListener('load', function () {	
		naverLogin.getLoginStatus(function(status) {
			if (status) {
				const email = naverLogin.user.getEmail();
				const nickName = naverLogin.user.getNickName();
				const id = naverLogin.user.getId();
				
				var pop = window.open("about:blank","content","width=300,height=300");
				
				$.ajax({
					type : 'post',
					url : 'user/naverSaved',
					data : {"email" : email, "nickname" : nickName, "id" : id},
					dataType : 'text',
					success: function(result) {
		                if(result=='ok') {
		                    alert('가입페이지로 이동합니다.')
		                    pop.location.href = "user/signup" /*팝업 경로*/
		                } else if(result=='no') {
		                    alert('실패')
		                }
		            },
		            error: function(result) {
		                console.log('오류 발생')
		            }
				})
		         
			} else alert("콜백 실패");
			
		});
	});
</script>
</body>
</html>