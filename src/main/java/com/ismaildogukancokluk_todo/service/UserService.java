package com.ismaildogukancokluk_todo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ismaildogukancokluk_todo.dto.TodoDto;
import com.ismaildogukancokluk_todo.dto.UserDto;
import com.ismaildogukancokluk_todo.dto.User_dto_to_model_converter;
import com.ismaildogukancokluk_todo.dto.User_model_to_dto_converter;
import com.ismaildogukancokluk_todo.exception.EmailAlreadyInUseException;
import com.ismaildogukancokluk_todo.exception.UserNotFoundException;
import com.ismaildogukancokluk_todo.exception.UsernameAlreadyInUseException;
import com.ismaildogukancokluk_todo.model.User;
import com.ismaildogukancokluk_todo.repo.UserRepo;



@Service
public class UserService {
	
	private final User_model_to_dto_converter user_model_to_dto_converter;
	private final User_dto_to_model_converter user_dto_to_model_converter;
	private final UserRepo userRepo;

	
	
	public UserService(UserRepo userRepo,
			User_model_to_dto_converter User_model_to_dto_converter,
			User_dto_to_model_converter user_dto_to_model_converter) {
		
		this.userRepo = userRepo;
		this.user_model_to_dto_converter = User_model_to_dto_converter;
		this.user_dto_to_model_converter = user_dto_to_model_converter;
	}
	
	
	
	protected User findUserByUserName(String username) throws Exception {
		
		if(!checkUserNameExists(username)) {
			throw new UserNotFoundException(username);
		}
		
		return userRepo.findByUsername("username").get(0);
	}

	
	
	protected User findUserById(String id) throws Exception{
		
		return userRepo.findById(id).orElseThrow(
		() -> new UserNotFoundException("id"));
		
	}
	
	
	
	public Boolean checkEmailExists(String email){
		try {
			
			if(userRepo.findByEmail(email).size() == 0) {
				return false;
			}
			
		} catch (Exception e) {
			return true;
		}
		
		return true;
	}
	
	
	
	public Boolean checkUserNameExists(String username){
		try {
			
			if(userRepo.findByUsername(username).size() == 0) {
				return false;
			}
			
		} catch (Exception e) {
			return true;
		}
		
		return true;
	}

	
	
	public UserDto findUserDtoByUserName(String username) throws Exception {
		
		return user_model_to_dto_converter.convertWithId(
				findUserByUserName(username));
		
	}
	
	
	
	public UserDto findUserDtoById(String id) throws Exception{
		return user_model_to_dto_converter.convertWithId(findUserById(id));

	}
	
	
	
	
	public UserDto saveUser(UserDto userDto) {
		
		User user = user_dto_to_model_converter.convert(userDto);
		return user_model_to_dto_converter.convertWithId(userRepo.save(user));
		
	}
	
	

	public UserDto findUserByEmail(String email) throws Exception {
		
		if(checkEmailExists(email)) {
			throw new EmailAlreadyInUseException(email);
		}
		
		return user_model_to_dto_converter.convert(
				userRepo.findByEmail(email).get(0));
	}
	
	
	
	// DELETE - THIS ONE DOESN'T USE DTOS SINCE IT DOESN'T RETURN ANYTHING
	public void deleteUser(User user){
		userRepo.delete(user);
	}
	
	
	
	public void deleteUserById(String id) throws Exception{
		User user = findUserById(id);
		userRepo.delete(user);
	}
	
	

	public UserDto updateUserEmail(String id,String email) throws Exception {
		
		if(checkEmailExists(email)) {
			throw new EmailAlreadyInUseException(email);
		}
		
		User user = findUserById(id);
		user.setEmail(email);
		return user_model_to_dto_converter.convertWithId(userRepo.save(user));
		
	}
	
	
	
	public UserDto updateUserUsername(String id,String username) throws Exception {
		
		if(checkUserNameExists(username)) {
			throw new UsernameAlreadyInUseException(username);
		}
		
		User user = findUserById(id);
		user.setUsername(username);
		
	
		return user_model_to_dto_converter.convertWithId(userRepo.save(user));
	}
	
	
	
	public UserDto updateUserPassword(String id,String password) throws Exception {
		
		User user = findUserById(id);
		user.setPassword(password);
		
		return user_model_to_dto_converter.convertWithId(userRepo.save(user));
	}
	
	
	
	public UserDto addTodoToUser(String id,TodoDto todoDto) throws Exception {
		User user = findUserById(id);
		
		user.addTodo(todoDto.getPriority(), todoDto.getContent(), todoDto.getDone());
		user.sortTodos();
		
		return user_model_to_dto_converter.convertWithId(userRepo.save(user));
	}
	
	
	
	// GET - ADMINISTRATIVE COMMAND
	public List<UserDto> getAllUsers(){
		
		List<User> users = userRepo.findAll();
		
	    List<UserDto> usersDto = users.stream().map(
				t -> user_model_to_dto_converter.convertWithId(t)).collect(Collectors.toList());
		
		return usersDto;
	}
	
	
	
	

}
















