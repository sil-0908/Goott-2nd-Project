Kakao.init('2510b2e9fc85aeb4625d6a9d9d7b881b'); //발급받은 키 중 javascript키를 사용해준다.
//console.log(Kakao.isInitialized()); // sdk초기화여부판단
//카카오로그인
function kakaoLogin() {
    Kakao.Auth.login({
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
        	  console.log(response);
        	  $.ajax({
        		  type : 'post',
        		  url : 'user/kakaoLogin',
        		  data : {"email" : response.kakao_account.email,
        			  "nickname" : response.properties.nickname},
        		  dataType : 'text',
        	  })
          },
          fail: function (error) {
            console.log(error)
          },
        })
      },
      fail: function (error) {
        console.log(error)
      },
    })
  }
