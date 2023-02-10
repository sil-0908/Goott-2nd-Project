package com.test.test1.video.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.test1.video.dto.VideoDto;
import com.test.test1.video.service.VideoService;

@Controller
@RequestMapping("/video/**")
public class VideoController { 
		
	@Autowired 
	VideoService videoService; 
	
	
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
	
//	영상 전체조회 페이지 - 0207 배철우
//	DTO 생성 후 DTO 활용하여 코드재생성 - 0210 장민실
	@RequestMapping("list")
	public ModelAndView list(ModelAndView mv) {
		List<VideoDto> list = videoService.list();
		mv.addObject("data", list);
		mv.setViewName("video/list");
		return mv;
	}

    //영상 상세 페이지 -02.07 배철우
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
	    Map<String, Object> detailMap = this.videoService.detail(map);
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("data", detailMap);
	    String videoId = map.get("videoId").toString();
	    mav.addObject("videoId", videoId);
	    mav.setViewName("/video/detail");
	    return mav;
	}
	
	
	
	
	
	
	
	

     
}
