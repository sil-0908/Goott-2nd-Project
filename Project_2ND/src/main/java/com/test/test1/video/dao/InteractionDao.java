package com.test.test1.video.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.test1.video.dto.InteractionDto;

@Repository
public class InteractionDao {
	
	@Autowired
	SqlSession sqlSession;

//	public void video_like(InteractionDto i_dto) {
//		sqlSession.insert("interaction.video_like", i_dto);
//	}
//
//	public List<InteractionDto> video_check_list(Map<String, Object> map2) {
//		return sqlSession.selectList("interaction.video_check_list", map2);
//	}

}
