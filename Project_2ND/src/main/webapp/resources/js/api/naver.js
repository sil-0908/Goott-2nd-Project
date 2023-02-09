const naverLogin = new naver.LoginWithNaverId({
	clientId: "XMsvnx3R1_T_0aXB93xf",
	callbackUrl: "http://localhost:8080/user/naverLogin",
	loginButton: {color: "green", type: 1, height: 20}
});
naverLogin.init(); // 로그인 설정

$('#naverIdLogin').on('click',(function(){	
	
   naverLogin.getLoginStatus(function(status) {
      if (status) {
         const email=naverLogin.user.getEmail();
         const nickName=naverLogin.user.getNickName();
         const birthday=naverLogin.user.getBirthday();
         
         console.log(naverLogin);
      
         //닉네임을 선택하지 않으면 선택창으로 돌아갑니다.
         if(nickName===null||nickName===undefined ){ 
            alert("별명이 필요합니다. 정보제공을 동의해주세요.");
            naverLogin.reprompt(); 
            return;  
         }         
         $.ajax({
            url : 'naverLogin',
            data : {"email" : email, "nickname" : nickName},
            type : 'post',
            dataType : 'text',
            success:function(data){
           	 	alert(data);
           	 	return;
            }
         })
         
      }
   });
}));