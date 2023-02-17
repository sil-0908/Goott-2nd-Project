package com.test.test1.user.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.test.test1.user.dto.UserDto;

@Repository
public class UserDao {
	
	@Autowired
	BCryptPasswordEncoder encoder;	
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	//id 중복확인 버튼 기능 - 01.31 장재호
	public String idCheck(String id) {
		String check = null; //check : id 중복 값이 있다면 담김
		check = this.sqlSessionTemplate.selectOne("user.id_check", id);
		return check;
	}
	
	//회원 가입 - 01.31 장재호
	public boolean create(UserDto userDto) {
		String checkTF = this.sqlSessionTemplate.selectOne("user.signUpCheck", userDto);  //checkTF : 닉네임 중복이되면 중복 값을 담는다
		if(checkTF == null) { // 중복 없음
			System.out.println(userDto.getPassword());
			sqlSessionTemplate.insert("user.insert", userDto);
			return true;
		}
		else return false;
	}
	
	//로그인 - 01.31 장재호
	public String login(UserDto userDto) {
		String pw = sqlSessionTemplate.selectOne("user.pwGet", userDto);// pw : DB에 암호화 된 userPW
		
		if(encoder.matches(userDto.getPassword(), pw)) {                 //비밀번호 일치 시
			return sqlSessionTemplate.selectOne("user.login", userDto);  //nickname값 세션 저장을 위해 return
		}
		else return null;
	}

	//qna등록 시 user Key값 받아오기 - 02.07 장재호
	public int userIdx(String user) {
		return sqlSessionTemplate.selectOne("user.idx", user);
	}

	//아이디 찾기 - 02.10 김범수
	public String findid(String email) {
		return sqlSessionTemplate.selectOne("user.findid", email);
	}

	//비밀번호 찾기 - 02.10 김범수
	public String findpw(UserDto dto) {
		return sqlSessionTemplate.selectOne("user.findpw", dto);
	}

	public String emailCheck(String email) {
		String check1 = null; //check : email 중복 값이 있다면 담김
		check1 = this.sqlSessionTemplate.selectOne("user.email_check", email);
		return check1;
	}
	
	//비밀번호 변경 - 02.12 김범수
	public void changepw(UserDto dto) {
		sqlSessionTemplate.selectOne("user.changepw", dto);
	}

	public int getid(String id) {
		return sqlSessionTemplate.selectOne("user.getid", id);
	}	

	//결제 처리 - 02.15 장재호
	public void paid(Map<String, Object> map) {
		sqlSessionTemplate.update("user.paid", map);
	}
	
	// 개인정보상세조회  02/16 김지혜 
	public UserDto detail(String user_id) {
		return sqlSessionTemplate.selectOne("user.detail", user_id);
	}
	
}
