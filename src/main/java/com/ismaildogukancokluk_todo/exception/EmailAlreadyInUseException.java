package com.ismaildogukancokluk_todo.exception;

import javax.management.InstanceAlreadyExistsException;

public class EmailAlreadyInUseException extends InstanceAlreadyExistsException{
	
	public EmailAlreadyInUseException(String email) {
		super("email: " + email + " already in use");
	}
	
}
