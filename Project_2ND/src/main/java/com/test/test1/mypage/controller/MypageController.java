package com.test.test1.mypage.controller;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.test1.user.controller.UserController;
import com.test.test1.user.dao.UserDao;
import com.test.test1.user.dto.UserDto;
import com.test.test1.user.service.UserService;
import com.test.test1.video.dto.VideoDto;
import com.test.test1.video.service.RentalService;
import com.test.test1.video.service.VideoService;

@Controller
@RequestMapping("mypage/**")
public class MypageController {
	
	@Autowired
	UserService userService;
	@Autowired
	UserDao userDao;
	@Autowired
	RentalService rentalService;
	@Autowired 
	VideoService videoService;
	

	// 회원정보가진 개인정보페이지 연결  23/02/16 김지혜 
		@RequestMapping(value= "/info_mydetail")
		public ModelAndView detail(HttpSession session, ModelAndView mv) {
			// 유저 아이디를 통해 세션에서 정보 가져오기 
			String user_id =(String) session.getAttribute("user_id").toString();
			UserDto dto = userService.detail(user_id); // 회원 ID를 사용하여 해당 회원의 정보를 찾아 dto에 넣는다.
			mv.addObject("data", dto); // 위에서 받은 회원정보를 model을 통해 view에 보내준다.;
			//////////////////////////////////////////////////////////////////
			List<VideoDto> list = rentalService.list(user_id);
			mv.addObject("dto", list);
			mv.setViewName("mypage/mydetail");
			return mv; 		
		}	
		
		// VIEW에서 받아온 값을 이용하여 수정페이지  _ 23/02/18~ 23/02/20수정_ 김지혜
		@RequestMapping(value="/info_modify", method=RequestMethod.GET)
		public ModelAndView detailModify(HttpSession session, ModelAndView mv) {
		// 세션에서 정보가져오기 
			String user_id = (String) session.getAttribute("user_id").toString();
			UserDto list = userService.detail(user_id);
			mv.addObject("list", list);
			mv.setViewName("mypage/info_modify");
			return mv;
		}	
		
		// VIEW에서 받아온 값을 이용하여 수정페이지  _ 23/02/18~ 
		@RequestMapping(value="/info_modify", method=RequestMethod.POST)
		public String detailModify(@ModelAttribute UserDto dto, HttpSession session) {
			// 재 입력된 값을 받아 db 저장. (수정된 내용이던, 수정되지 않은 내용이던 수정하기 버튼을 누르면 디비에 새롭게 update되도록 처리)
			dto.setId((String) session.getAttribute("user_id"));		
			userService.infoModify(dto);			
			return "redirect:/mypage/info_mydetail";
		}
		

}

