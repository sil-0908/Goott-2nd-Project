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

// 원댓글 작성하기 start - 02.20 장민실
   $("#comment_write_btn").on('click', function(event){ 
	   document.comt_write.action="/comt/write";
	   document.comt_write.submit();
      });
//  원댓글 작성하기 end
   
// 댓글 수정 start      
   function comt_edit_cancle() {
	   let comt_edit_div = this.parentNode;
      $(comt_edit_div).empty();
   }
   
   $(".comment_update").on('click', function(e){
	      let comment_id = this.parentNode.children[1].value;
	      let comt_edit_div = this.parentNode.nextElementSibling.nextElementSibling;
	      comt_edit(comment_id, comt_edit_div);
	   });
   
   function comt_edit(comment_id, comt_edit_div) {
	   $.ajax({
	      type: "get",
	      url: "/comt/edit/" + comment_id,
	      success: function(edit) {
	    	  console.log(comment_id);
	         let comtEditText = "";
	         console.log(edit);
	         comtEditText += "<form name='comt_edit' method='post'>";
	         comtEditText += "      <textarea rows='3' cols='60' class='com_edit_text'>";

	         comtEditText += "      </textarea>";
	         comtEditText += "      <button type='button' class='edit_complete' onclick='comt_edit_complete()'>수정완료</button>";
	         comtEditText += "      <button type='button' class='edit_cancle' onclick='comt_edit_cancle()'>수정취소</button>";
	         comtEditText += "</form>";
	         $(comt_edit_div).html(comtEditText);
	      }
	   });
	}   
//  댓글 수정 end
   
//  댓글 삭제 start 02.24 장민실
	$(document).on('click', '.comment_delete', function(e){
		e.preventDefault();
		let comment_id = this.parentNode.children[1].value;		
		
		$.ajax({
			data : {
				comment_id : comment_id				
			},
			url : '/comt/delete',
			type : 'POST',
			success : function(){
				window.location.reload();
				alert("댓글 삭제가 완료되었습니다.");
			}
		});		
	});
//  댓글 삭제 end
      
//  대댓글 불러와서 영역에 넣어주기 start 02.24 장민실
	let cocom_list_tf = false;
	
	$(".cocom_list_btn").on('click', function(e){
		let pid_num = this.parentNode.children[2].value;
		let cocomListDiv = this.parentNode.nextElementSibling;
		
		if(cocom_list_tf===false && commentary===null && commentary==='') {
			alert("등록된 댓글이 없습니다.");
		}
		else if(cocom_list_tf===false) { 
			cocomt_list(pid_num, cocomListDiv);
			cocom_list_tf=true;
		}
		else if(cocom_list_tf===true) {
			$(cocomListDiv).empty();
			cocom_list_tf=false;
		}

	})
	
	function cocomt_list(pid_num, cocomListDiv) {
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
	         $(cocomListDiv).html(cocomText);
	      }
	   });
	}
//  대댓글 불러와서 영역에 넣어주기 end

    


