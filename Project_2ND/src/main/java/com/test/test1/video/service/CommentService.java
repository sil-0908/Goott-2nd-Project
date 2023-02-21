package com.test.test1.video.service;

import java.util.List;

import com.test.test1.video.dto.CommentDto;

public interface CommentService {

//	video detail 내 댓글등록 02.20 장민실
	void insert(CommentDto dto);

//	video detail 내 댓글목록 불러오기 02.21 장민실
	List<CommentDto> replyList(int video_id);

	List<CommentDto> getPid(CommentDto c_dto);



	

}
