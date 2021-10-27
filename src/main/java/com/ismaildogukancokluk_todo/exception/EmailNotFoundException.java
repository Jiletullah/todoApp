package com.ismaildogukancokluk_todo.exception;

import javassist.NotFoundException;

public class EmailNotFoundException extends NotFoundException{
	
	public EmailNotFoundException() {
		super("email not found");
	}
	
}
