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


import com.ismaildogukancokluk_todo.dto.UserDto;
import com.ismaildogukancokluk_todo.dto.UserUpdateRequest;
import com.ismaildogukancokluk_todo.exception.BadRequestTypeException;
import com.ismaildogukancokluk_todo.exception.EmailAlreadyInUseException;
import com.ismaildogukancokluk_todo.exception.UsernameAlreadyInUseException;
import com.ismaildogukancokluk_todo.service.UserService;




@RestController
@RequestMapping("/v1/user")
public class UserController {
	
	private final UserService userService;

	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	
	// REGISTER A NEW USER
	@PostMapping
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto) throws Exception {
		
		if(userService.checkEmailExists(userDto.getEmail())) {
			throw new EmailAlreadyInUseException(userDto.getEmail());
		}
		
		if(userService.checkUserNameExists(userDto.getUsername())) {
			throw new UsernameAlreadyInUseException(userDto.getUsername());
		}
		
		
		return ResponseEntity.ok(userService.saveUser(userDto));
	}
	
	
	
	// UPDATE USER FIELDS
	@PutMapping("/{user_id}")
	public ResponseEntity<UserDto> updateUser(
		   @RequestBody UserUpdateRequest updateRequest,
		   @PathVariable String user_id) throws Exception {
		
		
		switch (updateRequest.getRequestType()) {
		
		case 0: // UPDATE EMAIL
			return ResponseEntity.ok(userService.updateUserEmail(user_id, updateRequest.getRequestField()));	
		case 1: // UPDATE USERNAME
			return ResponseEntity.ok(userService.updateUserUsername(user_id, updateRequest.getRequestField()));
		case 2: // UPDATE PASSWORD
			return ResponseEntity.ok(userService.updateUserPassword(user_id, updateRequest.getRequestField()));
		default:
			throw new BadRequestTypeException(updateRequest.getRequestType().toString());
		}
		
			
	}
	


	//	GET A SINGLE USER - ADMINISTRATIVE
	@GetMapping("/{user_id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable String user_id) throws Exception {
		return ResponseEntity.ok(userService.findUserDtoById(user_id));
	}
	
	
	
	//	GET ALL USERS - ADMINISTRATIVE
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers() throws Exception{
		
		return ResponseEntity.ok(userService.getAllUsers());
		
	}
	
	
	
	// DELETE A USER - ADMINISTRATIVE
	// (user self delete can be implemented in a different time)
	@DeleteMapping("/{user_id}")
	public void deleteUserById(@PathVariable String user_id) throws Exception{
		
			userService.deleteUserById(user_id);
			
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
}
