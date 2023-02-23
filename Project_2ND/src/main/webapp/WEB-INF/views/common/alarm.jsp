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
<script>
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
		console.log("onmessage"+event.data);
		let $socketAlert = $('div#socketAlert');
		$socketAlert.html(event.data)
		$socketAlert.css('display', 'block');
		
		setTimeout(function(){
			$socketAlert.css('display','none');
			
		}, 5000);
	};

	ws.onclose = function() {
	    console.log('close');
	};

};


</script>
</html>