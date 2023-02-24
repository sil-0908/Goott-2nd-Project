package com.test.test1.mypage.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.test1.video.dto.VideoDto;
import com.test.test1.video.service.RentalService;
import com.test.test1.video.service.VideoService;

@Controller
@RequestMapping("mypage/**")
public class MypageController {
	
//	미완성 
	@Autowired
	RentalService rentalService;
	
	@Autowired 
	VideoService videoService;
	
	@RequestMapping(value="/mylocker", method = RequestMethod.GET)
	public ModelAndView mylocker(ModelAndView mv, HttpSession session) {
		String id = (String) session.getAttribute("user_id");
		List<VideoDto> list = rentalService.list(id);
		mv.addObject("dto", list);
		mv.setViewName("mypage/mylocker");
		return mv;
	}
}

