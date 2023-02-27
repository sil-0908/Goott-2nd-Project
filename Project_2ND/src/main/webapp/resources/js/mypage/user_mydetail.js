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

/////////////////////////////////////////////////////////////
//이미지 슬라이드 //
$(".slider").not('.slick-initialized').slick({
	slidesToShow:6,
	slidesToScroll:6,    
	prevArrow: "<button type='button' class='slick-arrow'><i class='fa-solid fa-angle-left'></i></button>",
	nextArrow: "<button type='button' class='slick-next'><i class='fa-solid fa-angle-right'></i></button>",
});

//이미지 로딩 위한 메서드 - 02.24김범수
$(function() {
	$("input[type='file']").on("change", function(e){
		
		let formData = new FormData();
		let fileInput = $('input[name="uploadFile"]'); 
		let fileList = fileInput[0].files; //파일 객체
		
		let fileObj = fileList[0]; // 처음으로 선택된 파일

		if(!fileCheck(fileObj.name, fileObj.size)){
			return false;
		}
		 
		formData.append("uploadFile", fileObj); //uploadFile라는 키값형성 - fileObj의 데이터가 여기에 담김
		
		$.ajax({
			url: '/mypage/upload',
	    	processData : false,
	    	contentType : false,
	    	data : formData, // form데이터 객체에 해당 파일의 정보가 담겨있음
	    	type : 'POST',
	    	dataType : 'json', // 제이슨타입으로 formdata를 전달
	    	success : function(result) {
				console.log(result);
				showUploadImage(result);  //이미지 출력 메서드
			},
	    	error : function(result){
	    		alert("이미지 파일이 아닙니다.");
	    	}
		});
	});
});

// 이미지인지 파일 체크, 용량 체크 - 02.24김범수
function fileCheck(fileName, fileSize){
	let regex = new RegExp("(.*?)\.(jpg|png)$"); // 이미지가 아닌 파일 잡는것
	let maxSize = 1048576; //1MB
	
	if(fileSize >= maxSize){
		alert("파일 사이즈 초과");
		return false;
	}
		  
	if(!regex.test(fileName)){
		alert("해당 종류의 파일은 업로드할 수 없습니다.");
		return false;
	}
	
	return true;		
	
}

//이미지 출력을 위한 메서드 - 02.24김범수
function showUploadImage(result){
	// 전달받은 데이터가 값이 없는 경우
	if(result == "" || result == null){return}
	console.log(result);
	let fileCallPath = encodeURI("C:\\upload\\"+result.uploadPath + result.uuid + "_" + result.fileName); // 해당 파일의 이름
	console.log(fileCallPath);
	$('.img_tag').attr('src', "/mypage/display?fileName=" + fileCallPath);
}

//이미지 로딩 위한 메서드 - 02.24김범수
$(function() {
	$("#img_onload").ready(function(){
		
		let formData = new FormData();
		let fileInput = $('#img_onload').attr('src'); 
		console.log(fileInput);
		 
		formData.append("uploadFile", fileInput); //uploadFile라는 키값형성 - fileObj의 데이터가 여기에 담김
		console.log(formData);
		
		$.ajax({
			url: '/mypage/onload',
	    	processData : false,
	    	contentType : false,
	    	data : formData, // form데이터 객체에 해당 파일의 정보가 담겨있음
	    	type : 'POST',
	    	dataType : 'text', // 제이슨타입으로 formdata를 전달
	    	success : function(result) {
				showOnloadImage(result);  //이미지 출력 메서드
			},
	    	error : function(result){
	    		alert("이미지 파일이 아닙니다.");
	    	}
		});
	});
});

//이미지 로딩 위한 메서드 - 02.24김범수
function showOnloadImage(result){
	// 전달받은 데이터가 값이 없는 경우
	if(result == "" || result == null){return}
	console.log(result);
	let fileCallPath = encodeURI(result); // 해당 파일의 이름
	console.log(fileCallPath);
	$('#img_onload').attr('src', "/mypage/display?fileName=" + fileCallPath);
}