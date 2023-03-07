package com.test.test1.video.service;

import java.util.List;

import com.test.test1.video.dto.ComtInteractionDto;
import com.test.test1.video.dto.VideoInteractionDto;

public interface InteractionService {
	
//	비디오 좋아요 누른값 없을때 - 03.06 장민실
	void video_like(VideoInteractionDto vi_dto);
	
//	비디오 싫어요 누른값 없을때 - 03.07 장민실
	void video_unlike(VideoInteractionDto vi_dto);
	
//	video_idx,like,unlike 값 받아오기 - 03.06 장민실
	List<VideoInteractionDto> get_v_inter_info(VideoInteractionDto vi_dto);

//	비디오 좋아요,싫어요 누른값 있을때 - 03.06 장민실
	void v_delete(VideoInteractionDto vi_dto);
	
//	댓글 좋아요 누른값 없을때
	void comt_like(ComtInteractionDto ci_dto);
	
//	댓글 싫어요 누른값 없을때
	void comt_unlike(ComtInteractionDto ci_dto);

//	comment_idx,like,unlike값 받아오기 
	List<ComtInteractionDto> get_c_inter_info(ComtInteractionDto ci_dto);

//	댓글 좋아요,싫어요 누른값 있을때
	void c_delete(ComtInteractionDto ci_dto);







}
