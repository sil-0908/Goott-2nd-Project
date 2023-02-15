package com.test.test1.chat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatController {
	@RequestMapping("/chat")
	public ModelAndView chat (HttpServletRequest req, HttpServletResponse resp, HttpSession session, ModelAndView mv) {
		mv.addObject("nickname", session.getAttribute("nickname"));
		mv.setViewName("chat/chat");
		return mv;
	}
}