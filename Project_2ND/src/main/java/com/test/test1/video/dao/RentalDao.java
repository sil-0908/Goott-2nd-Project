package com.test.test1.video.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.test.test1.video.dto.RentalDTO;

@Repository
public class RentalDao {
	
	@Inject
	SqlSession sqlSession;

	public void insert(RentalDTO dto) {
		sqlSession.insert("rental.insert", dto);
	}

	public void delete(RentalDTO dto) {
		sqlSession.delete("rental.delete", dto);
	}
	
	
}
