package com.ismaildogukancokluk_todo.dto;

import org.springframework.stereotype.Component;

import com.ismaildogukancokluk_todo.model.Todo;


@Component
public class Todo_model_to_dto_converter {
	
	//constructor
	public Todo_model_to_dto_converter() {}
	
	//function
	public TodoDto convert(Todo todo) {
		TodoDto todoDto = new TodoDto(todo.getId(),
									   todo.getPriority(),
									   todo.getContent(),
									   todo.getDone());
		return todoDto;
	}
	

}
