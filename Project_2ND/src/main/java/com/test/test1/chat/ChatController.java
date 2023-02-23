//package com.test.test1.chat;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class ChatController {
//	@RequestMapping("/adminchat")
//	public ModelAndView adminChat (HttpServletRequest req, HttpServletResponse resp, HttpSession session, ModelAndView mv) {
//		mv.addObject("admin", "admin");
//		mv.setViewName("socket/chat");
//		return mv;
//	}
//	
//	@RequestMapping("/userchat")
//	public ModelAndView chat (HttpServletRequest req, HttpServletResponse resp, HttpSession session, ModelAndView mv) {
//		mv.addObject("user", session.getAttribute("user_id"));
//		mv.setViewName("socket/chat");
//		return mv;
//	}
//	
//	@RequestMapping("/chat")
//	public ModelAndView chat3 (HttpServletRequest req, HttpServletResponse resp, HttpSession session, ModelAndView mv) {
//		mv.addObject("user", session.getAttribute("user_id"));
//		mv.setViewName("socket/chat2");
//		return mv;
//	}
//}