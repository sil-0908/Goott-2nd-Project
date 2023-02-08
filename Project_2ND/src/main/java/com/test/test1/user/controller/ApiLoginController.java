package com.test.test1.user.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//api로그인 구현 컨트롤러 - 02.08 장재호
@Controller
public class ApiLoginController {	
	@RequestMapping(value = "kakaoLogin", method = RequestMethod.POST)
	public String kakaoLogin(@RequestParam Map<String, Object> kakao) {
		System.out.println(kakao);
		return "redirect:/";
	}
	
	@RequestMapping("naverLogin")
	public String naverLogin(@RequestParam Map<String, Object> naver) {
		System.out.println(naver);
		return "redirect:/user/signin";
	}


}
