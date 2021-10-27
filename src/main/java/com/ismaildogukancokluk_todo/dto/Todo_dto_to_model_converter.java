package com.ismaildogukancokluk_todo.dto;

import org.springframework.stereotype.Component;

import com.ismaildogukancokluk_todo.model.Todo;
import com.ismaildogukancokluk_todo.model.User;

@Component
public class Todo_dto_to_model_converter {
	
	//constructor
	public Todo_dto_to_model_converter() {}
	
	//function
	public Todo convert(TodoDto todoDto, User user) {
		Todo todo = new Todo(todoDto.getPriority(),
									   todoDto.getContent(),
									   todoDto.getDone(),
									   user);
		return todo;
	}
	
}
	