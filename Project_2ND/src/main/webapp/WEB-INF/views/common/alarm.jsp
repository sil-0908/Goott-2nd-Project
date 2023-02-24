<!-- 02.23 장재호 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<input type="hidden" value="${sessionScope.user_id}" id="socketuserID">
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>    
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="/resources/css/common/alarm.css" rel="stylesheet">
<body>
<!-- 알람 섹션 -->
<div id="alarmDiv">
<i id="alarmI" class="fas fa-bell"></i>
<ul id="alarmUL">
</ul>
</div>
</body>    
<script>
const alarmUL = document.querySelector("#alarmUL");
const alarmI = document.querySelector("#alarmI");
var sock = null;

$(document).ready(function(){
	connectWs();
});

//소켓
function connectWs(){
	var ws = new SockJS("http://localhost:8080/echo");
	sock = ws;

	ws.onopen = function() {
		console.log("연결완료");
 		ws.send($('#socketuserID').val());
	};

	ws.onmessage = function(event) {
		/* 받을 알람이 있을 때 */
		if(event.data.length>0){
			let newAlarm = '';
			newAlarm += '<li scope="col">' + event.data + "</li>"
			$('#alarmUL').append(newAlarm);	
		}

	};

	ws.onclose = function() {
	    console.log('close');
	};

};

/* 알람창 추가 */

alarmI.addEventListener('click', function(){
	alarmUL.classList.toggle('visible');
	$(this).stop(false, false);
});

alarmUL.addEventListener('click', function(e){
	var endIdx = e.target.textContent.indexOf(")");
	var idx = e.target.textContent.substr(1, endIdx-1);

	$.ajax({
		url : '/alarmDel',
		data : {"idx" : idx},
		type : 'post',
		success : function(data){
			console.log(data);
			alert("성공");
		}
	})
	
	$(e.target).remove();
	
})

</script>
</html>
<!------------------------------------------------------------->