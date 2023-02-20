package com.test.test1.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.test1.user.service.UserService;

@Controller
public class MainController {

	@Autowired
	UserService userService;
	
	//메인페이지 접근 - 02.06 장재호
	//일 방문자수 추가 - 02.19 장재호
	@RequestMapping("/")
	public String Main() {
		//일 방문자수 ++ - 02.19 장재호
		userService.addVisit();
		
		return ("common/main");
	}
	
}
