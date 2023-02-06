package com.test.test1.user.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.test1.user.dto.UserDto;

@Repository
public class UserDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	//이메일 중복확인 버튼 기능 - 01.31 장재호
	public String emailCheck(String email) {
		String check = null; //check : 이메일 중복 값이 있다면 담김
		check = this.sqlSessionTemplate.selectOne("user.email_check", email);
		return check;
	}
	
	//회원 가입 - 01.31 장재호
	public boolean create(UserDto userDto) {
		String checkTF = this.sqlSessionTemplate.selectOne("user.signUpCheck", userDto);  //checkTF : 닉네임 중복이되면 중복 값을 담는다
		if(checkTF == null) { // 중복 없음
			sqlSessionTemplate.insert("user.insert", userDto);
			return true;
		}
		else return false;
	}
	
	//로그인 - 01.31 장재호
	public String login(UserDto userDto) {
		return sqlSessionTemplate.selectOne("user.login", userDto);
	}
	
	//개인 정보 조회 - 01.31 장재호
	public List<UserDto> mydetail(String email) {
		return sqlSessionTemplate.selectList("user.mydetail", email);		
	}
	
	//회원 정보 수정 - 01.31 장재호
	public int modify_detail(UserDto userDto) {
		//정보 수정 시 nickname중복 확인이 필요하기 때문에 만들어놓은 mybatis의 signUpCheck 그대로 사용
		String checkTF = sqlSessionTemplate.selectOne("user.signUpCheck", userDto);
		if(checkTF == null) {
			return sqlSessionTemplate.update("user.modify_detail", userDto);
		} else {
			return -1; //중복일 때 반환해서 중복이라고 알림
		}
	}

	//전체 조회 - 01.31 장재호
	public List<UserDto> list() {
		return sqlSessionTemplate.selectList("user.list");
		
	}
	

	
}
