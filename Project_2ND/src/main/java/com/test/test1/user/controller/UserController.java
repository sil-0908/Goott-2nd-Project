package com.test.test1.user.controller;

import java.util.List;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.test1.user.dao.UserDao;
import com.test.test1.user.dto.UserDto;
import com.test.test1.user.service.UserService;
import com.test.test1.video.dto.RentalDTO;
import com.test.test1.video.dto.VideoDto;
import com.test.test1.video.service.RentalService;
import com.test.test1.video.service.VideoService;

@Controller
@RequestMapping("/user/**")
public class UserController {	

	@Autowired
	UserService userService;
	@Autowired
	UserDao userDao;
	@Autowired
	BCryptPasswordEncoder encoder;
	
	// loger 변수 생성 - 로그데이터를 끌어오기 위함, 0209 김범수
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	// 메일 샌더 객체 생성 - 0209 김범수
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	RentalService rentalService;	
	
	//로그인 페이지 이동 - 01.31 장재호
	@RequestMapping("signin")
	public String login() {
	    return "user/signin";
	}
	
	//로그인 기능  - 01.31 장재호
	//PW -> DB 전송 시 암호화 추가 - 02.06 장재호
	@RequestMapping("signin_check")
	public ModelAndView signin_check(UserDto userDto, HttpSession session, ModelAndView mv) {
		String str = userService.login(userDto);   //str : 유저닉네임(email, pw 일치 시 존재)
		if(str != null) {                          //로그인 성공(세션에 로그인 정보 추가)
			session.setAttribute("user_id", userDto.getId());
			session.setAttribute("nickname", str);
			session.setMaxInactiveInterval(60*30); //세션 유지기간 : 30분
			mv.setViewName("redirect:/");
			mv.addObject("message", "success");
		}else {                                    //로그인 실패
			mv.setViewName("user/signin");
			mv.addObject("message", "error");
		}
		return mv;
	}
	
	//로그아웃 - 01.31 장재호
	@RequestMapping("sign_out")
	public String logout(HttpSession session) {
		session.invalidate(); // 로그아웃 시 세션 초기화
		return "redirect:/";
	}
	
	//회원가입 페이지 이동 - 01.31 장재호
	@RequestMapping("/signup")
	public String create() {
		return "user/signup";
	}
	
	//아이디 중복 확인 버튼 기능 - 01.31 장재호
	@RequestMapping("idCheck")
	@ResponseBody //ajax 요청에 담긴 값을 자바 객체로 변환시켜 인스턴스(boolean)에 저장 -> illegalargumentException 방지
	public boolean idCheck(@RequestParam("id") String id) {
		//DB 들어가서 id 중복값이 있나 들고나옴
		String check = null;
		check = userService.idCheck(id); //check : id파라미터로 DB조회 결과
		if(check != null) return true;         //중복없음
		else return false;		
	}
	
	// 이메일 중복확인 버튼 기능 - 02-13 김지혜 
	@RequestMapping("emailCheck")
	@ResponseBody //ajax 요청에 담긴 값을 자바 객체로 변환시켜 인스턴스(boolean)에 저장 -> illegalargumentException 방지
	public boolean emailCheck(@RequestParam("email") String email) {
		//DB 들어가서 email 중복값이 있으면 check1값은 
		String check1 = null;
		check1 = userService.emailCheck(email); //check : email파라미터로 DB조회 결과
		if(check1 != null) return true;         //중복없음
		else return false;		
	}
	
	//회원가입 기능 - 01.31 장재호
	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public ModelAndView createPost(UserDto userDto) {
	    //암호화하여 DB에 암호 저장

		userDto.setPassword(encoder.encode(userDto.getPassword()));
	    boolean tf = userService.create(userDto); //tf : 닉네임 중복여부 boolean
	    ModelAndView mav = new ModelAndView();

	    if (!tf) { //가입 실패
	        mav.addObject("message", "fault");
	        mav.setViewName("user/signup");
	    }else {   //가입 성공
	        mav.addObject("message", "success");
	        mav.setViewName("common/main");      
	    }
	    return mav;
	}
	

	
	//개인 상세 정보 조회 - 01.31 장재호
	@RequestMapping("mydetail")
	public ModelAndView mydetail(HttpSession session, ModelAndView mv) {		
		String user_id = session.getAttribute("user_id").toString();
		List<UserDto> list = userService.mydetail(user_id); //list : 로그인 된 user_id값에 해당하는 개인 정보

		mv.setViewName("user/mydetail");
		mv.addObject("data", list);
		return mv;
	}
	
	//개인 정보 수정 - 01.31 장재호
	@RequestMapping(value="modify_detail", method=RequestMethod.POST)
	public ModelAndView modify_detail(HttpSession session, UserDto userDto) {

		int modifyTF = userService.modifyDetail(userDto);
		ModelAndView mv = new ModelAndView();
		
		if(modifyTF == -1) {                                         //실패
			mv.addObject("message", "samenick");                     //오류 메세지를 위한 Obj 추가
			return mydetail(session, mv);
		} else {                                                     //성공
			mv.setViewName("common/main");
			mv.addObject("message", "oknick");
			session.setAttribute("nickname", userDto.getNickname()); //성공했으므로 세션 값 변경
		}
		return mv;
	}
	
	//전체조회 - 01.31 장재호
	@RequestMapping("list")
	public ModelAndView list(ModelAndView mv) {
		mv.addObject("data", userService.list());
		mv.setViewName("/user/list");
		return mv;
	}
	
	// 아이디/비밀번호 찾기 페이지 연결 - 02.08 김범수
	@RequestMapping("find")
	public ModelAndView find(ModelAndView mv) {
		mv.setViewName("user/find_id");
		return mv;
	}
	
	// 이메일 인증 - 02.09 김범수
	@RequestMapping(value="/mailCheck", method = RequestMethod.GET)
	@ResponseBody
	public String mailCheckGET(String email) throws Exception{
		//인증번호 생성(난수)
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111; // checkNum에 랜덤한 인증번호가 담김
		logger.info("인증번호" + checkNum); 
		
		// 이메일 보내기 양식
        String setFrom = "GoottFlex";
        String toMail = email;
        String title = "GoottFlex 이메일 인증 메일 전송입니다.";
        String content = 
                "홈페이지를 방문해주셔서 감사합니다." +
                "<br><br>" + 
                "인증 번호는 " + checkNum + "입니다." + 
                "<br>" + 
                "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
        
//        setForm : root-context.xml에 삽입한 자신의 이메일 계정의 이메일 주소 
//        toMail : 수신받을 이메일 - 뷰로부터 받은 이메일 주소인 변수 email을 사용.
//        title : 자신이 보낼 이메일 제목.
//        content : 자신이 보낼 이메일 내용.
        
        try {
        	// MimeMessage : 자바 API, 객체를 직접 생성해 메일을 발송하는 것이 가능
            MimeMessage message = mailSender.createMimeMessage();
            // MimeMessageHelper : MimeMessage 객체를 활용하여 멀티파트 메세지를 보내는 것도 가능, 문자 형식 지정 가능
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8"); 
            // 보낼 내용을 지정하는 MimeMessageHelper의 메소드들
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content,true);
            // 메일 발송
            mailSender.send(message); 
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        // 인증번호를 String 타입으로 변경해서 리턴
        String num = Integer.toString(checkNum); 
		return num;
	}
	
	// 아이디 찾기 - 02.10 김범수
	@RequestMapping(value = "findid", method = RequestMethod.POST)
	@ResponseBody
	// email - view단에서 입력된 email을 가져옴
	public String findid(String email, ModelAndView mv) {
		// email을 이용해 해당 email정보를 가진 id값을 가져옴
		String id = userService.findid(email); 
		return id;
		
	}
	
	// 비밀번호 찾기 - 02.10 김범수
	@RequestMapping(value = "findpw", method = RequestMethod.POST)
	@ResponseBody
	public String findpw(UserDto dto) { // dto에 id와 email 값을 뷰단에서 받아옴
		if(dto.getId() != null && dto.getEmail() != null) {
			String nick = userService.findpw(dto); // dto에 담긴 정보를 토대로 닉네임을 불러옴
			if(nick != null) {
				return "ok"; // ok일시 비밀번호를 바꾸게 할 예정
			}
			else {
				return "no"; // no일시 해당하는 정보가 없다고 메세지 띄움
			}
		}
		return "error";
	}
	
	// 비밀번호 변경 - 02.12 김범수
	@RequestMapping(value ="changepw", method = RequestMethod.POST)
	public String changepw(UserDto dto, BCryptPasswordEncoder encoder) {
		dto.setPassword(encoder.encode(dto.getPassword())); // 비밀번호 암호화
		userService.changepw(dto); // 비밀번호 변경
		return "redirect:/user/signin"; // 비밀번호 변경이 끝나면 로그인페이지로 이동시킴
	}
	
	// 내보관함 기능 구현 - 미완성, 02.15 김범수
//	@RequestMapping("mylocker")
//	public String mylocker(RentalDTO dto, HttpSession session) {
//		String id = (String) session.getAttribute("userid");
//		int videoid = (int) session.getAttribute("video_id");
//		
//		if(id == null) {
//			return "redirect:/user/signin"; // 로그인을 하지않은 사람을 돌려보냄
//		}
//		int userid = userService.getid(id); // USER_ID를 가져오기 위함
//		
//		dto.setId(userid);
//		dto.setVideo_id(videoid);
//		rentalService.insert(dto);
//
//		return "redirect:/video/list"; 
//	}
	
	
}