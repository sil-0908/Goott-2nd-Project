package com.test.test1.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.test1.algorithm.service.AlgorithmService;

@Controller
public class AdminController {
	
	@Autowired
	AlgorithmService algorithmService;

	//페이지 불러왔을 때 알고리즘 정보 가져오기 - 02.15 장재호
	@RequestMapping("admin")
	@ResponseBody
	public ModelAndView adminMain(ModelAndView mv) {
		//1. 카테고리 순위
		System.out.println(algorithmService.categoryRate().toString());
		mv.addObject("category", algorithmService.categoryRate());
		//2. 장르 순위
		mv.addObject("genre", algorithmService.genreRate());
		mv.setViewName("admin/admin_main");
		return mv;
	}

}
