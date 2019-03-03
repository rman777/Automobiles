package com.automobiles.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	private String userfirstname;
	private String userlastname;
	private String usermobile;
	private String userpassword;
	private String usercreated;
	private String userlastlogin;
	private int roleid;
	private int userstatus=1;

	
	public User() {}

	public User(int userid, String userfirstname, String userlastname, String usermobile, String userpassword,
			String usercreated, String userlastlogin, int roleid, int userstatus) {
		super();
		this.userid = userid;
		this.userfirstname = userfirstname;
		this.userlastname = userlastname;
		this.usermobile = usermobile;
		this.userpassword = userpassword;
		this.usercreated = usercreated;
		this.userlastlogin = userlastlogin;
		this.roleid = roleid;
		this.userstatus = userstatus;
	
	}



	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUserfirstname() {
		return userfirstname;
	}

	public void setUserfirstname(String userfirstname) {
		this.userfirstname = userfirstname;
	}

	public String getUserlastname() {
		return userlastname;
	}

	public void setUserlastname(String userlastname) {
		this.userlastname = userlastname;
	}

	public String getUsermobile() {
		return usermobile;
	}

	public void setUsermobile(String usermobile) {
		this.usermobile = usermobile;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getUsercreated() {
		return usercreated;
	}

	public void setUsercreated(String formattedDate) {
		this.usercreated = formattedDate;
	}

	public String getUserlastlogin() {
		return userlastlogin;
	}

	public void setUserlastlogin(String userlastlogin) {
		this.userlastlogin = userlastlogin;
	}

	
	public int getUserstatus() {
		return userstatus;
	}

	public void setUserstatus(int userstatus) {
		this.userstatus = userstatus;
	}


	@Override
	public String toString() {
		return "User [userid=" + userid + ", userfirstname=" + userfirstname + ", userlastname=" + userlastname
				+ ", usermobile=" + usermobile + ", userpassword=" + userpassword + ", usercreated=" + usercreated
				+ ", userlastlogin=" + userlastlogin + ", roleid=" + roleid + ", userstatus=" + userstatus
				+ "]";
	}
	
	
}
