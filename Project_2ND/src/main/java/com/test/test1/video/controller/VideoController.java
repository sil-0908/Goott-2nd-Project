package com.test.test1.video.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.test1.video.dto.RentalDTO;
import com.test.test1.video.dto.VideoDto;
import com.test.test1.video.service.RentalService;
import com.test.test1.video.service.VideoService;

@Controller
@RequestMapping("/video/**")
public class VideoController { 
		
	@Autowired 
	VideoService videoService; 
	
	// 내보관함 페이지 구현 - 02.16 김범수
	@Autowired
	RentalService rentalService;	
	
	
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public ModelAndView create() {
	    return new ModelAndView("/video/create");
	}	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
	    ModelAndView mav = new ModelAndView();

	    String videoId = this.videoService.create(map);
	    if (videoId == null) {
	        mav.setViewName("redirect:/video/create");
	    }else {
	        mav.setViewName("redirect:/detail?videoId=" + videoId); 
	    }  

	    return mav;
	}
	
//	영상 전체조회 페이지 - 02.07 배철우
//	DTO 생성 후 DTO 활용하여 코드재생성 - 02.10 장민실
	@RequestMapping("list")
	public ModelAndView list(ModelAndView mv) {
		List<VideoDto> list = videoService.list();
		mv.addObject("dto", list);
		mv.setViewName("video/list");
		return mv;
	}

//	video_detail 02.07 배철우
//	DTO 생성 후 DTO 활용하여 코드재생성 + 배우정보 가져오기 - 02.14 장민실
	@RequestMapping("detail")
	public ModelAndView detail(@RequestParam int video_id, ModelAndView mv) {
		List<VideoDto> actor = videoService.actor(video_id);
		mv.addObject("dto", videoService.detail(video_id));
		mv.addObject("detail", actor);
		mv.setViewName("video/detail");
		return mv; 
	}
	
	
//	 내보관함 기능 구현 - 02.15 김범수
	@RequestMapping(value = {"mylocker_in", "mylocker_de"}, method = RequestMethod.POST)
	@ResponseBody
	public void mylocker(String title, RentalDTO dto, HttpSession session, HttpServletRequest request) throws Exception{
		String requestUrl = request.getRequestURL().toString();
		String id = (String) session.getAttribute("user_id");
		int video_id = videoService.getid(title); // 비디오 아이디를 가져오는것
		if(requestUrl.contains("mylocker_in")) {
			dto.setVideo_id(video_id);
			dto.setId(id);
			rentalService.insert(dto);
		}
		else {
			dto.setId(id);
			dto.setVideo_id(video_id);
			rentalService.delete(dto);
		}	
	}
	
	
	
	
	
	

     
}
