const title = document.querySelector('textarea[id=title]');
const content = document.querySelector('textarea[id=content]');

// 등록 버튼 클릭 시 
function qModify(){
	if(title.value == "") {
		alert("제목을 입력하세요");
		document.form1.q_subject.focus();
		return;
	}
	if(content.value == ""){
		alert("내용을 입력하세요");
		document.form1.q_content.focus();
		return;
	}
	document.form1.submit();	
}