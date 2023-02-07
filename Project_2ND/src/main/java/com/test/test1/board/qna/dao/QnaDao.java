package com.test.test1.board.qna.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.test1.board.qna.dto.QnaDto;

@Repository
public class QnaDao {

	@Autowired
	SqlSession ss;
	
	//게시판 리스트 - 02.07 장재호
	public List<QnaDto> list() {
		return ss.selectList("qna.q_list");
	}
	
	//질문 생성 - 02.07 장재호
	public void qCreate(QnaDto qnaDto) {
		ss.insert("qna.q_create", qnaDto);

	}

	public QnaDto detail(int question_id) {		
		return ss.selectOne("qna.detail", question_id);
	}

	public void modify(QnaDto qnaDto) {
		ss.update("qna.modify", qnaDto);
	}

	//삭제 - 02.07 장재호
	public void delete(int question_id) {
		ss.delete("qna.delete", question_id);		
//		//auto_increment 재정렬
//		int asc = ss.selectOne("qna.lastNum"); //asc : 가장 마지막 번호
//		System.out.println("      asc     =      "        + asc);
//		ss.update("qna.autoincrementReset", asc);
	}

	//조건 별 검색기능 - 02.07 장재호
	public List<QnaDto> qnaSearch(String keyword, String option) {
		Map<String, String> map = new HashMap<>(); //map : 검색 상세조건 및 키워드
		//option이 제목,내용 포함일 때
		if(option.contains(",")) {
			map.put("keyword", keyword);
			map.put("option1", option.split(",")[0]);
			map.put("option2", option.split(",")[1]);
			return ss.selectList("qna.qnaSearch3", map);
		}
		else if(option.length()==8) {
			map.put("keyword", keyword);
			map.put("option", option);
			System.out.println(map.get("keyword"));
			return ss.selectList("qna.qnaSearch1", map);
		}
		else {
			map.put("keyword", keyword);
			map.put("option", option);
			System.out.println(map);
			return ss.selectList("qna.qnaSearch2", map);
		}
	}
	
}
