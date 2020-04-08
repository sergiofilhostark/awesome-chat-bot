package com.redhat.quarkushackfest.team1.model;

public class ChatMessage {
	
	private String name;
	private ChatSender sender;
	private String createTime;
	private String text;
	private ChatThread thread;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ChatSender getSender() {
		return sender;
	}
	public void setSender(ChatSender sender) {
		this.sender = sender;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public ChatThread getThread() {
		return thread;
	}
	public void setThread(ChatThread thread) {
		this.thread = thread;
	}
	
	@Override
	public String toString() {
		return "ChatMessage [name=" + name + ", sender=" + sender + ", createTime=" + createTime + ", text=" + text
				+ ", thread=" + thread + "]";
	}
	
	

}
