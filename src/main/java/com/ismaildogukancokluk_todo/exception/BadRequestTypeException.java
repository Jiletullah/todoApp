package com.ismaildogukancokluk_todo.exception;


public class BadRequestTypeException extends Exception{
	
	public BadRequestTypeException(String requstType) {
		super("bad request type, request type "+ requstType +" other than 0,1,2");
	}
	
}
