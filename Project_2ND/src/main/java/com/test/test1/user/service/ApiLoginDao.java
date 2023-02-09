package com.test.test1.user.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ApiLoginDao {

	@Autowired
	SqlSession session;
	
	public String apiCheck(String email) {
		return session.selectOne("user.apiCheck", email);
	}

	
	
}
