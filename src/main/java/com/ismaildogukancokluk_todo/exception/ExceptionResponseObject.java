package com.ismaildogukancokluk_todo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ExceptionResponseObject {
	
	private final String message;

	private final HttpStatus httpStatus;
	private final LocalDateTime timestamp;
	
	
	public ExceptionResponseObject(String message, HttpStatus httpStatus,
			LocalDateTime timestamp) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
		this.timestamp = timestamp;
	}


	public String getMessage() {
		return message;
	}


	public HttpStatus getHttpStatus() {
		return httpStatus;
	}


	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
	

}
