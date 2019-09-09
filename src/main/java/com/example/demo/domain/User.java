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
	private String uid;
	private String name;
	private String email;
	private String password;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getNum() {
		return num;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
//	public String getPassword() {
//		return password;
//	}
	public void setNum(long num) {
		this.num = num;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isMatchPassword(String inPassword) {
		if(inPassword == null || !inPassword.equals(this.password)) return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "User [num=" + num + ", uid=" + uid + ", name=" + name + ", email=" + email + ", password=" + password
				+ "]";
	}
	public void update(User userInfo) {
		this.name = userInfo.name;
		this.email = userInfo.email;
		this.password = userInfo.password;
		
	}
	
	
	
}
