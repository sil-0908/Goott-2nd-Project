const naverLogin = new naver.LoginWithNaverId({
	clientId: "XMsvnx3R1_T_0aXB93xf",
	callbackUrl: "http://localhost:8080/naverLogin",
	loginButton: {color: "green", type: 2, height: 40}
});
 naverLogin.init(); // 로그인 설정
 
naverLogin.getLoginStatus(function (status) {
	if (status) {
		const email=naverLogin.user.getEmail();
		const nickName=naverLogin.user.getNickName();
		const birthday=naverLogin.user.getBirthday();
	
		//닉네임을 선택하지 않으면 선택창으로 돌아갑니다.
		if(nickName===null||nickName===undefined ){ 
			alert("별명이 필요합니다. 정보제공을 동의해주세요.");
			naverLogin.reprompt(); 
			return ;  
		}else{			

			
		}
	}
});