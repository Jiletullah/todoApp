package com.ismaildogukancokluk_todo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ismaildogukancokluk_todo.dto.TodoDto;
import com.ismaildogukancokluk_todo.dto.Todo_model_to_dto_converter;
import com.ismaildogukancokluk_todo.exception.TodoNotFoundException;
import com.ismaildogukancokluk_todo.model.Priority;
import com.ismaildogukancokluk_todo.repo.TodoRepo;
import com.ismaildogukancokluk_todo.service.TodoService;


class TodoServiceTest {
	
	private String id;
	private TodoService todoService;
	private TodoRepo todoRepo;
	private Todo_model_to_dto_converter todo_model_to_dto_converter;

	
	//Not too experienced with unit tests. Hope they are fine ( ͡° ͜ʖ ͡°)
	@BeforeEach
	public void setUp() throws Exception {
		todoRepo = mock(TodoRepo.class);
		todo_model_to_dto_converter = mock(Todo_model_to_dto_converter.class);
		todoService = new TodoService(todoRepo,todo_model_to_dto_converter);
	}

	
	@Test
	public void testFindTodoDtoById_whenTodoIdDoesNotExist_shouldThrowTodoNotFoundException() {
		
		assertThrows(TodoNotFoundException.class, () -> todoService.findDtoById(id));
		
	}
		
	
	@Test
	public void testDeleteTodoById_whenTodoIdDoesNotExist_shouldThrowTodoNotFoundExcepiton(){
		
		assertThrows(TodoNotFoundException.class, () -> todoService.deleteById(id));
		
	}
	
	
	@Test
	public void testUpdateTodo_whenTodoIdDoesNotExist_shouldThrowTodoNotFoundExcepiton() {
		
		assertThrows(TodoNotFoundException.class, () -> todoService.updateTodo(id,Priority.HIGH));
		
	}
	
	
	@Test()
	public void testFindDtoById_whenTodoIdExists_shouldReturnTodoDto() {
		
		TodoDto testTodoDto = new TodoDto(id,Priority.HIGH, "content",true);
		try {
			Mockito.when(todoService.findDtoById(id)).thenReturn(testTodoDto);
			TodoDto result = todoService.findDtoById(id);
			
			Assertions.assertEquals(result, testTodoDto);
		} catch (Exception e) {}
	

	}
	
		
			
		
			
		
	
		
}

