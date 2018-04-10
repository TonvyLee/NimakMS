package com.nimak.exception;

public class DaoException extends Exception{
	
	private String messageString;

	public String getMessageString() {
		return messageString;
	}

	public void setMessageString(String messageString) {
		this.messageString = messageString;
	}
	

}
