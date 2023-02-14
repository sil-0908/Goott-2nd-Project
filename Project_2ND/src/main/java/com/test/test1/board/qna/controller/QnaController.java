package com.test.test1.board.qna.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.test1.board.qna.dto.Criteria;
import com.test.test1.board.qna.dto.PageMaker;
import com.test.test1.board.qna.dto.QnaDto;
import com.test.test1.board.qna.service.QnaService;
import com.test.test1.user.service.UserService;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@Autowired
	QnaService qnaService;
	@Autowired
	UserService userService;	
	
	//qna 게시판 출력 - 02.07 장재호
	//user Key값으로 닉네임을 리스트에 출력
	@RequestMapping("list")
	public ModelAndView qnaList(ModelAndView mv, Criteria cri) throws Exception {
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri); //page, perpagenum 셋팅
		pageMaker.setTotalCount(qnaService.listCount(cri)); //총 게시글 수 셋팅
		System.out.println("count = " + qnaService.listCount(cri));
		
		//View에 페이징 처리를 위한 조건 및 그에 맞는 게시판 리스트 전송
		mv.addObject("pageMaker", pageMaker);
		mv.addObject("data", qnaService.list(cri)); 
		
		mv.setViewName("board/qna/qna_list");

		return mv;
		
	}
	
	//질문생성 페이지 - 02.07 장재호
	@RequestMapping("create")
	public String qCreate() {
		return "board/qna/qna_create";
	}
	
	//질문생성하기 - 02.07 장재호
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String qCreate(QnaDto qnaDto, HttpSession session) {
		String user = session.getAttribute("user_email").toString();
		System.out.println();
		int idx = userService.userIdx(user); // idx : user Key값
		
		qnaDto.setUser_id(idx);
		qnaService.qCreate(qnaDto);
		return "redirect:/qna/list";
	}
	
	//QNA 상세 - 02.07 장재호
	@RequestMapping("list/{question_id}")
	public ModelAndView qnaDetail(ModelAndView mv, @PathVariable int question_id) {
		mv.addObject("data", qnaService.detail(question_id));
		mv.setViewName("board/qna/qna_detail");
		return mv;
	}
	
	//질문 수정페이지 접근 - 02.07 장재호
	@RequestMapping("modify/{question_id}")
	public String modifyPage() {
		return "board/qna/qna_modify";
	}
	
	//수정하기 - 02.07 장재호
	@RequestMapping(value="modify/{question_id}", method=RequestMethod.POST)
	public String qnaModify(ModelAndView mv, QnaDto qnaDto, @PathVariable int question_id) {
		qnaService.modify(qnaDto);
		return "redirect:/qna/list/{question_id}";
	}
	
	//삭제하기 - 02.07 장재호
	@RequestMapping("qnaDelete")
	public String qnaDelete(int question_id) {
		qnaService.delete(question_id);
		return "redirect:/qna/list";
	}	

}
