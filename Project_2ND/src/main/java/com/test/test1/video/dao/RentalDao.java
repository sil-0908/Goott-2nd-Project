package com.test.test1.video.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.test.test1.video.dto.RentalDTO;
import com.test.test1.video.dto.VideoDto;

@Repository
public class RentalDao {
	
	@Inject
	SqlSession sqlSession;

	// rental_id를 입력
	public void insert(RentalDTO dto) {
		sqlSession.insert("rental.insert", dto);
	}

	// rental_id를 삭제
	public void delete(RentalDTO dto) {
		sqlSession.delete("rental.delete", dto);
	}
	
	// 해당 유저와 비디오 아이디에 맞는 rental_id를 가져옴
	public String getid(RentalDTO dto) {
		return sqlSession.selectOne("rental.getid", dto);
	}

	// 미완성 - 해당 유저가 찜한 video 리스트를 불러옴
//	public List<VideoDto> list(String id) {
//		return sqlSession.selectList("rental.list", id);
//	}

}
