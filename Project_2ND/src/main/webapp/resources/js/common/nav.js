const search_input = document.querySelector('#search'),
search_i = document.querySelector('#search_icon');
   
  search_i.addEventListener('click', function() {
        search_input.classList.toggle("view");
     });
 
const searchBox = document.getElementById('search');
  searchBox.addEventListener('input', function() {
  });

  
  //video 검색 기능  //
  function showImageData() {	
	  const searchText = document.getElementById('search').value.toLowerCase();
	  if (searchText.trim() === '') {
	    return;
	  };
	  $('.slider').slick('unslick');
	  const images = document.querySelectorAll('.conta');
	  const searchResults = document.getElementById('search-results');
	  searchResults.innerHTML = ''; 

	  images.forEach(function(image) {
	    const title = image.querySelector('span');
	    if (title && title.textContent.toLowerCase().replace(/\s+/g, '').includes(searchText.replace(/\s+/g, ''))) {
	      searchResults.appendChild(image); 
	      image.style.display = 'block';
	    } else {
	      image.style.display = 'none';
	    };
	  });
	  const hideElements = document.querySelectorAll('.hide');
	  hideElements.forEach(function(hideElement) {
	    hideElement.style.display = 'none';
	  });
	  const sub = document.querySelectorAll('.sub-menu');
	  sub.forEach(function(sub){
	    sub.style.display ='none';
	  });
	};


  searchBox.addEventListener('keyup', function() {
	  const searchText = this.value.trim().toLowerCase();
	  if (event.key === 'Enter') {
	
	    showImageData(searchText);
	  }
	});
  
  
  
  // 검색결과 초기화 기능 //
  function resetSearch() {
  	
  	  const searchResults = document.getElementById('search-results');
  	  searchResults.innerHTML = '';
  	  const images = document.querySelectorAll('.conta');
  	  images.forEach(function(image) {
  	    image.style.display = 'block';
  	  });
  	  const hides = document.querySelectorAll('.hide');
  	  hides.forEach(function(hide) {
  	    hide.style.display = 'block';
  	  });
  	
  	
  	 
  	}
  
  
  //애니메이션 토글 기능 //
  function ani_q() {
  	  resetSearch();
  	  let mainText = document.querySelectorAll(".hide .section_main_text")[1];
  	  let section = document.querySelectorAll(".hide .section")[1];
  	  
  	  let subMenu = document.getElementById('my-sub-menu');
  	  if (!subMenu) {
  	    subMenu = document.createElement('div');
  	    subMenu.classList.add('sub-menu');
  	    subMenu.id = 'my-sub-menu';
  	    subMenu.style.display = 'none'; 
  	    document.body.appendChild(subMenu);
  	  }
  	  toggleSubMenu('my-sub-menu'); 
  	  
  	  if (mainText.style.display === "none") {
  	    mainText.style.display = "block";
  	    section.style.display = "block";
  	    resetSlider();
  	  } else {
  	    let hides = document.querySelectorAll('.hide');
  	    for (let i = 0; i < hides.length; i++) {
  	      hides[i].style.display = 'block';
  	    }
  	  };
  	};
    
    
  	 //영화 장르별 토글기능 //
  function toggleSubMenu(subMenuId) {
  	   resetSearch();
  	  var subMenus = document.getElementsByClassName('sub-menu');
  	  for (var i = 0; i < subMenus.length; i++) {
  	    if (subMenus[i].id !== subMenuId) {
  	      subMenus[i].style.display = 'none';
  	    }
  	  };

  	  var subMenu = document.getElementById(subMenuId);
  	  if (subMenu.style.display === 'none') {
  	    subMenu.style.display = 'block';
  	  } else {
  	    subMenu.style.display = 'none';
  	  };

  	  var hides = document.querySelectorAll('.hide .section, .hide .section_main_text');
  	  for (var j = 0; j < hides.length; j++) {
  	    if (subMenu.style.display === 'block') {
  	      hides[j].style.display = 'none';
  	    } else {
  	      hides[j].style.display = 'block';
  	    };
  	  };
  	  resetSlider();
  	};
   
  	
  	
  	
  	// 로고 클릭시 페이지 새로고침  추가 0227 장재호
  function back(){
	  if($('#sessionID').val() != null){
		  window.location.href="/video/list";
	  }
	  else window.location.reload();
  }	
    


       // 네비바 스크롤시 백그라운드 적용 
  function handleScroll() {
      const scrolled = window.scrollY > 50;
      const nav = document.querySelector('nav');
      if (scrolled) {
          nav.classList.add('scrolled');
      }else{
          nav.classList.remove('scrolled');
      }
  } 



  window.addEventListener('scroll', handleScroll);