package com.automobiles.customexception;

public class CustomException{
	private String message;
	 public CustomException(String message){
	        this.message = message;
	    }
	 
	    public String getErrorMessage() {
	        return message;
	    }
}
