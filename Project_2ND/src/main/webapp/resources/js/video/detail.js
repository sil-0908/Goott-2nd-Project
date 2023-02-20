// detail 페이지 내 영상부분 찜하기, 좋아요, 싫어요 버튼 누를시 칠해져있는 아이콘으로 변경하기
// 내보관함 페이지 이동 - 02.16 김범수 수정
const comu_btn = document.querySelectorAll('.comu_btn');

for(var i = 1; i<comu_btn.length; i++) {
    comu_btn[i].addEventListener('click', function(){
        this.classList.toggle('fas');
    });
}


let title = document.querySelector('.info_text').children[0].innerText;


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




