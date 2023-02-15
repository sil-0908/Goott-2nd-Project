package com.test.test1.user.service;

import java.util.List;
import java.util.Map;

import com.test.test1.user.dto.UserDto;

public interface UserService {


	boolean create(UserDto userDto);

	List<UserDto> list();

	String login(UserDto userDto);

	String idCheck(String id);
	
	String emailCheck(String email);

	List<UserDto> mydetail(String user_id);

	int modifyDetail(UserDto userDto);

	int userIdx(String user);

	String findid(String email);

	String findpw(UserDto dto);

	void changepw(UserDto dto);

	// 미완성
//	int getid(String id);

	void paid(Map<String, Object> map);

	


}

