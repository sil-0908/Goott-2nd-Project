package com.test.test1.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.test1.chat.dto.ChatDto;
import com.test.test1.chat.service.ChatService;

/* 장재호 */
@Controller
public class ChatController {
	
	@Autowired
	ChatService chatService;

	@RequestMapping("/chat")
	public ModelAndView chat() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chat/userchat");
		return mv;
	}
	
	@RequestMapping("/admin/adminchat")
	public ModelAndView adminChat() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chat/adminchat");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value="adminChatCreate", method=RequestMethod.POST)
	public void adminChatCreate(ChatDto chatDto) {
		chatService.adminChatCreate(chatDto);
	}
	
	@ResponseBody
	@RequestMapping(value="chatCreate", method=RequestMethod.POST)
	public void chatCreate(ChatDto chatDto) {
		chatService.userChatCreate(chatDto);
	}
	
	@ResponseBody
	@RequestMapping(value="chatDelete", method=RequestMethod.POST)
	public void chatDelete(String id) {
		chatService.chatDelete(id);
	}
	
	@ResponseBody
	@RequestMapping(value="getChatLog", method=RequestMethod.POST)
	public List<ChatDto> getChatLog(ChatDto chatDto){
		System.out.println(chatDto.toString());
		List<ChatDto> list = chatService.getChatLog(chatDto);
		if(list != null) {
			return list;
		}
		else return null;
	}


}
/**********************************/