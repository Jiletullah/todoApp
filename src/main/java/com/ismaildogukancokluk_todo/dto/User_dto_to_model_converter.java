package com.ismaildogukancokluk_todo.dto;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ismaildogukancokluk_todo.model.User;

@Component
public class User_dto_to_model_converter{
	
	private final Todo_dto_to_model_converter todo_dto_to_model_converter;
	
	//constructor
	public User_dto_to_model_converter() {
		this.todo_dto_to_model_converter = new Todo_dto_to_model_converter();
	}
	
	
	//function
	public User convert(UserDto userDto) {
		User user = new User(userDto.getEmail(),
							 userDto.getUsername(),
							 userDto.getPassword());
		
		user.setTodos(userDto.getTodoDtos().stream()
				.map(t -> todo_dto_to_model_converter.convert(t, user))
				.collect(Collectors.toList()));
		
		return user;
	}
	
	public User convertWithId(UserDto userDto) {
		User user = new User(userDto.getId(),
							 userDto.getEmail(),
							 userDto.getUsername(),
							 userDto.getPassword());
		
		user.setTodos(userDto.getTodoDtos().stream()
				.map(t -> todo_dto_to_model_converter.convert(t, user))
				.collect(Collectors.toList()));
		
		return user;
	}

}
