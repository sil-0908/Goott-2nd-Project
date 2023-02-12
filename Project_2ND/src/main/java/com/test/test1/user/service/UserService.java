package com.test.test1.user.service;

import java.util.List;

import com.test.test1.user.dto.UserDto;

public interface UserService {


	boolean create(UserDto userDto);

	List<UserDto> list();

	String login(UserDto userDto);

	String idCheck(String id);

	List<UserDto> mydetail(String user_id);

	int modifyDetail(UserDto userDto);

	int userIdx(String user);

	String findid(String email);

	void findpw(UserDto dto);


}

