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

//	원댓글등록 02.20 장민실
	public void insert(CommentDto dto) {
		sqlSession.insert("comment.insert", dto);
	}
	
//	원댓글 등록할때 pid값 자동증가를 위해 DB의 마지막 pid값 가져오기
	public int get_pid(CommentDto c_dto) {
		return sqlSession.selectOne("comment.get_pid", c_dto);
	}

//	원댓글목록 불러오기 02.21 장민실
	public List<CommentDto> replyList(int video_id) {
		return sqlSession.selectList("comment.replyList", video_id);
	}
	
//	대댓글 목록 불러오기 02.23 장민실
	public List<CommentDto> cocomList(int pid) {
		return sqlSession.selectList("comment.cocomList", pid);
	}

//	댓글 삭제 02.23 장민실
	public void delete(int comment_id) {
		sqlSession.delete("comment.delete", comment_id);
	}

//	미완 주석처리
	public void edit(CommentDto dto) {
		sqlSession.update("comment.edit", dto);
	}

	

	







	

}
