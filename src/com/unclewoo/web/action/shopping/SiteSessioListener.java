package com.unclewoo.web.action.shopping;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SiteSessioListener implements HttpSessionListener{

	private static Map<String, HttpSession> sessions = new HashMap<String, HttpSession>();
	
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		System.out.println(sessionEvent.getSession().getId());
		sessions.put(sessionEvent.getSession().getId(), sessionEvent.getSession());
		
	}
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		sessions.remove(sessionEvent.getSession().getId());
	}
	
	public static HttpSession getSession(String sessionID){
		return sessions.get(sessionID);
	}
	
	public static void removeSession(String sessionID){
		if(sessions.containsKey(sessionID)){
			sessions.remove(sessionID);
		}
	}

}
