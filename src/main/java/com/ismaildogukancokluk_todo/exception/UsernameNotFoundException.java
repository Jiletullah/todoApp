package com.ismaildogukancokluk_todo.exception;

import javassist.NotFoundException;

public class UsernameNotFoundException extends NotFoundException{

	public UsernameNotFoundException() {
		super("username not found");
	}
	
}
