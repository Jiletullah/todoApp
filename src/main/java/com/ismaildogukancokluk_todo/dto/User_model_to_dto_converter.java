package com.ismaildogukancokluk_todo.dto;


import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ismaildogukancokluk_todo.model.User;

@Component
public class User_model_to_dto_converter {

	private final Todo_model_to_dto_converter todo_model_to_dto_converter;
	
	//constructor	
	public User_model_to_dto_converter() {
		this.todo_model_to_dto_converter = new Todo_model_to_dto_converter();
	}
	
	
	//function
	public UserDto convert(User user) {
		UserDto userDto = new UserDto(user.getEmail(),
							 user.getUsername(),
							 user.getPassword());
		
		userDto.setTodoDtos(user.getTodos().stream()
				.map(t -> todo_model_to_dto_converter.convert(t))
				.collect(Collectors.toList()));
		
		return userDto;
	}
	
	public UserDto convertWithId(User user) {
		UserDto userDto = new UserDto(user.getId(),
							 user.getEmail(),
							 user.getUsername(),
							 user.getPassword());
		
		userDto.setTodoDtos(user.getTodos().stream()
				.map(t -> todo_model_to_dto_converter.convert(t))
				.collect(Collectors.toList()));
		
		return userDto;
	}
	
	
	
}
