package com.test.test1.video.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.test1.user.service.UserService;
import com.test.test1.video.dto.CommentDto;
import com.test.test1.video.dto.InteractionDto;
import com.test.test1.video.dto.VideoDto;
import com.test.test1.video.service.InteractionService;

@Controller
@RequestMapping("inter/**")
public class InteractionController {
	
	@Autowired
	InteractionService interactionService;
	@Autowired
	UserService userService;
	
//	비디오 좋아요
	@RequestMapping(value="video_like", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView video_like(VideoDto v_dto, InteractionDto i_dto, HttpSession session, ModelAndView mv) {
		String user_id = session.getAttribute("user_id").toString();
		int id = userService.getid(user_id);
		
		i_dto.setUser_id(id);
		
		int video_id = v_dto.getVideo_id();
		i_dto.setVideo_id(video_id);
		
		int like = 1;
		i_dto.setLike(like);
		
		interactionService.video_like(i_dto);
		
		mv.addObject("inter_dto", i_dto);
		mv.setViewName("redirect:/video/detail?video_id="+video_id);
		
		return mv;
	}
	
////	비디오 싫어요
//	@RequestMapping(value="video_unlike", method=RequestMethod.POST)
//	@ResponseBody
//	public ModelAndView video_unlike(VideoDto v_dto, InteractionDto i_dto, HttpSession session, ModelAndView mv) {
//		String user_id = session.getAttribute("user_id").toString();
//		int id = userService.getid(user_id);
//		
//		int video_id = v_dto.getVideo_id();
//		i_dto.setVideo_id(video_id);
//		
//		int unlike = 0;
//		i_dto.setUnlike(unlike);
//		
//		i_dto.setUser_id(id);
//		
//		mv.addObject("insert_dto", i_dto);
//		mv.setViewName("redirect:/video/detail?video_id="+video_id);
//		
//		return mv;
//	}
//	
////	댓글, 대댓글 좋아요
//	@RequestMapping(value="comt_like", method=RequestMethod.POST)
//	@ResponseBody
//	public ModelAndView comt_like(CommentDto c_dto, InteractionDto i_dto, HttpSession session, ModelAndView mv) {
//		String user_id = session.getAttribute("user_id").toString();
//		int id = userService.getid(user_id);
//		
//		int video_id = c_dto.getVideo_id();
//		i_dto.setVideo_id(video_id);
//		
//		int like = 1;
//		i_dto.setLike(like);
//		
//		i_dto.setUser_id(id);
//		
//		model.addAttribute("inter_dto", i_dto);
//		
//		return null;
//	}
//	
////	댓글, 대댓글 싫어요
//	@RequestMapping(value="comt_unlike", method=RequestMethod.POST)
//	@ResponseBody
//	public ModelAndView comt_unlike(CommentDto c_dto, InteractionDto i_dto, HttpSession session, ModelAndView mv) {
//		String user_id = session.getAttribute("user_id").toString();
//		int id = userService.getid(user_id);
//		
//		int video_id = c_dto.getVideo_id();
//		i_dto.setVideo_id(video_id);
//		
//		int unlike = 0;
//		i_dto.setUnlike(unlike);
//		
//		i_dto.setUser_id(id);
//		
//		model.addAttribute("inter_dto", i_dto);
//		
//		return null;
//	}
	
	

}
