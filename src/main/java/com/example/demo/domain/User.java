package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue // 자동증가 (auto increments)
	private long num;
	
	@Column(nullable=false, length=20)
	private String id;
	private String name;
	private String email;
	private String password;
	public void setName(String name) {
		this.name = name;
	}
	public long getNum() {
		return num;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [num=" + num + ", id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ "]";
	}
	public void update(User userInfo) {
		this.name = userInfo.name;
		this.email = userInfo.email;
		this.password = userInfo.password;
		
	}
	
	
	
}
