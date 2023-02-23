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
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {// 메시지

		for(WebSocketSession single : sessions) {
			String id = message.getPayload();
			int count = alarmDao.selectAlarmCount(id);
			
			System.out.println(single.getId());
			System.out.println(session.getId());
			System.out.println(single.getAttributes().get("user_id"));
			System.out.println(session.getAttributes().get("user_id"));
			//리스트에 담긴 세션의 id와 메세지를 보내줄 세션의 id가 같고, uchkList가 0이 아닐 경우 메세지 전송
			if(single.getId().equals(session.getId()) && count != 0) {
				TextMessage sendMsg = new TextMessage(id + "님 새 알림이 있습니다");
				single.sendMessage(sendMsg);
			}
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