package com.test.test1.video.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.test1.user.service.UserService;
import com.test.test1.video.dto.VideoInteractionDto;
import com.test.test1.video.dto.CommentDto;
import com.test.test1.video.dto.ComtInteractionDto;
import com.test.test1.video.dto.VideoDto;
import com.test.test1.video.service.InteractionService;

@Controller
@RequestMapping("inter/**")
public class InteractionController {
	
	@Autowired
	InteractionService interactionService;
	@Autowired
	UserService userService;
	
//	비디오 좋아요 - 03.06 장민실
	@RequestMapping(value="video_like", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView video_like(VideoDto v_dto, VideoInteractionDto vi_dto, HttpSession session, ModelAndView mv) {
		String user_id = session.getAttribute("user_id").toString();
		int id = userService.getid(user_id);		
		vi_dto.setUser_id(id);		
		int video_id = v_dto.getVideo_id();
		vi_dto.setVideo_id(video_id);
		
		List<VideoInteractionDto> v_inter_info = interactionService.get_v_inter_info(vi_dto);
		for(VideoInteractionDto data: v_inter_info) {
			vi_dto.setV_idx(data.getV_idx());
			vi_dto.setUnlike(data.getUnlike());
		}
		int v_idx = vi_dto.getV_idx();
		int unlike = vi_dto.getUnlike();
		
		if(v_idx != 0) {
			if(v_idx != 0 && unlike == 1) {
				vi_dto.setV_idx(v_idx);
				interactionService.v_delete(vi_dto);
				int like = 1;
				vi_dto.setLike(like);
				interactionService.video_like(vi_dto);
			}	// 누른값이 unlike일때 if end
			vi_dto.setV_idx(v_idx);
			interactionService.v_delete(vi_dto);
		}	// 누른값이 like일때 if end
		else if(v_idx == 0) {
			int like = 1;
			vi_dto.setLike(like);
			interactionService.video_like(vi_dto);
		}	// 누른값이 없을때 else if end
		mv.addObject("video_inter_dto", vi_dto);
		mv.setViewName("redirect:/video/detail?video_id="+video_id);
		return mv;
	}
	
//	비디오 싫어요 - 03.07 장민실
	@RequestMapping(value="video_unlike", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView video_unlike(VideoDto v_dto, VideoInteractionDto vi_dto, HttpSession session, ModelAndView mv) {
		String user_id = session.getAttribute("user_id").toString();
		int id = userService.getid(user_id);		
		vi_dto.setUser_id(id);		
		int video_id = v_dto.getVideo_id();
		vi_dto.setVideo_id(video_id);
		
		List<VideoInteractionDto> v_inter_info = interactionService.get_v_inter_info(vi_dto);
		for(VideoInteractionDto data: v_inter_info) {
			vi_dto.setV_idx(data.getV_idx());
			vi_dto.setLike(data.getLike());
		}
		int v_idx = vi_dto.getV_idx();
		int like = vi_dto.getLike();		
		
		if(v_idx != 0) {
			if(v_idx != 0 && like == 1) {
				vi_dto.setV_idx(v_idx);
				interactionService.v_delete(vi_dto);
				int unlike = 1;
				vi_dto.setUnlike(unlike);
				interactionService.video_unlike(vi_dto);
			}	// 누른값이 like일때 if end
			vi_dto.setV_idx(v_idx);
			interactionService.v_delete(vi_dto);
		}	// 누른값이 unlike일때 if end
		else if(v_idx == 0) {
			int unlike = 1;
			vi_dto.setUnlike(unlike);
			interactionService.video_unlike(vi_dto);
		}	// 누른값이 없을때 else if end
		
		mv.addObject("video_inter_dto", vi_dto);
		mv.setViewName("redirect:/video/detail?video_id="+video_id);
		return mv;
	}
	
//	댓글 좋아요
	@RequestMapping(value="comt_like", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView comt_like(CommentDto c_dto, VideoDto v_dto, ComtInteractionDto ci_dto, HttpSession session, ModelAndView mv) {
		String user_id = session.getAttribute("user_id").toString();
		int id = userService.getid(user_id);		
		ci_dto.setUser_id(id);		
		int comment_id = c_dto.getComment_id();
		ci_dto.setComment_id(comment_id);
		
		List<ComtInteractionDto> c_inter_info = interactionService.get_c_inter_info(ci_dto);
		for(ComtInteractionDto data: c_inter_info) {
			ci_dto.setC_idx(data.getC_idx());
			ci_dto.setUnlike(data.getUnlike());
		}
		int c_idx = ci_dto.getC_idx();
		int unlike = ci_dto.getUnlike();		
		
		if(c_idx != 0) {
			if(c_idx != 0 && unlike == 1) {
				ci_dto.setC_idx(c_idx);
				interactionService.c_delete(ci_dto);
				int like = 1;
				ci_dto.setLike(like);
				interactionService.comt_like(ci_dto);
			}	// 누른값이 like일때 if end
			ci_dto.setC_idx(c_idx);
			interactionService.c_delete(ci_dto);
		}	// 누른값이 unlike일때 if end
		else if(c_idx == 0) {
			int like = 1;
			ci_dto.setLike(like);
			interactionService.comt_like(ci_dto);
		}	// 누른값이 없을때 else if end
		
		mv.addObject("comt_inter_dto", ci_dto);
//		int video_id = v_dto.getVideo_id();
//		mv.setViewName("redirect:/video/detail?video_id="+video_id);
		mv.setViewName("video/detail");		
		return mv;
	}
//	, method=RequestMethod.POST
//	댓글, 대댓글 싫어요
	@RequestMapping(value="comt_unlike", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView comt_unlike(CommentDto c_dto, VideoDto v_dto, ComtInteractionDto ci_dto, HttpSession session, ModelAndView mv) {
		String user_id = session.getAttribute("user_id").toString();
		int id = userService.getid(user_id);		
		ci_dto.setUser_id(id);		
		int comment_id = c_dto.getComment_id();
		ci_dto.setComment_id(comment_id);
		
		List<ComtInteractionDto> c_inter_info = interactionService.get_c_inter_info(ci_dto);
		for(ComtInteractionDto data: c_inter_info) {
			ci_dto.setC_idx(data.getC_idx());
			ci_dto.setLike(data.getLike());
		}
		int c_idx = ci_dto.getC_idx();
		int like = ci_dto.getLike();
		
		if(c_idx != 0) {
			if(c_idx != 0 && like == 1) {
				ci_dto.setC_idx(c_idx);
				interactionService.c_delete(ci_dto);
				int unlike = 1;
				ci_dto.setUnlike(unlike);
				interactionService.comt_unlike(ci_dto);
			}	// 누른값이 like일때 if end
			ci_dto.setC_idx(c_idx);
			interactionService.c_delete(ci_dto);
		}	// 누른값이 unlike일때 if end
		else if(c_idx == 0) {
			int unlike = 1;
			ci_dto.setUnlike(unlike);
			interactionService.comt_unlike(ci_dto);
		}	// 누른값이 없을때 else if end
		
		mv.addObject("comt_inter_dto", ci_dto);
//		int video_id = v_dto.getVideo_id();
//		mv.setViewName("redirect:/video/detail?video_id="+video_id);
		mv.setViewName("video/detail");
		return mv;
	}
	
	

}
