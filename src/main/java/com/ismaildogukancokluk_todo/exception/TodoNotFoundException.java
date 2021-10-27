package com.ismaildogukancokluk_todo.exception;

import javassist.NotFoundException;


public class TodoNotFoundException extends NotFoundException{
	
	public TodoNotFoundException(String searchedBy) {
		super("todo searched by " + searchedBy +  " not found");
	}
	
}
