package com.automobiles.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roleid;
	private String rolename;
	private int roleflag = 1;
	
	public Role() {}
	
	
	
	public Role(int roleid, String rolename, int roleflag) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
		this.roleflag = roleflag;
	}


	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public int getRoleflag() {
		return roleflag;
	}
	public void setRoleflag(int roleflag) {
		this.roleflag = roleflag;
	}



	@Override
	public String toString() {
		return "Role [roleid=" + roleid + ", rolename=" + rolename + ", roleflag=" + roleflag + "]";
	}
	
	
	
}
