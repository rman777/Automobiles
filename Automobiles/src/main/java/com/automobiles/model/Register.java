package com.automobiles.model;

import java.sql.Date;

public class Register {

	private int user_id;
	private String user_first_name;
	private String user_last_name;
	private int user_mobile;
	private String user_email;
	private String user_password;
	private int user_status;
	private Date user_created;
	private Date user_last_login;
	private int role_id;
	private int dept_id;
	
	public Register() {}
	
	
	public Register(int user_id, String user_first_name, String user_last_name, int user_mobile, String user_email,
			String user_password, int user_status, Date user_created, Date user_last_login, int role_id, int dept_id) {
		super();
		this.user_id = user_id;
		this.user_first_name = user_first_name;
		this.user_last_name = user_last_name;
		this.user_mobile = user_mobile;
		this.user_email = user_email;
		this.user_password = user_password;
		this.user_status = user_status;
		this.user_created = user_created;
		this.user_last_login = user_last_login;
		this.role_id = role_id;
		this.dept_id = dept_id;
	}




	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_first_name() {
		return user_first_name;
	}
	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}
	public String getUser_last_name() {
		return user_last_name;
	}
	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}
	public int getUser_mobile() {
		return user_mobile;
	}
	public void setUser_mobile(int user_mobile) {
		this.user_mobile = user_mobile;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public int getUser_status() {
		return user_status;
	}
	public void setUser_status(int user_status) {
		this.user_status = user_status;
	}
	public Date getUser_created() {
		return user_created;
	}
	public void setUser_created(Date user_created) {
		this.user_created = user_created;
	}
	public Date getUser_last_login() {
		return user_last_login;
	}
	public void setUser_last_login(Date user_last_login) {
		this.user_last_login = user_last_login;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}


	@Override
	public String toString() {
		return "Register [user_id=" + user_id + ", user_first_name=" + user_first_name + ", user_last_name="
				+ user_last_name + ", user_mobile=" + user_mobile + ", user_email=" + user_email + ", user_password="
				+ user_password + ", user_status=" + user_status + ", user_created=" + user_created
				+ ", user_last_login=" + user_last_login + ", role_id=" + role_id + ", dept_id=" + dept_id + "]";
	}
	
	
	
	
}
