package com.automobiles.constant;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Constant {

	static Date date=new Date();
	static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static String formattedDate = formatter.format(date);
	public static final String  DATETIME = formattedDate;

	
	public static final String SUCCESS="success";
	public static final String FAIL="fail";
	
	public static final String EXCEL_READ_DATA_SUCCESS="Excel Data Uploaded Successfully";
	public static final String PASSWORD_CHANGE_FAIL="Failed to change password";
	public static final String PASSWORD_CHANGE_SUCCESS="User password changed Successfully";
	public static final String USER_LOGIN_SUCCESS="User login Successfully";
	public static final String USER_LOGIN_FAIL="Invalid username or password";
	public static final String USER_REGISTER_SUCCESS="User Registered Successfully";
	public static final String USER_ALREADY_EXIST="User Already Exists";

	
	
	
}
