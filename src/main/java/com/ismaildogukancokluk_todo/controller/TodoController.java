package com.ismaildogukancokluk_todo.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ismaildogukancokluk_todo.dto.TodoDto;
import com.ismaildogukancokluk_todo.dto.TodoUpdateRequest;
import com.ismaildogukancokluk_todo.exception.BadRequestTypeException;
import com.ismaildogukancokluk_todo.model.Priority;
import com.ismaildogukancokluk_todo.service.TodoService;
import com.ismaildogukancokluk_todo.service.UserService;



@RestController
@RequestMapping("/v1/user/{user_id}/todo")
public class TodoController {

	private final UserService userService;
	private final TodoService todoService;

	
	public TodoController(UserService userService, TodoService todoService) {
		
		this.userService = userService;
		this.todoService = todoService;

		
	}
	
	
	
	// ADD NEW TODO TO A USER
	@PostMapping
	public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto,
						@PathVariable String user_id) throws Exception{
		
		userService.addTodoToUser(user_id, todoDto);
		return ResponseEntity.ok(todoDto);
		
	}
	
	
	
	// ALTER EXISTING TODO
	@PutMapping("/{todo_id}") 
	public ResponseEntity<TodoDto> updateTodoContent(@PathVariable String todo_id,
		   @RequestBody TodoUpdateRequest updateRequest) throws Exception{
		
		
		switch (updateRequest.getRequestType()) {
		
		case 0: // UPDATE PRIORITY
			return ResponseEntity.ok(todoService.updateTodo
					(todo_id, Priority.valueOf(updateRequest.getRequestField())));	
		case 1: // UPDATE CONTENT
			return ResponseEntity.ok(todoService.updateTodo
					(todo_id, updateRequest.getRequestField()));
		case 2: // UPDATE DONE
			return ResponseEntity.ok(todoService.updateTodo
					(todo_id, Boolean.parseBoolean(updateRequest.getRequestField())));
		default:
			throw new BadRequestTypeException(updateRequest.getRequestType().toString());
		}
		
		
	}

	
	
	
	// GET A SINGLE TODO
	@GetMapping("/{todo_id}")
	public ResponseEntity<TodoDto> getTodo(@PathVariable String todo_id) throws Exception{
		
		return ResponseEntity.ok(todoService.findDtoById(todo_id));
		
	}
	
	
	
	// GET ALL TODOS OF A USER
	@GetMapping
	public ResponseEntity<List<TodoDto>> getAllTodos(@PathVariable String user_id) throws Exception{
		
		List<TodoDto> todoDtos = userService.findUserDtoById(user_id).getTodoDtos();
		return ResponseEntity.ok(todoDtos);
		
	}
	
	
	
	// DELETE A TODO
	@DeleteMapping("/{todo_id}")
	public void deleteTodo(@PathVariable String todo_id) throws Exception {
		
		todoService.deleteById(todo_id);
		
	}
	
	
}

















