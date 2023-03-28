package com.projectincedoplay.reglog.UserEntitya;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User_Data")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userid;
	@Column(name = "full_name")
	private String name;
	
	@Column(name = "email_id", unique = true)
	private String emailId;
	
	@Column(name = "password")
	private String password;
	
	
	public User() {
		super();
	}

	public User(int userid, String name, String emailId, String password) {
		super();
		this.userid = userid;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", emailId=" + emailId + ", password=" + password + "]";
	}

}
