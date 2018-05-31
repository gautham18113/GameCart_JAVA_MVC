package com.catp.cgc.vo;

public class CustomerScreenBean {
	private String name;
	private String email;
	private String password;
	private String request;
	private String playerID;

	public String getPlayerID() {
		return playerID;
	}
	public void setPlayerID(String playerID) {
		this.playerID = playerID;
	}
	public String getRequest() {
		return request;
	}
	public String setRequest(String request) {
		return this.request = request;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Object submit;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}



	}


