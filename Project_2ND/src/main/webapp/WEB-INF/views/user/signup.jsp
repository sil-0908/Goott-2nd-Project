<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<link href="/resources/css/user/signup.css" rel="stylesheet">
</head>
<body>

<div class="container_j"> 
	<div class="background_j">
		<div class="header_j">
			<div class="headerLogo_j">LOGO</div>
		</div> <!-- <div id="header_j"> end -->
		
		
		<div id="mainDiv_j">
	        <div id="viewDiv_j">
				<span id="signUpText_j">LOGO 회원가입</span>
	             
		            <!-- form start  -->
					<form method="post" >
		                <div id="viewInput_j">
		                
		                    <div class="wrapInput">
		                        <input type="email" name="email" id="email" class="formInputs" placeholder=". . .@. . ." autocomplete="on">
		                       	<div id="emailcheck_j">
			                        <button type="button" id="btn">이메일 중복체크</button>
			                        <p id="idcheck"></p>
			                	</div>        
		                    </div>
		                    
		                    <div class="wrapInput">
		                    	<input type="password" name="password" id="password" class="formInputs" placeholder="영문, 숫자, 특수문자(~!@#$%^&*) 조합 8~15 자리 " autocomplete="on"> 
		                    		<i class="fa-solid fa-eye-slash fa-lg" id="fa_A" ></i>
		                   			<p id="pwcheck"></p>
		                    </div>
		                    
		                    <div class="wrapInput">
		                        <input type="password" name="password" id="password1" class="formInputs" placeholder="비밀번호 확인" autocomplete="on">
		                           <i class="fa-solid fa-eye-slash fa-lg" id="fa_B"></i>
		                    </div>
		                    
		                    <div class="wrapInput">
								<input type="text" name="nickname " id="nicknamecheck" class="formInputs" placeholder= "닉네임">
								<p id="nncheck"></p>
								<c:if test="${message=='fault'}">
									<p id="nncheck2">중복된 닉네임입니다.</p>
								</c:if>	
		                    </div>
		                    
		                    <div class="wrapInput">
		                        <input type="text" name="phone_num" id="phone_numcheck" class="formInputs" placeholder="휴대폰번호" autocomplete="no">
		                    	<p id="phcheck"></p>
		                    </div>
		             </div>
					</form>
					<!-- form end  -->
					
					<!-- checkbox start  -->
					<div id="checkbox">   
		                             <input type='checkbox' id='selectAll' value="" /> 모두 동의 합니다 <br>
		                             	<input type='checkbox' class="checkB" id="check1" name="check" value="">  만 14세 이상입니다<br>
		                                <input type='checkbox' class="checkB" id="check2"  name="check" value="">  [필수] 서비스 이용약관 동의<br> 
										<input type='checkbox'class="checkB" id="check3"  name="check" value=""> [필수] 개인정보 수집 및 서비스 활용 동의
		            </div> 
					<!--  id="checkbox" end  -->
	            <input id="submit" type="button" value="가입하기" onclick="rkdlq()">
	            <c:if test="${message=='fault'}">
					<h1>
						가입 실패
					</h1>
				</c:if>
				
	        </div>  
	      </div> <!--<div id="mainDiv_j"> end -->
                   
	</div>
             
</div> <!-- <div id="container_j"> end -->
  

<!-- ================================================================================================================= -->
<script>
	//혹시 모를 청개구리의 enter키 입력 방지      _재호님
	document.addEventListener('keydown', function(e){
		if (e.key === 'Enter'){
			e.preventDefault();
		};
	}, true);
	
	//  동의항목   23/02/08 김지혜
	$(document).ready(function(){
		$('#checkbox').on('click',function(e){

			// 모두 동의하기를 선택했을 경우
			if(e.target.id == 'selectAll') {
				if(e.target.checked) $('input[type=checkbox]').prop('checked', true);  // e.target.checked상태가  true일 경우, 체크 상태로 변환.
				else $('input[type=checkbox]').prop('checked', false); // e.target.checked상태가  아닐 경우, 체크 상태 해제.
			}
	
			// 동의항목 3개 모두 체크상태일 경우, 모두 동의하기까지 checked상태
			if($('#check1').is(':checked') && $('#check2').is(':checked') && $('#check3').is(':checked')){
				$('#selectAll').prop('checked', true);
			}
			
			// 동의항목 3개 모두 체크상태가 아닐 경우, 모두 동의하기까지 checked가 아닌 상태
			if($('#check1').is(':checked') == false || $('#check2').is(':checked') == false || $('#check3').is(':checked') == false){			
				$('#selectAll').prop('checked', false);
			}
			
			if($('#selectAll').is(':checked') && $('#check1').is(':checked') && $('#check2').is(':checked') && $('#check3').is(':checked')){
				d=1;
			};
		});
		
	});

	
	
	 var a=0, b=0, c=0, e=0, d=0;
// 	a : 비밀번호 ,   b : 닉네임(중복확인) ,  c : 핸드폰 , e : 이메일    , d : 동의



	// 닉네임 - 뷰단은 띄어쓰기. 특수문제 제어  02/09 -----------------------------------------------------
	
	
	
	// 	https://gurtn.tistory.com/86
	//https://ju-note.tistory.com/19






// 비밀번호 유효성검사  (23/02/08 김지혜) 
	var PWt = document.querySelector('#password');
	var PWt2 = document.querySelector('#password1');
	// 비밀번호 유효성검사 
 	PWt.addEventListener('blur', function(){
 		
 		
		 var pw = $("#password").val();
		 var pw1 = $("#password1").val();
		 var num = pw.search(/[0-9]/g);
		 var eng = pw.search(/[a-z]/ig);
		 var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
		
			 if(pw.length < 8 || pw.length > 20){
			 	alert("8자리 ~ 20자리 이내로 입력해주세요.");
			 	return ;
			 }else if(pw.search(/\s/) != -1){
				alert("비밀번호는 공백 없이 입력해주세요.");
				return ;
			 }else if(num < 0 || eng < 0 || spe < 0 ){
			 	alert("영문,숫자, 특수문자를 혼합하여 입력해주세요.");
			 	return;
			 }
 				
		});
 	// 비밀번호확인 과 비밀번호 일치시 통과
 	PWt2.addEventListener('blur', function(){
		if($("#password").val() == $("#password1").val()){ // 비밀번호란과 비밀번호 확인란이 동일하면,  
			console.log("통과"); 
			console.log($("#password").val());
			a=1;
			console.log(a);
			console.log("서로 동일.");
		};		 		
 	});


	
		// 비밀번호 보이기/숨기기 기능 (23-02-07 김지혜 )
	    $('.wrapInput_pw').on('click',function(){
	        $('.wrapInput_pw input').toggleClass('active');
	        if($('.wrapInput_pw input').hasClass('active')){
	            $(this).attr('.wrapInput_pw',"fa fa-eye-slash fa-lg")
	            .prev('.wrapInput_pw input').attr('type',"text");
	        }else{
	            $(this).attr('class',"fa fa-eye fa-lg")
	            .prev('.wrapInput_pw input').attr('type','password');
	        }
	    });



	// 전화번호 표현식 맞지 않을 경우 제어_ 정규표현식   23-02-01 김지혜 
	var input = document.querySelector('#phone_numcheck');
  	const output = document.querySelector('#phcheck');
	const form = document.querySelector('form');
	
	input.addEventListener('blur', function(){
	  	const re = /^(?:\d{3}|\(\d{3}\))([-\/\.])\d{4}\1\d{4}$/
	  
	  	function telcheck(tel){
	  		const ok = re.exec(tel);
	
	  		console.log(tel);
	    	  if (!ok) {    		
	    	    output.textContent = `형식에 맞지 않는 전화번호입니다.` + tel;
	    	    return false;
	    	  } else {
	    	    output.textContent = `감사합니다. 전화번호는` + ok[0] +  `입니다.`
	    	    c=1;  
	    	    return true;
	    	  }
	  	};
	  	
	  	telcheck(input.value);
	});
	  	
	//   23/02/07 	
	// 이메일 형식 확인_ 가입하기 버튼을 클릭했을 시, (UserController에 emailCheck의 메세지 참고) 
	$('#btn').on('click',function(){
		let email = $('input[name=email]').val();
		//이메일 올바르게 쓰지 않았을 때 바로 리턴
		if(!email.includes('@')) return $('#idcheck').text('올바른 이메일을 입력해 주세요');
		//ajax로 email보내기 -> emailCheck 매핑된 곳으로 보내서 중복 확인
		$.ajax({
			url : 'emailCheck',
			type : 'post',
			data : {'email' : email}, // 입력한 email data
			dataType : 'text', 
			success : function(result){
				//result가 text 형태로 와서 false가 text 형태로 비교
				if(result == 'false'){      //false = 사용가능
					$('#idcheck').text('사용 가능한 이메일입니다');
					e=1;
				}else{
					$('#idcheck').text('이미 사용중인 이메일입니다');
				}
			},
			error : function(){
				alert('에러발생 에러발생 ㅌㅌ');
			}

		});
	});

	function rkdlq(){
		if(a==1 &&b==1&&c==1&&d==1&&e==1){
			alert("끝");
		}
		console.log(a+"a"+b+"b"+c+"c"+d+"d"+e+"e");
	};

</script>
</body>
</html>