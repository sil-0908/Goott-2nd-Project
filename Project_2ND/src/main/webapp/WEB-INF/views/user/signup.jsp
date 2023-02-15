<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"/>
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
					<form name="form1" action="signup" method="post">
		                <div id="viewInput_j">
		                
		                
			                <div class="wrapInput">
			                        <input type="text" name="id" id="id" class="formInputs" placeholder="ID" autocomplete="on">
			                       	<div id="idcheck_j">
				                        <button type="button" id="btn"> 아이디 중복체크</button>
				                        <p id="idcheck"></p>
				                	</div>        
			                </div>
		                
		                	<div class="wrapInput">		                    	
	                    		<input type="email" name="email" id="email"  class="formInputs" placeholder="이메일" autocomplete="on">
							</div>
		                   
		                   
		                    <div class="wrapInput">		                    	
	                    		<input type="password" name="password" id="password"  class="formInputs" placeholder="영문, 숫자, 특수문자(~!@#$%^&*) 조합 8~15 자리 " autocomplete="on">
								<i class="fa-solid fa-eye-slash fa-lg" id="eye1"></i>
		                    </div>
		                    
		                    <div class="wrapInput">
		                        <input type="password" name="password" id="password1" class="formInputs" placeholder="비밀번호 확인" autocomplete="on">
  								<i class="fa-solid fa-eye-slash fa-lg" id="eye2"></i>
  							</div>
		                    
		                    <div class="wrapInput">
								<input type="text" name="nickname" id="nicknamecheck" class="formInputs" placeholder= "닉네임(빈칸,특수문자 제외)">
								<p id="nncheck"></p>
								<c:if test="${message=='fault'}">
									<p id="nncheck2">중복된 닉네임입니다.</p>
								</c:if>	
		                    </div>
		                    
		                    <div class="wrapInput">
		                        <input type="text" name="phone_num" id="phone_numcheck" class="formInputs" placeholder="휴대폰번호"  oninput="autoHyphen(this)" maxlength="13" autocomplete="no">
		                    </div>
		             </div>
					
					
					<!-- checkbox start  -->
					<div id="checkbox">   
		                             <input type='checkbox' id='selectAll' value="" /> 모두 동의 합니다 <br>
		                             	<input type='checkbox' class="checkB" id="check1" name="check" value="">  만 14세 이상입니다<br>
		                                <input type='checkbox' class="checkB" id="check2"  name="check" value="">  [필수] 서비스 이용약관 동의<br> 
										<input type='checkbox'class="checkB" id="check3"  name="check" value=""> [필수] 개인정보 수집 및 서비스 활용 동의
		            </div> 
					<!--  id="checkbox" end  -->
	            <input id="submit" type="button" value="가입하기" onclick="signup()">
	            <c:if test="${message=='fault'}">
				</c:if>
				</form>
					<!-- form end  -->
	        </div>  
	      </div> <!--<div id="mainDiv_j"> end -->
                   
	</div>
             
</div> <!-- <div id="container_j"> end -->
  

<!-- ================================================================================================================= -->
<script>





// 아이디  i, 비밀번호 p, 닉네임 n, 휴대폰  c, 동의  d
var i=0, p=0, n=0, c=0, d=0;



	// 전화번호 표현식 맞지 않을 경우 제어_ 정규표현식   23/02/01 김지혜 
	// - (하이픈) 자동 추가 기능으로  수정  23/02/09 김지혜 
	const autoHyphen = (target) => {
		 target.value = target.value
		   .replace(/[^0-9]/g, '')
		  .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
		 if(target.value.length == 13) c=1;
		 else c=0;
		 console.log(c);
	}



	  // 패스워드 눈모양 클릭 시 text로 보이기   ( 23/02/09 김지혜 ) 
	  $('#eye1').on('click',function(){
	    $('#password').toggleClass('active'); // 부모 태그 .input.password가 active 토글활성화

	    if($('#password').hasClass('active') == true){  // active가 활성화가 될 때 자식 input의 타입을 text로 바꿔서 비밀번호 텍스트를 보이게 함 
	    	  $(this).attr('class',"fa-solid fa-eye-slash fa-lg")
	            .prev('input').attr('type',"text");
	    }else{ // Class값이 'active'가 아닐 경우 
	    	 $(this).attr('class',"fa-solid fa-eye fa-lg")
	            .prev('input').attr('type','password');
	    }
	  });
	  
	  $('#eye2').on('click',function(){
		    $('#password1').toggleClass('active'); // 부모 태그 .input.password가 active 토글활성화

		    if($('#password1').hasClass('active') == true){  // active가 활성화가 될 때 자식 input의 타입을 text로 바꿔서 비밀번호 텍스트를 보이게 함 
		    	  $(this).attr('class',"fa-solid fa-eye-slash fa-lg")
		            .prev('input').attr('type',"text");
		    }else{ // Class값이 'active'가 아닐 경우 
		    	 $(this).attr('class',"fa-solid fa-eye fa-lg")
		            .prev('input').attr('type','password');
		    }
	  });




	
	// 닉네임 - 뷰단은 띄어쓰기. 특수문제 제어  _   23/02/09 김지혜 
	const nick = document.querySelector("#nicknamecheck");
	var specialCheck = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
	nick.addEventListener('blur', function(){
		 n=0;
		 if (nick.value == null || nick.value == "") {
	         alert("닉네임 입력은 필수입니다.");
	      //닉네임 빈칸 포함 안됨
	      } else if (nick.value.search(/\s/) != -1) {
	         alert("닉네임은 빈 칸을 포함 할 수 없습니다.");
	      }else if (specialCheck.test(nick.value)) {
	 		 alert("닉네임은 특수문자를 포함 할 수 없습니다.");
	      }else{
	    	  n=1;
	      }
	});

	

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
				d=1;
			}
	
			// 동의항목 3개 모두 체크상태일 경우, 모두 동의하기까지 checked상태
			if($('#check1').is(':checked') && $('#check2').is(':checked') && $('#check3').is(':checked')){
				$('#selectAll').prop('checked', true);
				d=1;
			}
			
			// 동의항목 3개 모두 체크상태가 아닐 경우, 모두 동의하기까지 checked가 아닌 상태
			if($('#check1').is(':checked') == false || $('#check2').is(':checked') == false || $('#check3').is(':checked') == false){			
				$('#selectAll').prop('checked', false);
				d=0;
			}
			
			console.log(d);
		});

		
	});





// 비밀번호 유효성검사  (23/02/08 김지혜) 
	var PWt = document.querySelector('#password');
	var PWt2 = document.querySelector('#password1');
	// 비밀번호 유효성검사 
 	PWt.addEventListener('blur', function(){
 		
		 var pw = $("#password").val();
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
 	// 비밀번호확인 과 비밀번호 일치시 통과      (23/02/09 김지혜)
 	PWt2.addEventListener('blur', function(){
		if($("#password").val() == $("#password1").val()){ // 비밀번호란과 비밀번호 확인란이 동일하면,  
			console.log("통과"); 
			console.log($("#password").val());
			console.log("서로 동일.");
		}else{
			alert("비밀번호가 일치하지 않습니다.");
		}
 	});





	
	
	  	
	//  아이디입력요소 추가  23/02/09 김지혜  	  
	// 아이디 형식 확인_ 가입하기 버튼을 클릭했을 시, (UserController에 idCheck 참고) 
	$('#btn').on('click',function(){
		let id = $('input[name=id]').val();
		//ajax로 id 보내기 -> idCheck 매핑된 곳으로 보내서 중복 확인
		$.ajax({
			url : 'idCheck',
			type : 'post',
			data : {'id' : id}, // 입력한 id data
			dataType : 'text', 
			success : function(result){
				//result가 text 형태로 와서 false가 text 형태로 비교
				if(result == 'false'){      //false = 사용가능
					$('#idcheck').text('사용 가능한 아이디입니다');
					i=1;
					$('input[name=id]').attr('readonly', true)
				}else{
					$('#idcheck').text('이미 사용중인 아이디입니다');
				}
			},
			error : function(){
				alert('다시 실행해주세요.');
			}

		});
	});

	
	// 최종 가입하기 버튼시 실행. 
	function signup(){
		
	 	if(($("#password").val()) == ($("#password1").val())){
	 		p=1;
	 	}else return;
	 		
		if(i==1 && p==1 && n==1 && c==1 && d==1){
			alert("회원가입 최종 성공!");
			$('#submit').attr('type', 'submit');
		    
		}else{
			alert("회원가입 실패. 다시 입력확인해주세요. ");
		}
	};

</script>


</body>
</html>