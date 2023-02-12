package com.test.test1.chat;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatHandler extends TextWebSocketHandler{


    private static Logger log = LoggerFactory.getLogger(ChatHandler.class);

	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		log.info("#ChatHandler, afterConnectionEstablished");
		sessionList.add(session);
		
		log.info("{} 연결됨", session.getId());
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		log.info("#ChatHandler, handleMessage");
		log.info(session.getId() + ": " + message);		
		
		for(WebSocketSession s : sessionList) {
			s.sendMessage(new TextMessage(session.getId() + ":" + message.getPayload()));
		}
		System.out.println("sessionList = " + sessionList);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		
		log.info("#ChatHandler, afterConnectionClosed");

		sessionList.remove(session);
		
		log.info(session.getId() + "님이 퇴장하셨습니다.");
	}
}
