package com.ismaildogukancokluk_todo.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ismaildogukancokluk_todo.exception.BadRequestTypeException;
import com.ismaildogukancokluk_todo.exception.EmailAlreadyInUseException;
import com.ismaildogukancokluk_todo.exception.EmailNotFoundException;
import com.ismaildogukancokluk_todo.exception.ExceptionResponseObject;
import com.ismaildogukancokluk_todo.exception.TodoNotFoundException;
import com.ismaildogukancokluk_todo.exception.UsernameNotFoundException;
import com.ismaildogukancokluk_todo.exception.UserNotFoundException;
import com.ismaildogukancokluk_todo.exception.UsernameAlreadyInUseException;


@ControllerAdvice
public class Exception_Handler {
	
	
	@ExceptionHandler(value = {EmailNotFoundException.class})
	public ResponseEntity<Object> handleEmailNotFoundException(EmailNotFoundException e){
		
		HttpStatus notfound = HttpStatus.NOT_FOUND;
		
		ExceptionResponseObject ero = new ExceptionResponseObject
										(e.getMessage(), notfound , LocalDateTime.now());
		
		return new ResponseEntity<>(ero,notfound);
		
	}
	
	
	
	@ExceptionHandler(value = {UserNotFoundException.class})
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException e){
		
		HttpStatus notfound = HttpStatus.NOT_FOUND;
		
		ExceptionResponseObject ero = new ExceptionResponseObject
										(e.getMessage(), notfound , LocalDateTime.now());
		
		return new ResponseEntity<>(ero,notfound);
		
	}
	
	
	
	@ExceptionHandler(value = {TodoNotFoundException.class})
	public ResponseEntity<Object> handleTodoNotFoundException(TodoNotFoundException e){
		
		HttpStatus notfound = HttpStatus.NOT_FOUND;
		
		ExceptionResponseObject ero = new ExceptionResponseObject
										(e.getMessage(), notfound , LocalDateTime.now());
		
		return new ResponseEntity<>(ero,notfound);
		
	}
	
	
	
	@ExceptionHandler(value = {UsernameNotFoundException.class})
	public ResponseEntity<Object> handleUserNameNotFoundException(UsernameNotFoundException e){
		
		HttpStatus notfound = HttpStatus.NOT_FOUND;
		
		ExceptionResponseObject ero = new ExceptionResponseObject
										(e.getMessage(), notfound , LocalDateTime.now());
		
		return new ResponseEntity<>(ero,notfound);
		
	}
	
	
	
	@ExceptionHandler(value = {EmailAlreadyInUseException.class})
	public ResponseEntity<Object> handleEmailAlreadyInUseException(EmailAlreadyInUseException e){
		
		HttpStatus already = HttpStatus.ALREADY_REPORTED;
		
		ExceptionResponseObject ero = new ExceptionResponseObject
										(e.getMessage(), already , LocalDateTime.now());
		
		return new ResponseEntity<>(ero,already);
		
	}
	
	
	
	@ExceptionHandler(value = {UsernameAlreadyInUseException.class})
	public ResponseEntity<Object> handleUsernameAlreadyInUseException(UsernameAlreadyInUseException e){
		
		HttpStatus already = HttpStatus.ALREADY_REPORTED;
		
		ExceptionResponseObject ero = new ExceptionResponseObject
										(e.getMessage(), already , LocalDateTime.now());
		
		return new ResponseEntity<>(ero,already);
		
	}
	
	
	@ExceptionHandler(value = {BadRequestTypeException.class})
	public ResponseEntity<Object> handleBadRequestTypeException(BadRequestTypeException e){
		
		HttpStatus bad = HttpStatus.BAD_REQUEST;
		
		ExceptionResponseObject ero = new ExceptionResponseObject
										(e.getMessage(), bad , LocalDateTime.now());
		
		return new ResponseEntity<>(ero,bad);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
