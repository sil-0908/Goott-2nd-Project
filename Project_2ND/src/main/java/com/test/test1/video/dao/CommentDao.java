package com.test.test1.video.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.test1.video.dto.CommentDto;


@Repository
public class CommentDao {
	
	@Autowired
	SqlSession sqlSession;

//	video detail 내 댓글등록 02.20 장민실
	public void insert(CommentDto dto) {
		sqlSession.insert("comment.insert", dto);
	}

//	video detail 내 댓글목록 불러오기 02.21 장민실
	public List<CommentDto> replyList(int video_id) {
		return sqlSession.selectList("comment.replyList", video_id);
	}

	public List<CommentDto> getPid(CommentDto c_dto) {
		return sqlSession.selectList("comment.get_pid", c_dto);
	}



	

}
