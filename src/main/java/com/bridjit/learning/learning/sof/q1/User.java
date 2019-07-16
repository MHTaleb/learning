package com.bridjit.learning.learning.sof.q1;

public class User {
	private String name;
	private String username;
	private String email;

	public User(String name, String username, String email) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
	}

	public void mutate(String name, String username) {
		System.out.println("this is a mutation");
	}
	
	public void reflectAll(String name, String username, String email) {
		System.out.println("this is a full reflection");
	}
	
	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
