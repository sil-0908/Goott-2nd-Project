package com.test.test1.chat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.test.test1.common.AlarmDao;

//Dao DI를위해 사용. 원래 해당 애너테이션도 의존성주입 다른곳에 해주려고 쓰는데 왠지 모르겠는데 DAO null됨
// -> Bean으로 등록되어 있어서 따로 스프링의 객체라고 주입시켜줘야함.
@Component
@RequestMapping("/echo")
public class EchoHandler extends TextWebSocketHandler{
	
	@Autowired
	private AlarmDao alarmDao;
	
	public void setAlarmDao(AlarmDao alarmDao) {
		this.alarmDao = alarmDao;
	}

	
	private static final Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);
	//로그인 한 인원 전체
	private List<WebSocketSession> sessions = new ArrayList<WebSocketSession>();
	// 개인
	//private Map<String, WebSocketSession> userSessionsMap = new HashMap<String, WebSocketSession>();
	
	//클라이언트가 웹 소켓 생성
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		logger.info("Socket 연결");
		//웹 소켓이 생성될 때마다 리스트에 넣어줌
		sessions.add(session);
	}
	
	//JS에서 메세지 받을 때.
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {// 메시지
	
		for(WebSocketSession single : sessions) {
			String msg = message.getPayload();
			String[] str = msg.split(",");
			//JS에서 원하는대로 send하여 해당 기능 별 알람 구현
			//질문에 답변 달렸을 때(질문자 ID와 제목 들고옴)
			if(str != null && str.length == 2) {
				String id = str[0];
				String q_subject = str[1];
				int count = alarmDao.selectAlarmCount(id); //알람이 존재할 때
			}		
			
			System.out.println(single.getId());
			System.out.println(session.getId());
			System.out.println(single.getAttributes().get("user_id"));
			System.out.println(session.getAttributes().get("user_id"));
			
			//세션값이 같을때, 알람보낼 것이 있을 때만 전송 -> 로그인 한 사용자가 처음으로 알람 받는 순간임
			//해당 sendMsg에 DB정보 넣어서 체크 안된 알람 전부 전송하기
			if(single.getId().equals(session.getId())) {
				TextMessage sendMsg = new TextMessage("알람 발생");
				single.sendMessage(sendMsg);
			}

			//Websocketsession을 handshake Inteceptor을 통해 httpsession값을 가져올 수 있음
			//System.out.println(single.getAttributes().get("user_id"));
			//System.out.println(session.getAttributes().get("user_id"));
				

		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {//연결 해제
		// TODO Auto-generated method stub
		logger.info("Socket 끊음");
		//웹 소켓이 종료될 때마다 리스트에서 뺀다.
		sessions.remove(session);
	}
}