package com.test.test1.video.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView insert(VideoDto v_dto, CommentDto c_dto, HttpSession session, ModelAndView mv) {
		String user_id = session.getAttribute("user_id").toString();
		String nickname = session.getAttribute("nickname").toString();
		int id = userService.getid(user_id);
		
		List<CommentDto> pidList = commentService.getPid(c_dto);
		int pid = c_dto.getPid();
		System.out.println("가져오는 pid : " + pid);
		pid+=1;
		System.out.println("현재 pid : " + pid);
		c_dto.setPid(pid);
//		mv.addObject("pid", pid);
		
		c_dto.setUser_id(id);
		c_dto.setNickname(nickname);		
		int video_id = v_dto.getVideo_id();
		c_dto.setVideo_id(video_id);
		commentService.insert(c_dto);
		mv.addObject("c_dto", c_dto);
		mv.setViewName("redirect:/video/detail?video_id="+video_id);
		return mv;
	}
	
	
	
	
	
	
	

}
