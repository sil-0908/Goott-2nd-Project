const inputVC = document.querySelectorAll('input');
const textareaVC = document.querySelectorAll('textarea');
var error1 = "";
var error2 = "";
function videoCreate(){
	inputVC.forEach(function(e){
		console.log(e.value)
		if(e.value == ''){
			error1 = 1;
		}
	})	
	
	textareaVC.forEach(function(e){
		console.log(e.value)
		if(e.value == '' || e.value == "undefined"){
			error2 = 1;
		}
	});
	if(error1 == "" && error2 == ""){
		document.videoCreateForm.submit();
	}
	else{
		alert("정보를 입력해주세요");
		error1 = "";
		error2 = "";
		return;
	}
}
	

