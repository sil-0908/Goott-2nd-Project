package com.test.test1.video.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.test1.user.service.UserService;
import com.test.test1.video.dto.CommentDto;
import com.test.test1.video.dto.VideoDto;
import com.test.test1.video.service.CommentService;
import com.test.test1.video.service.VideoService;

@Controller
@RequestMapping("comt/**")
public class CommentController {
	 
	@Autowired
	CommentService commentService;	
	@Autowired
	UserService userService;
	@Autowired
	VideoService videoService;
	
//	video detail 내 댓글등록 02.20 장민실
	@RequestMapping(value="write", method=RequestMethod.POST)
	public ModelAndView insert(CommentDto dto, HttpSession session, ModelAndView mv) {
		String user_id = session.getAttribute("user_id").toString();
		String nickname = session.getAttribute("nickname").toString();
		int id = userService.getid(user_id);
		dto.setUser_id(id);
		dto.setNickname(nickname);		
		System.out.println(dto.toString());
		commentService.insert(dto);
		mv.addObject("c_dto", dto);
		mv.setViewName("video/detail");
		return mv;
	}

//	video detail 댓글목록 구현
	@RequestMapping("reply")
	public ModelAndView replyList(int video_id, ModelAndView mv) {
		List<CommentDto> list = commentService.replyList(video_id);
		mv.addObject("c_dto", list);
		System.out.println(list.toString());
		mv.setViewName("video/detail");
		return mv;
	}
	
	
	
	
	
	
	
	
	
	

}
