package com.ismaildogukancokluk_todo.service;

import org.springframework.stereotype.Service;

import com.ismaildogukancokluk_todo.dto.TodoDto;
import com.ismaildogukancokluk_todo.dto.Todo_model_to_dto_converter;
import com.ismaildogukancokluk_todo.exception.TodoNotFoundException;
import com.ismaildogukancokluk_todo.model.Priority;
import com.ismaildogukancokluk_todo.model.Todo;
import com.ismaildogukancokluk_todo.repo.TodoRepo;


@Service
public class TodoService {
	
	private final TodoRepo todoRepo;
	private final Todo_model_to_dto_converter todo_model_to_dto_converter;
	
	
	public TodoService(TodoRepo todoRepo,
					   Todo_model_to_dto_converter todo_model_to_dto_converter) {
		
		this.todoRepo = todoRepo;
		this.todo_model_to_dto_converter = todo_model_to_dto_converter;
		
	}
	
	
	
	protected Todo findById(String todo_id) throws Exception{
		Todo todo = todoRepo.findById(todo_id).orElseThrow(
				() -> new TodoNotFoundException("id"));
		
		return todo;
	}
	
	
	
	
	public TodoDto findDtoById(String todo_id) throws Exception {
		
		Todo todo = findById(todo_id);
		return todo_model_to_dto_converter.convert(todo);
		
	}

	
	
	
	public void deleteById(String todo_id) throws Exception {
		
		Todo todo = findById(todo_id);
		todo.getUser().getTodos().remove(todo);
		todoRepo.delete(todo);
		
	}

	
	
	public TodoDto updateTodo(String todo_id, Priority priority) throws Exception {
		
		Todo todo = findById(todo_id);
		todo.setPriority(priority);
		todoRepo.save(todo);
		return todo_model_to_dto_converter.convert(todo);
		
	}
	
	
	
	
	public TodoDto updateTodo(String todo_id, Boolean done) throws Exception {
		
		Todo todo = findById(todo_id);
		todo.setDone(done);
		todoRepo.save(todo);
		return todo_model_to_dto_converter.convert(todo);
		
	}
	
	
	
	
	public TodoDto updateTodo(String todo_id, String content) throws Exception {
		
		Todo todo = findById(todo_id);
		todo.setContent(content);
		todoRepo.save(todo);
		return todo_model_to_dto_converter.convert(todo);
		
	}
	

}



















