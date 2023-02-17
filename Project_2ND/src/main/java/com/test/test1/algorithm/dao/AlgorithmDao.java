package com.test.test1.algorithm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.test1.algorithm.dto.AlgorithmDto;

@Repository
public class AlgorithmDao {

	@Autowired
	SqlSession session;
	
	//DB에 VIDEO_ID가 이미 있는지 - 02.15 장재호
	public Integer check(Map<String, Object> map) {
		System.out.println("return : " + session.selectOne("algo.check", map));
		return session.selectOne("algo.check", map);
	}

	//처음 클릭 시 insert - 02.15 장재호
	public void insert(Map<String, Object> map) {
		session.insert("algo.insert", map);
	}

	//중복 클릭 시 클릭 수 추가 - 02.15 장재호
	public void update(Map<String, Object> map) {
		session.insert("algo.update", map);
	}

	public List<AlgorithmDto> categoryRate() {
		return session.selectList("algo.category");
	}

	public List<AlgorithmDto> genreRate() {
		return session.selectList("algo.genre");
	}	
	
}
