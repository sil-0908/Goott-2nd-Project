package com.test.test1.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.test1.admin.dto.AdminETCDto;
import com.test.test1.admin.service.AdminService;
import com.test.test1.algorithm.service.AlgorithmService;
import com.test.test1.board.qna.dto.Criteria;
import com.test.test1.board.qna.dto.PageMaker;
import com.test.test1.user.service.UserService;
import com.test.test1.video.dto.VideoDto;
import com.test.test1.video.service.VideoService;

@Controller
public class AdminController {
	
	@Autowired
	UserService userService;
	@Autowired
	AlgorithmService algorithmService;
	@Autowired
	AdminService adminService;
	@Autowired
	VideoService videoService;
	
	//모든 관리자 페이지 접근 URL로 불가 - 02.18 장재호
	@RequestMapping(value= {"admin/**"})
	public ModelAndView access(ModelAndView mv, HttpServletRequest request) {
		//URL접근 차단 - 02.18 장재호
		String result = request.getHeader("REFERER");
		if(result == null) {
			mv.addObject("error", "잘못된 접근입니다");
			mv.setViewName("redirect:/");
			return mv;
		}
		else{
			mv.setViewName("redirect:/admin");
			return mv;
		}
	}
	
	//페이지 불러왔을 때 알고리즘 정보 가져오기 - 02.15 장재호
	//관리자 페이지의 URL 주소 접근 차단 - 02.18 장재호
	@RequestMapping("admin")
	@ResponseBody
	public ModelAndView adminMain(ModelAndView mv, HttpServletRequest request, HttpSession session) {
		//URL접근 차단 - 02.18 장재호
		String result = request.getHeader("REFERER");
		if(result == null) {
			mv.addObject("error", "잘못된 접근입니다");
			mv.setViewName("redirect:/");
			return mv;
		}
		//추가로 확실한 검증 - 02.18 장재호
		if(session.getAttribute("user_id") != "admin" || session.getAttribute("nickname") != "admin") {
			mv.addObject("error", "접근 권한이 없습니다");
			mv.setViewName("redirect:/");
		}
		
		//1. 카테고리 순위
		mv.addObject("category", algorithmService.categoryRate());
		//2. 장르 순위
		mv.addObject("genre", algorithmService.genreRate());
		//3. 매출
		int total = adminService.getTotalSales() * 15000;
		int daily = adminService.getDailySales() * 15000;
		System.out.println("오늘 = " + total);
		System.out.println("진짜오늘 = " + daily);
		
		mv.addObject("totalSales", total);
		mv.addObject("dailySales", daily);
		//4. 방문자 수
		int totalVisit = adminService.getTotalVisit();
		int todayVisit = adminService.getTodayVisit();
		mv.addObject("totalVisit", totalVisit);
		mv.addObject("todayVisit", todayVisit);
		/*********************끝*****************************/		
		mv.setViewName("admin/index");
		return mv;					
	}
	
	//전체조회 - 01.31 장재호
	//17일 취합 때 삭제되있는거 롤백(Model쪽도 싹다) - 02.18 장재호
	@RequestMapping("admin/userlist")
	public ModelAndView userList(ModelAndView mv, Criteria cri) throws Exception {
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri); //page, perpagenum 셋팅
		pageMaker.setTotalCount(userService.listCount(cri)); //총 게시글 수 셋팅
		
		mv.addObject("pageMaker", pageMaker);
		mv.addObject("data", userService.list(cri));
		mv.setViewName("/admin/user_list");
		return mv;
	}
	
	//selectbox를 통한 다중 삭제 - 02.18 장재호
	@RequestMapping(value="admin/userDeletes", method=RequestMethod.POST)
	public void qnaDeletes(@RequestBody List<Integer> delArr) {
		System.out.println("아아아아아아아아아 : " + delArr);
		adminService.deletes(delArr);
	}
	
	//관리자 VIDEO CRUD를 위한 VIDEO DB페이지 - 02.19 장재호
	@RequestMapping("admin/databases/video")
	public ModelAndView videoList(ModelAndView mv, Criteria cri) throws Exception {
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri); //page, perpagenum 셋팅
		pageMaker.setTotalCount(videoService.adminListCount(cri)); //총 게시글 수 셋팅
		
		mv.addObject("pageMaker", pageMaker);
		mv.addObject("data", videoService.adminList(cri));
		mv.setViewName("/admin/admin_video");
		return mv;
	}
	
	//Video detail READ - 02.19 장재호
	@RequestMapping("admin/databases/video/{video_id}")
	public ModelAndView adminVideoDetail(ModelAndView mv, @PathVariable int video_id) {
		mv.addObject("data", videoService.detail(video_id));
		mv.setViewName("admin/admin_video_detail");
		return mv;
	}
	
	//VIDEO DELETE - 02.19 장재호
	@RequestMapping("videoDataDelete")
	public String videoDel(int delVideoID) {
		System.out.println(delVideoID);
		adminService.videoDel(delVideoID);
		return "redirect:/admin/databases/video";
	}
	
	//VIDEO CREATE PAGE - 02.19 장재호
	@RequestMapping("admin/databases/video/create")
	public String videoCreatePage() {
		return "admin/admin_video_create";
	}
	
	//VIDEO CREATE - 02.19 장재호
	@RequestMapping(value="admin/videoCreate", method=RequestMethod.POST)
	public ModelAndView videoCreate(ModelAndView mv, AdminETCDto dto) {
		//관리자의 입장에서 생각하기. DBA말고 그럼 필요한거? 비디오 테이블 생성 시 카테고리, 장르, 배우가 있던말던 다 짱박을거임.
		//1. 카테고리 확인 없으면 추가먼저.
		String category_name = dto.getCategory_name();
		adminService.addCategory(category_name);
		//2. 장르확인 없으면 추가먼저
		String genre_name = dto.getGenre_name();
		adminService.addGenre(genre_name);
		//3. 배우 확인 없으면 추가먼저
		String[] actor = dto.getActor_name().split(",");
		adminService.addActor(actor);
		//7. 그러고 나서 비디오 등록 -> 비디오먼저 붙여야 비디오ID가 생겨서 아래 작업 가능
		adminService.addVideo(dto);
		//4. 비디오 카테고리에 해당 비디오 카테고리 추가
		//5. 비디오 장르 마찬가지
		//6. 비디오 액터 마찬가지

		//이 모든 과정에서 dto에서 원하는 정보 뽑아써야하며 촥촥 잘 들어가게 해야함 몽말인지알지?
		mv.setViewName("admin/admin_video");
		return mv;
	}
	
	//체크박스 다중삭제 - 02.19 장재호	
	@RequestMapping(value="videoDataDeletes", method=RequestMethod.POST)
	public String videoDels(@RequestBody List<Integer> delArr) {
		adminService.videoDels(delArr);
		return "redirect:/admin/databases/video";
	}
	
	//비디오 데이터 수정 - 02.19 장재호
	@RequestMapping(value="videoDataModify", method=RequestMethod.POST)
	public String videoDataModify(ModelAndView mv, VideoDto dto) {
		adminService.videoDataModify(dto);
		return "redirect:/admin/databases/video";
	}

	//관리자 타 TABLE CRUD를 위한  DB페이지 - 02.19 장재호
	@RequestMapping("admin/databases/others")
	public ModelAndView othersDB(ModelAndView mv){		
		mv.addObject("data", adminService.getCategory());
		mv.addObject("datasec", adminService.getGenre());		
		mv.setViewName("admin/admin_otherdb");		
		return mv;
	}
	
	/***************** 카테고리, 장르 추가 및 삭제 - 02.19 장재호 *************/
	@RequestMapping("admin/addCategory")
	public String addCategory(String category_name) {
		adminService.addCategory(category_name);
		return "redirect:/admin/datebases/others";
	}
	
	@RequestMapping("admin/addGenre")
	public String addGenre(String genre_name) {
		adminService.addGenre(genre_name);
		return "redirect:/admin/datebases/others";
	}
	
	@RequestMapping("admin/delCategory")
	public String delCategory(String category_name) {
		try {
			adminService.delCategory(category_name);
		}catch(Exception e){
			return "redirect:/admin/datebases/others";
		}
		return "redirect:/admin/datebases/others";
	}
	
	@RequestMapping("admin/delGenre")
	public String delGenre(String genre_name) {
		try {
			adminService.delGenre(genre_name);
		}catch(Exception e) {
			return "redirect:/admin/datebases/others";
		}
		return "redirect:/admin/datebases/others";
	}
	/***************************************************************/
}
