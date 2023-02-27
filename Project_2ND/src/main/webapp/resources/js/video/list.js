//이미지 슬라이드 //
$(".slider").not('.slick-initialized').slick({
     slidesToShow:6,
     slidesToScroll:6,    
     prevArrow: "<button type='button' class='slick-arrow'><i class='fa-solid fa-angle-left'></i></button>",
     nextArrow: "<button type='button' class='slick-next'><i class='fa-solid fa-angle-right'></i></button>",
   });
  


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


//슬라이더 초기화 기능 
function resetSlider() {
	  $('.slider').slick('unslick');
	  $(".slider").not('.slick-initialized').slick({
	    slidesToShow:6,
	    slidesToScroll:6,    
	    prevArrow: "<button type='button' class='slick-arrow'><i class='fa-solid fa-angle-left'></i></button>",
	    nextArrow: "<button type='button' class='slick-next'><i class='fa-solid fa-angle-right'></i></button>",
	  });
	}
  
  
  
  //애니메이션 토글 기능 //
function ani_q() {
	  resetSearch();
	  let mainText = document.querySelectorAll(".hide .section_main_text")[2];
	  let section = document.querySelectorAll(".hide .section")[2];
	  
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
 
	
	
	
	// 로고 클릭시 페이지 새로고침 
function back(){
	   window.location.reload();
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
 
  

// 페이지 로딩시 랜덤비디오 출력 //
const videos = document.querySelectorAll('#bg_video source');
const randomIndex = Math.floor(Math.random() * videos.length);
const randomVideo = videos[randomIndex].getAttribute('src');
const videoPlayer = document.querySelector('#bg_video');
videoPlayer.setAttribute('src', randomVideo);
 

  
  
/*       
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
   mapOption = { 
       center: new kakao.maps.LatLng(37.48195693074062, 126.89815006835722), // 지도의 중심좌표
       level: 2 // 지도의 확대 레벨
   };
   
var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

//일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
var mapTypeControl = new kakao.maps.MapTypeControl();

//지도에 컨트롤을 추가해야 지도위에 표시됩니다
//kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

//지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

var iwContent = '<div style="padding:5px;">구트아카데미</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
   iwPosition = new kakao.maps.LatLng(37.48195693074062, 126.89815006835722), //인포윈도우 표시 위치입니다
   iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

//인포윈도우를 생성하고 지도에 표시합니다
var infowindow = new kakao.maps.InfoWindow({
   map: map, // 인포윈도우가 표시될 지도
   position : iwPosition, 
   content : iwContent,
   removable : iwRemoveable
});
     
//아래 코드는 인포윈도우를 지도에서 제거합니다
//infowindow.close();        

//아래 코드는 지도 위의 마커를 제거하는 코드입니다
//marker.setMap(null);   
    */