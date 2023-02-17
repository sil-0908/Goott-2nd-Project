package com.test.test1.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.test1.user.dao.UserDao;
import com.test.test1.user.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	
	@Override
	public boolean create(UserDto userDto) {
		return userDao.create(userDto);
	}
	
	@Override
	public String login(UserDto userDto) {
		return userDao.login(userDto);
	}
	
	@Override
	public String idCheck(String id) {
		return userDao.idCheck(id);
	}

	@Override
	public int userIdx(String user) {
		return userDao.userIdx(user);
	}

	@Override
	public String findid(String email) {
		return userDao.findid(email);
	}

	@Override
	public String findpw(UserDto dto) {
		return userDao.findpw(dto);
	}

	@Override
	public String emailCheck(String email) {
		return userDao.emailCheck(email);
	}

	public void paid(Map<String, Object> map) {
		userDao.paid(map);
	}

	public void changepw(UserDto dto) {
		userDao.changepw(dto);
	}
	
	@Override
	public int getid(String id) {
		return userDao.getid(id);
	}

	// 개인정보상세조회  
	@Override
	public UserDto detail(String user_id) {
		return userDao.detail(user_id);
	}




}






	
