package com.test.test1.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.test1.user.dto.UserDto;

//api로그인 구현 컨트롤러 - 02.08 장재호
@Controller
@RequestMapping("/user/**")
public class ApiLoginController {	
	@RequestMapping(value = "kakaoLogin", method = RequestMethod.POST)
	public String kakaoLogin(UserDto userDto) {
		System.out.println(userDto.toString());
		return "redirect:/";
	}
	
	@RequestMapping(value = "naverLogin", method = RequestMethod.POST)
	@ResponseBody
	public String naverLogin(UserDto userDto) {
		System.out.println(userDto);
		return "main/main";
	}


}
