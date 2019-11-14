package com.bah.msd.mcc.domain;

public class TokenRequestData {
	String name;
	String password;
	String scopes;
	public TokenRequestData() {}
	public TokenRequestData(String username, String password, String scopes) {
		this.name = username;
		this.password = password;
		this.scopes = scopes;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getScopes() {
		return scopes;
	}
	public void setScopes(String scopes) {
		this.scopes = scopes;
	}
}
