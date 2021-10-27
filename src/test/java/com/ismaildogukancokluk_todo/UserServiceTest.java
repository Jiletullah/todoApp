package com.ismaildogukancokluk_todo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ismaildogukancokluk_todo.dto.User_dto_to_model_converter;
import com.ismaildogukancokluk_todo.dto.User_model_to_dto_converter;
import com.ismaildogukancokluk_todo.exception.EmailNotFoundException;
import com.ismaildogukancokluk_todo.exception.UserNotFoundException;
import com.ismaildogukancokluk_todo.exception.UsernameNotFoundException;
import com.ismaildogukancokluk_todo.repo.UserRepo;
import com.ismaildogukancokluk_todo.service.UserService;

class UserServiceTest {

	private String id;
	private UserService userService;
	private User_model_to_dto_converter user_model_to_dto_converter;
	private User_dto_to_model_converter user_dto_to_model_converter;
	private UserRepo userRepo;
	
	
	//Not too experienced with unit tests. Hope they are fine ( ͡° ͜ʖ ͡°)
	
	@BeforeEach
	void setUp() throws Exception {
		id = "test";
		user_dto_to_model_converter = mock(User_dto_to_model_converter.class);
		user_model_to_dto_converter = mock(User_model_to_dto_converter.class);
		userRepo = mock(UserRepo.class);
		
		userService = new UserService(userRepo, user_model_to_dto_converter, user_dto_to_model_converter);
		
	}
	
	
	
	@Test
	public void testFindUserByEmail_whenEmailDoesNotExist_shouldThrowIndexOutBoundsException() {
		
		assertThrows(IndexOutOfBoundsException.class, () -> userService.findUserByEmail(id));
		
	}
	
	@Test
	public void testFindUserDtoById_whenUserDtoDoesNotExist_shouldThrowUserNotFoundException() {
		
		assertThrows(UserNotFoundException.class, () -> userService.findUserDtoById(id));
		
	}
	
	@Test
	public void testFindUserDtoByUsername_whenUsernameDoesNotExist_shouldThrowUserNotFoundException() {
		
		assertThrows(UserNotFoundException.class, () -> userService.findUserDtoByUserName(id));
		
	}
	

	
	
	
	

}




















