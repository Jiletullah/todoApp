package com.ismaildogukancokluk_todo.exception;

import javassist.NotFoundException;

public class UserNotFoundException extends NotFoundException{
	
	public UserNotFoundException(String searchedBy) {
		super("user searched by " + searchedBy +  " not found");
	}
	
}
