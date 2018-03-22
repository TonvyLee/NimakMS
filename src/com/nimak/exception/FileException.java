package com.nimak.exception;

import java.io.IOException;

public class FileException extends IOException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public FileException(String fileErrorMsg) {
		super();
		this.fileErrorMsg = fileErrorMsg;
	}

	private String fileErrorMsg;

	public String getFileErrorMsg() {
		return fileErrorMsg;
	}

	public void setFileErrorMsg(String fileErrorMsg) {
		this.fileErrorMsg = fileErrorMsg;
	}
	

}
