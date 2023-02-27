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

///////////////////////////////// 댓글, 대댓글 공통  ///////////////////////////////////////

	// 댓글, 대댓글 수정 중 수정취소 버튼클릭시 영역 없애기 start
	function comt_edit_cancle(e) {
	   e.setAttribute('class', 'on');
	   let text_div = e.parentNode;
	   console.log(text_div);
	   $(text_div).empty();
	}
	// 댓글, 대댓글 수정 중 수정취소 버튼클릭시 영역 없애기 end
	
	// 댓글, 대댓글 삭제 start 02.24 장민실
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
	// 댓글, 대댓글 삭제 end
	
///////////////////////////////// 댓글, 대댓글 공통  ///////////////////////////////////////
	
///////////////////////////////// 원댓글  ///////////////////////////////////////
	
	// 원댓글 작성하기 start - 02.20 장민실
	   $("#comment_write_btn").on('click', function(event){ 
		   document.comt_write.action="/comt/write";
		   document.comt_write.submit();
	      });
	// 원댓글 작성하기 end
	   
	// 댓글 수정 영역 start 02.27 장민실 
	   
	   // 댓글 수정버튼 눌렀을때 수정 폼 가져오기
		$(".comment_update").on('click', function(e){
			let comt_edit_div = this.parentNode.nextElementSibling.nextElementSibling;
			let comt_text = document.querySelector('#com_contents').innerHTML;
			let comtEditText = "";
			comtEditText += "<p>댓글 수정하기</p>";
			comtEditText += "<form name='comt_edit' method='post'>";
			comtEditText += "      <textarea rows='3' cols='60' class='com_edit_text'>" + comt_text + "</textarea>";
			comtEditText += "      <button type='button' class='edit_complete' onclick='comt_edit_complete()'>수정완료</button>";
			comtEditText += "      <button type='button' class='edit_cancle' onclick='comt_edit_cancle(this)'>수정취소</button>";
			comtEditText += "</form>";
			$(comt_edit_div).html(comtEditText);
		});
	   
	   // 댓글 수정완료 버튼클릭
		function comt_edit_complete() {
			let comment_id = document.querySelector('.c_id_input').value;
			let commentary = document.querySelector('.com_edit_text').value;
		   
			$.ajax({
				data : {
					comment_id : comment_id,
					commentary : commentary
				},
				url : "/comt/edit/" + comment_id,
				type : 'POST',
				success : function(){
					window.location.reload();
					alert("댓글 수정이 완료되었습니다.");
				}
			});		
		};
	//  댓글 수정 영역 end
	
///////////////////////////////// 원댓글  ///////////////////////////////////////
		
///////////////////////////////// 대댓글  ///////////////////////////////////////
		
		// 대댓글 작성하기 start
//		$(".cocom_write_btn").on('click', function(e){
//			let cocom_insert_div = this.parentNode.nextElementSibling;
////			let cocom_text = document.querySelector('.cocom_text').innerHTML;
//			let cocomForm = "";
//			cocomForm += "<p>대댓글 작성하기</p>"
//			cocomForm += "<form name='comt_edit' method='post'>";
//			cocomForm += "      <textarea rows='3' cols='60' class='cocom_text'></textarea>";
//			cocomForm += "      <button type='button' class='cocom_complete' onclick='cocom_complete()'>수정완료</button>";
//			cocomForm += "      <button type='button' class='cocom_cancle' onclick='comt_edit_cancle(this)'>수정취소</button>";
//			cocomForm += "</form>";
//			$(cocom_insert_div).html(cocomForm);
//		});   
//	   
//		function cocom_complete() {
//			let comment_id = document.querySelector('.c_id_input').value;
//			let commentary = document.querySelector('.com_edit_text').value;
//		   
//			$.ajax({
//				data : {
//					comment_id : comment_id,
//					commentary : commentary
//				},
//				url : "/comt/cocomwrite",
//				type : 'POST',
//				success : function(){
//					window.location.reload();
//					alert("대댓글 작성이 완료되었습니다.");
//				}
//			});		
//		};
		// 대댓글 작성하기 end
		
		// db의 대댓글 불러와서 영역에 넣어주기 start 02.24 장민실
		let cocom_list_tf = false;
		
		$(".cocom_list_btn").on('click', function(e){
			let video_id = this.parentNode.children[0].value;
			let pid = this.parentNode.children[2].value;
			let cocomListDiv = this.parentNode.nextElementSibling.nextElementSibling.nextElementSibling;

			if(cocom_list_tf===false) { 
				cocomt_list(video_id, pid, cocomListDiv);
				cocom_list_tf=true;
			}
			else if(cocom_list_tf===true) {
				$(cocomListDiv).empty();
				cocom_list_tf=false;
			}
		})
		
		function cocomt_list(video_id, pid, cocomListDiv) {
		   $.ajax({
		      type: "post",
		      url: "/comt/cocomList/" + pid,
		      data: {
		    	  video_id : video_id
		      },
		      success: function(list) {
		         let cocomText = "";
		         
		         if(list.length===0) {
		        	 alert("등록된 댓글이 없습니다.");
		         } 
		         
		         else {
		        	 
		        	 if(session==='') {
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
		        	 
		        	 else if (true) {
		        		 $(list).each(function(){
		     	        	cocomText += "<tr>";
		     	        	cocomText += "	<td id='com_title'>" + this.nickname + "&nbsp;&nbsp;<fmt:formatDate value='" + this.create_date + "' pattern='yyyy-MM-dd a HH:mm:ss' /></td>";
		     	        	cocomText += "</tr>";
		     	        	cocomText += "<tr>";
		     	        	cocomText += "	<td id='com_contents'>" + this.commentary + "</td>";
		     	        	cocomText += "</tr>";
		     	        	cocomText += "<td>";
		                    cocomText += "   <div class='comment_btn'>";
		                    cocomText += "		<input type='button' class='comment_update' value='수정'>";
		                    cocomText += "		<input type='button' class='comment_update' value='삭제'>";
		                    cocomText += "   </div>"
		                    cocomText += "</td>";
		     	         });
		     	         $(cocomListDiv).html(cocomText);
		       		}
		         }  
		      }
		   });
		}
		// db의 대댓글 불러와서 영역에 넣어주기 end
		
///////////////////////////////// 대댓글  ///////////////////////////////////////