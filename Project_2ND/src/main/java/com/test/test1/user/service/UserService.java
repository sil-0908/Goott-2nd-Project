package com.test.test1.user.service;

import java.util.List;

import com.test.test1.user.dto.UserDto;

public interface UserService {

	boolean create(UserDto userDto);

	List<UserDto> list();

	String login(UserDto userDto);

	String emailCheck(String email);

	List<UserDto> mydetail(String user_email);

	int modifyDetail(UserDto userDto);



}

