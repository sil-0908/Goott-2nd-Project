/* 답변 모달 창 - 02.18 장재호 */
const closebtn = document.querySelector('.closebtn');
const popup = document.querySelector('.popup');
const contentArea = document.querySelector('#contentArea');
const question_id = document.querySelector('input[name=question_id]').value;
const btnCenter = document.querySelector('#btnCenter');

function modal(e){ //답변 on-off
	//답변보기 눌렸을 때 받아와서 띄워줌		
	$(function(){
		$.ajax({
			url : "answerGet",
			type : 'post',
			data : {"question_id" : question_id},
			dataType : 'text',
			success : function(data){
				contentArea.value = data;
				contentArea.style.backgroundColor = '#F5F5F5';
			}
		})
	})
	if(e.textContent == "답변 보기"){
		btnCenter.style.display = 'none';
		contentArea.readOnly = true;
	}
	else{
		btnCenter.style.display = 'block';
		contentArea.readOnly = false;
		contentArea.style.backgroundColor = '#fff !important';
	}
	popup.style.display = 'block';
}
closebtn.addEventListener('click', function(){
	popup.style.display = 'none';
});

/* 답변 등록 - 02.18 장재호 */
function answerCreate(){
	if(contentArea.value == ''){
		alert("답변을 입력해 주세요");
		return;
	}
	console.log(question_id, contentArea.value);
	$.ajax({
		url : '/answerCreate',
		type : 'post',
		data : {"question_id" : question_id, "answer" : contentArea.value},		
        success : function(data){
        	if(sock){
        		alert("소켓");
        		let socketMsg = $('input[name="id"]').val();
    			alert(socketMsg);
    			sock.send(socketMsg);
        	}
        	else{
        		alert("안됨");
        	}
        },error : function(error){
        	console.log(error);
        }
	})
}
