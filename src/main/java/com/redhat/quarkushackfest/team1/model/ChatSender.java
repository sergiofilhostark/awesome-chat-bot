package com.redhat.quarkushackfest.team1.model;

public class ChatSender {
	
	private String name;
	private String displayName;
	private String avatarUrl;
	private String email;
	
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
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "ChatSender [name=" + name + ", displayName=" + displayName + ", avatarUrl=" + avatarUrl + ", email="
				+ email + "]";
	}

	
}
