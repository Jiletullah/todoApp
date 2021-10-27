package com.ismaildogukancokluk_todo.exception;

import javax.management.InstanceAlreadyExistsException;

public class UsernameAlreadyInUseException extends InstanceAlreadyExistsException{
	
	public UsernameAlreadyInUseException(String username) {
		super("username: " + username + " already in use");
	}
	
}
