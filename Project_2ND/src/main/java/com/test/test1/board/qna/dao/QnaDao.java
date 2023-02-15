package com.test.test1.board.qna.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.test1.board.qna.dto.Criteria;
import com.test.test1.board.qna.dto.QnaDto;

@Repository
public class QnaDao {

	@Autowired
	SqlSession ss;
	
	//게시판 리스트 - 02.07 장재호
	public List<QnaDto> list(Criteria cri) throws Exception {
		return ss.selectList("qna.q_list", cri);
	}
	

	public int listCount(Criteria cri) {
		System.out.println("option = "+ cri.getOption());
		System.out.println("key = "+ cri.getKeyword());
		return ss.selectOne("qna.listCount", cri);
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
	//한번에 다 처리하려했는데 mybatis에서 안받아줌
//	public List<QnaDto> qnaSearch(Criteria cri) {
//		//1.닉네임검색
//		if(cri.getOption().equals("NICKNAME")) {
//			return(ss.selectList("qna.qnaSearch1", cri));
//		}//2.제목검색
//		else if(cri.getOption().equals("SUBJECT")) {
//			return(ss.selectList("qna.qnaSearch2", cri));
//		}//3.내용
////		else if(qnaDto.getOption().equals("CONTENT")) {
//			return(ss.selectList("qna.qnaSearch3", cri));
////		}//4.제목내용
////		else return(ss.selectList("qna.qnaSearch4", qnaDto));
//	}


	
}
