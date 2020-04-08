package com.redhat.quarkushackfest.team1.model;

public class ChatSpace {
	
	private String name;
	private String displayName;
	private String type;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "ChatSpace [name=" + name + ", displayName=" + displayName + ", type=" + type + "]";
	}
	

}
