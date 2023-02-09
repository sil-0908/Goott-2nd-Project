package com.test.test1.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.test1.user.dto.UserDto;
import com.test.test1.user.service.ApiLoginService;

//api로그인 구현 컨트롤러 - 02.08 장재호
@Controller
@RequestMapping("/user/**")
public class ApiLoginController {
	
	@Autowired
	ApiLoginService apiLoginService;
	
	@RequestMapping(value = "kakaoLogin", method = RequestMethod.POST)
	public String kakaoLogin(UserDto userDto) {
		System.out.println(userDto.toString());
		return "redirect:/";
	}
	
	@RequestMapping(value = "naverLogin", method = RequestMethod.GET)
	public String naverLogin() {
		return "api/naverCallback";
	}
	
	@RequestMapping(value = "naverSaved", method = RequestMethod.POST)
	@ResponseBody
	public String naverLogin(UserDto userDto, ModelAndView mv) {
		//result : 가입여부
		String result = apiLoginService.apiCheck(userDto.getEmail());			    
	    if(result==null) {//가입가능
	    	result = "ok";
	    	return result;
	    }
	    else return "no"; //기가입
	}


}
