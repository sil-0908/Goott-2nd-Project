package com.test.test1.common;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.test1.board.qna.dto.QnaDto;

/* 02.23 장재호 */
@Repository
public class AlarmDao {
	
	@Autowired
	SqlSession ss;

	public int selectAlarmCount(String id) throws Exception{
		return ss.selectOne("alarm.alarmSelect", id);		
	}

	public void addQnaAlarm(QnaDto qnaDto) {
		if(ss.selectOne("alarm.checkUser", qnaDto) != null) {
			ss.insert("alarm.addQna", qnaDto);
		}
	}

}
/* 02.23 장재호 */