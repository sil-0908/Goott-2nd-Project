package com.test.test1.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiLoginServiceImpl implements ApiLoginService {

	@Autowired
	ApiLoginDao apiLoginDao;
	
	@Override
	public String apiCheck(String email) {
		return apiLoginDao.apiCheck(email);
	}

}
