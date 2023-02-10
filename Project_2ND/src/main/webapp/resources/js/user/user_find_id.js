var code = ""; // 이메일 전송 인증번호 저장할 공간 변수로
var email= "";
var id = "";

/////////////// 이메일 인증 - 0209 김범수 ///////////
$(function(){
	// 이메일 인증 버튼 클릭 이벤트
	$('.email_checkbtn').click(function(e) {
		// 시스템 자체의 submit을 막음
		e.preventDefault();
		
		// 사용자가 입력한 이메일
		email = $("input[type=email]").val();
		
		var inputResult = $('#email_text1'); // 인증 상태 메세지
		
		if(email == null || email == ""){ // 이메일 값이 없는 것을 방지
			inputResult.html('이메일을 입력해주세요');
			$("input[type=email]").focus(); 
			return;
		}
		else if(!email.match('@')){ // 입력받은 이메일에 @없는 걸 방지
			inputResult.text("올바른 이메일 형태를 입력해주세요");
			$("input[type=email]").focus();
			return;
		}
		else{
			inputResult.text("");
		}
		
		// ajax로 통해 컨트롤러(mailCheck메소드)로 email의 정보를 넘김 / 넘기는게 성공하면 인증번호 데이터를 code에 담음
		$.ajax({
			type : "GET",
			url : "mailCheck?email=" + email, // 해당 메소드에 email값을 보냄
			success:function(data){
				code = data; // 인증 번호가 담기는 구역
			} // success end
		}); // ajax end
	}); //event function end
}); // function end


$(function(){
	// 인증번호 확인 버튼 클릭시 이벤트
	$('.key_submit').click(function(e){
		e.preventDefault(); // 키에 대한 submit을 막아놓음
		
		var inputCode = $('.authorkey').val(); //사용자가 인증번호를 입력하는 input의 value
		var inputResult = $('#email_text1'); // 인증 상태 메세지
		
		// 사용자가 입력하지 않은경우
		if(inputCode === null || inputCode === ""){
			inputResult.html("인증번호를 입력해주세요.");
			return;
		}
		// 사용자가 입력한 인증번호와 발급한 인증번호가 맞을 경우
		else if(inputCode == code){
			inputResult.html("인증번호가 일치합니다.");
			
		}else{// 사용자가 입력한 인증번호와 발급한 인증번호가 일치하지 않을 경우
			inputResult.html("인증번호를 다시 확인 해주세요.");
			return;
		}
	});
});

////////////////02.10 - 아이디 찾기 //////////
$(function(){
	$('.login_submit_id').click(function(){
		
		if(email != null){ // 위의 ajax에서 이메일을 제대로 받아온 경우
			$.ajax({
				url : 'findid', // 위의 ajax에서 이메일을 제대로 받아온 경우
				dataType : 'text',
				data : {"email" : email},
				type : 'post',
				success:function(id) {
					if(email == null || email == ""){ //이메일을 입력하지 않을 경우
						$('#submit_id_text').html('이메일 인증을 먼저해주세요');
						return;
					}	
					else if(email != null && email.match('@')){// 정상작동일 경우
						$('#id').attr('value', id);
						$('#submit_id_text').html('아이디는'+id+'입니다');
						$('#input_email2').attr('value', email);
						
					}
					else{
						$('#submit_id_text').html('');
						return;
					}
				},
				error : function() {
					$('#submit_text1').html('등록된 정보가 없습니다');
				}//error end		
			})//ajax end
		}//success end
	})// ajax end
})


////////// 비밀번호 찾기 - 02.10 김범수
$(function(){ 
    $(".login_submit_pw").click(function(){
    	
    	var id_pw = $('#id').val();
    	var allData = {'email' : email, 'id' : id_pw}
    	console.log(email);
		console.log(id_pw);
		console.log(allData);
		
    	if(id_pw == null || id_pw == ""){ // 아이디를 입력하지 않은 경우
    		$('#submit_pw_text').html('아이디 찾기를 먼저 진행해주세요');
    		return;
    	}else{
    		$('#submit_pw_text').html('');
    	}
    	$.ajax({
    		url : 'findpw',
    		data : allData,
    		type : 'post',
    		success : function() {
    			
				document.form1.action = "";
			}
    		
    	})

    });
});