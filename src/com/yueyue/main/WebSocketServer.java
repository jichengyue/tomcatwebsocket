package com.yueyue.main;

import java.io.IOException;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class WebSocketServer {
	
	private Set<Session> sessions;
	
	@OnOpen
	public void onOpen(Session session){
		sessions = session.getOpenSessions();
		System.out.println("sessions has "+ session);
	}
	
	@OnClose
	public void onClose(){
		
	}
	
	@OnError
	public void onError(Throwable cause){
		
	}
	
	@OnMessage
	public void onMessage(String message, Session session) throws IOException{
		System.out.println("接收到了消息："+message);
		session.getBasicRemote().sendText(message);
	}
}
