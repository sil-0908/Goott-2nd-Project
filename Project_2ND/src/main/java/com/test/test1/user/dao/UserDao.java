package com.test.test1.user.dao;

import java.util.List;
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
	
	//개인 정보 조회 - 01.31 장재호
	public List<UserDto> mydetail(String id) {
		return sqlSessionTemplate.selectList("user.mydetail", id);		
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

	//qna등록 시 user Key값 받아오기 - 02.07 장재호
	public int userIdx(String user) {
		return sqlSessionTemplate.selectOne("user.idx", user);
	}

	public String findid(String email) {
		return sqlSessionTemplate.selectOne("user.findid", email);
	}

	public void findpw(UserDto dto) {
		sqlSessionTemplate.selectOne("user.findpw", dto);
		
	}

	//결제 처리 - 02.15 장재호
	public void paid(Map<String, Object> map) {
		sqlSessionTemplate.update("user.paid", map);
	}
	
}
