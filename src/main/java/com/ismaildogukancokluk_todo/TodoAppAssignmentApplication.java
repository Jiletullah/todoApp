package com.ismaildogukancokluk_todo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ismaildogukancokluk_todo.model.Priority;
import com.ismaildogukancokluk_todo.model.User;
import com.ismaildogukancokluk_todo.repo.UserRepo;

@SpringBootApplication
public class TodoAppAssignmentApplication implements CommandLineRunner{
	
	// ¯\_(ツ)_/¯ ¯\_(ツ)_/¯ I KNOW THIS IS BAD PRACTICE ¯\_(ツ)_/¯ ¯\_(ツ)_/¯ 
	// BUT SINCE WE ARE USING H2 IN-MEMORY DATABASE THERE IS REALLY NO
	// OTHER FEASIBLE WAY TO ADD INITIAL ELEMENTS TO THE DATABASE

	private final UserRepo userRepo;
	
	public TodoAppAssignmentApplication(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	///////////////////////////////////////////////////////////////////////
	
	
	public static void main(String[] args) {
		SpringApplication.run(TodoAppAssignmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// ADDING INITIAL ELEMENTS TO USER DATABASE
		User user = new User("ismail.d.cokluk@gmail.com","jilet","jilet123");
		user.addTodo(Priority.HIGH, "finish the assignment", true);
		userRepo.save(user);
		
		System.out.println(user.getId());
		
	}
	


}
