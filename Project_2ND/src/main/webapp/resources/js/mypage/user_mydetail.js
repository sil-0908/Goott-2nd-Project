// 모달창이용한 수정처리 	_23/02/20 김지혜

	var modifyBtn = document.querySelector("#btnWrite");  // 수정하기 버튼
	
	// 모달창 요소 가져오기
	var modal = document.getElementById("user_info_myModal");
	// 모달창 닫기 버튼 요소 가져오기
	var closeBtn = document.getElementsByClassName("closebtn")[0];

	// 모달창의 보이는 상태 초기화 
	var modalTf = false; 
	
	// 모달창 열기 버튼 클릭 시 모달창 보이기
	modifyBtn.onclick = function() {

	  modal.style.display = "block";
	  modalTf = true; // 모달 창이 보일 경우 true로 설정
	}

	
	// 모달창 닫기 버튼 클릭 시 모달창 닫기
	closeBtn.onclick = function() {
	  modal.style.display = "none";
	  modalTf = false;// 모달 창이 보이지 않을 경우 false로 설정
	}
	
	
	
