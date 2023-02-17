$(function() {
	/* 체크박스 - 02.17 장재호 */
	  $('.js-check-all').on('click', function() {

	  	if ( $(this).prop('checked') ) {
		  	$('th input[type="checkbox"]').each(function() {
		  		$(this).prop('checked', true);
	        $(this).closest('tr').addClass('active');
		  	})
	  	} else {
	  		$('th input[type="checkbox"]').each(function() {
		  		$(this).prop('checked', false);
	        $(this).closest('tr').removeClass('active');
		  	})
	  	}

	  });

	  $('th[scope="row"] input[type="checkbox"]').on('click', function() {
	    if ( $(this).closest('tr').hasClass('active') ) {
	      $(this).closest('tr').removeClass('active');
	    } else {
	      $(this).closest('tr').addClass('active');
	    }
	  });
	  
	//selectbox 선택한 값만 검색 - 02.07 장재호
	  $('#searchBtn').click(function(){
	  	if($('input[type=text]').val() == 'undefined' || $('input[type=text]').val() == ''){		
	  		alert("검색어를 입력하세요");
	  		return;
	  	}
	  	document.form1.submit();
	  });
	  
	//검색 시 페이징처리 처리 - 02.14 장재호
	//1) 페이지 버튼 클릭 시 pageNum값을 가지고 form태그로 이동하도록 처리
	//2) 화면에 검색키워드가 미리 남겨지도록 처리.
	var pagination = document.querySelector("#pagination");
	var pageUL = document.querySelector('#pageUL');
	pagination.onclick = function() {
		event.preventDefault();
		if((event.target.className).indexOf("right") != -1){
			document.form2.page.value = Number(document.form2.page.value) +5;
			document.form2.submit();
			return;
		}else if((event.target.className).indexOf("left") != -1){
			document.form2.page.value = Number(document.form2.page.value) -5;
			document.form2.submit();
			return;
		}else if(event.target.tagName == 'A' || event.target.tagName == 'I'){
			document.form2.page.value = event.target.textContent;
			document.form2.submit();
		}
		else return;
	}

});





