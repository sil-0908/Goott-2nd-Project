// 기본세팅 : 아이디를 제외한 모든 값에  | 가 되도록 즉, 수정이 가능하도록 focus 해놓을 것
// 값을 변경하지 못하도록 


$(function(){
	
	let data_id = document.querySelector("#id");
	let data_email = document.querySelector("#email");
	let data_nickname = document.querySelector("#nickname");
	let data_phone_num = document.querySelector("#phone_num");

		// 첫 세팅으로, 아이디를 제외한 모든 값에 수정가능한 상태로 세팅    23/02/18 김지혜
		window.addEventListener("load", function(){			
			modifyT(data_email);
			modifyT(data_nickname);
			modifyT(data_phone_num);			
		});
		// 수정가능한 상태로 disabled 속성 제거    23/02/18 김지혜
		function modifyT(e){
			e.disabled=false;  //  disabled 속성을 제거
		}
		




		// 아이디란 클릭시 수정불가 알림 설정    23/02/18 김지혜
		data_id.addEventListener("click", function(){
			alert("아이디는 수정할 수 없습니다.");
		});
		
		// 23/02/20 
		// 이메일 수정시 , 중복 불가이므로 ajax로 창을 띄워서, 이메일 중복확인, 이메일 인증번호 검증 실행되도록 처리. 
		data_email.addEventListener("click", function(){
			// 
			$.ajax({
				type: ""
				
				
				
			}); // ajax end 
		});




		
		
		


		
		
		


		
		
		


		
		
		
		
		
		
}); // 전체 담고있는 제이쿼리 함수 end