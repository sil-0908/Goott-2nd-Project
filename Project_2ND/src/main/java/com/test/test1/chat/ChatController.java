package com.test.test1.chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/* 장재호 */
@Controller
public class ChatController {
	
	List<Room> roomList = new ArrayList<Room>();
	static int roomNumber = 0;
	
	@RequestMapping("/chat")
	public ModelAndView chat() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chat/chat");
		return mv;
	}
	
	/* 방 생성 */
	@RequestMapping("/createRoom")
	public @ResponseBody List<Room> createRoom(@RequestParam HashMap<Object, Object> params){
		String roomName = (String) params.get("roomName");
		if(roomName != null && !roomName.trim().equals("")) {
			Room room = new Room();
			room.setRoomNumber(++roomNumber);
			room.setRoomName(roomName);
			roomList.add(room);
		}
		return roomList;
	}
	
	/* 방 정보 get */
	@RequestMapping("/getRoom")
	public @ResponseBody List<Room> getRoom(@RequestParam HashMap<Object, Object> params){
		return roomList;
	}
	
	/* 채팅방 */
	@RequestMapping("/moveChating")
	public ModelAndView chating(@RequestParam HashMap<Object, Object> params) {
		ModelAndView mv = new ModelAndView();
		int roomNumber = Integer.parseInt((String) params.get("roomNumber"));
		
		List<Room> new_list = roomList.stream().filter(o->o.getRoomNumber()==roomNumber).collect(Collectors.toList());
		if(new_list != null && new_list.size() > 0) {
			mv.addObject("roomName", params.get("roomName"));
			mv.addObject("roomNumber", params.get("roomNumber"));
			mv.setViewName("chat");
		}else {
			mv.setViewName("room");
		}
		return mv;
	}
	
	
//	@RequestMapping("/adminchat")
//	public ModelAndView adminChat (HttpServletRequest req, HttpServletResponse resp, HttpSession session, ModelAndView mv) {
//		mv.addObject("admin", "admin");
//		mv.setViewName("chat/chat");
//		return mv;
//	}
//	
//	@RequestMapping("/userchat")
//	public ModelAndView chat (HttpServletRequest req, HttpServletResponse resp, HttpSession session, ModelAndView mv) {
//		mv.addObject("user", session.getAttribute("user_id"));
//		mv.setViewName("chat/chat");
//		return mv;
//	}

}
/**********************************/