// detail 페이지 내 영상부분 찜하기, 좋아요, 싫어요 버튼 누를시 칠해져있는 아이콘으로 변경하기
// 내보관함 페이지 이동 - 02.16 김범수 수정
const comu_btn = document.querySelectorAll('.comu_btn');

for(var i = 1; i<comu_btn.length; i++) {
    comu_btn[i].addEventListener('click', function(){
        this.classList.toggle('fas');
    });
}


comu_btn[0].addEventListener('click', function(){
    if(this.className.includes('fas')){ // 내보관함에서 삭제
    	$.ajax({
    		url : 'mylocker_de',
    		type : 'post',
    		data : {'title' : title},		
    	})
    	this.className = 'far fa-heart comu_btn';
    	alert('내보관함에서 삭제되었습니다');
    
    }else { // 내보관함에 담기
    	$.ajax({
    		url : 'mylocker_in',
    		type : 'post',
    		data : {'title' : title},
    	})
    	this.className = 'fas fa-heart comu_btn';
    	alert('내보관함에 담겼습니다');
    }
});

// 댓글 작성하기 버튼 눌렀을때 댓글작성하기 - 02.20 장민실
   $("#comment_write_btn").on('click', function(event){ 
	   document.comt_write.action="/comt/write";
	   document.comt_write.submit();
      });
   
// 댓글 업데이트
//   function comt_edit() {
   //	   $.ajax({
   //		type: "post",
   //		url: "/comt/edit",
   //		success: function(list) {
   //				let fileInfo = getFileInfo(this);
   //				let html = "<div><a href='"+fileInfo.get_link+"'>"+fileInfo.original_name+"</a>&nbsp;&nbsp;";
   //				html+="<a href='#' class='file_del' data-src='"+this+"'[삭제]</a></div>"
   //				$("#uploadedList").append(html);
   //				
   //				let view = "<div><img src="+/images/${filename}+" width="+100px+" height="+100px+"></div>"
   //				$("#comt_update_area").append(view);
   //		}
   //	});
   //}
   
	function comt_edit(answer_idx, awriter, acontent, qna_idx){
		$('#acontent'+answer_idx).html(
			"<textarea id='edit_acontent"+answer_idx+"'>"+acontent+"</textarea>"
			+"<style>#edit_acontent"+answer_idx+"{width:740px; height:80px; resize:none;} </style>"
		);
		
		$('#abt'+answer_idx).html(
			"<a onclick='answerEditSave("+answer_idx+","+qna_idx+")' id='btnEdit'>완료</a> "
			+"<a onclick='location.href='qnaDetail.do?idx="+qna_idx+"' id='btnCancel'>취소</a>"
		);
	}
	
	function comt_edit_save(answer_idx, qna_idx){
		var acontent = $("#edit_acontent"+answer_idx).val();
		location.href='answerEdit.do?idx='+answer_idx+"&acontent="+acontent;
	}
   
//  댓글 삭제 > 버튼값을 id로 줘서 제일위에것만 적용됨, id > class로 변경하고 설정 다시 맞춰야함
   $("#comment_delete").on('click', function(){ 
	   document.comt_list.action="/comt/delete";
	   document.comt_list.submit();
      })
      
//  대댓글 불러와서 영역에 넣어주기
      
function comt_list(pid_num) {
	   console.log(pid_num);
   $.ajax({
      type: "post",
      url: "/comt/cocomList/" + pid_num,
      success: function(list) {
         let cocomText = "";
         console.log(list);
         $(list).each(function(){
        	cocomText += "<tr>";
        	cocomText += "	<td id='com_title'>" + this.nickname + "&nbsp;&nbsp;<fmt:formatDate value='" + this.create_date + "' pattern='yyyy-MM-dd a HH:mm:ss' /></td>";
        	cocomText += "</tr>";
        	cocomText += "<tr>";
        	cocomText += "	<td id='com_contents'>" + this.commentary + "</td>";
        	cocomText += "</tr>";
         });
         $('this.parentNode.children[3]').html(cocomText);
      }
   });
}
   
   $(".cocom_list_btn").on('click', function(e){
	   let pid_num = this.parentNode.children[2].value;
	 //  let cocomListDiv = this.parentNode.children[3];
	   comt_list(pid_num);
      })
      




