package com.bah.msd.mcc.domain;

public class Customer {
	

	String name;
	String password;
	String email;
	public Customer(String name, String password, String email) {
		this.email = email;
		this.name = name;
		this.password = password;
	}
	public Customer() {}
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
