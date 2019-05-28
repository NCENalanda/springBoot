package com.jpa.api.dto;

public class CustomError {
	
	private int     errorcode;
	private String  errorMessage;
	public CustomError() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomError(int errorcode, String errorMessage) {
		super();
		this.errorcode = errorcode;
		this.errorMessage = errorMessage;
	}
	public int getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
