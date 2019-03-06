package com.automobiles.customexception;

public class CustomException{
	private String message;
	private String status;
	
	 public CustomException(String status,String message){
	        this.status= status;
	        this.message = message;
	    }
	 
	 public CustomException(String message) {
		 this.message = message;
	 }

	 	public String getStatus() {
	 		return status;
		}
	 
		public String getMessage() {
	        return message;
	    }
		
		
		
		
}
