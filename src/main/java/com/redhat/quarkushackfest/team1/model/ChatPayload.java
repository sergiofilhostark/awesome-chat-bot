package com.redhat.quarkushackfest.team1.model;

public class ChatPayload {
	
	private String type;
	private String eventTime;


	private ChatSpace space;
	private ChatMessage message;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public ChatSpace getSpace() {
		return space;
	}
	public void setSpace(ChatSpace space) {
		this.space = space;
	}
	public ChatMessage getMessage() {
		return message;
	}
	public void setMessage(ChatMessage message) {
		this.message = message;
	}
	
	public String getEventTime() {
		return eventTime;
	}
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	
	@Override
	public String toString() {
		return "ChatPayload [type=" + type + ", eventType=" + eventTime + ", space=" + space + ", message=" + message
				+ "]";
	}
	
	

}
