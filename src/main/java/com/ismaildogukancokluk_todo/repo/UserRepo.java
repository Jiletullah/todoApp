package com.ismaildogukancokluk_todo.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ismaildogukancokluk_todo.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{

	
	//THIS IS A JPA-SQL QUERY - FUNCTION HANDLE DEFINES THE QUERY : SELECT EMAIL FROM USER
	List<User> findByEmail(String email);
	
	//THIS IS A JPA-SQL QUERY - FUNCTION HANDLE DEFINES THE QUERY : SELECT USERNAME FROM USER
	List<User> findByUsername(String username);
}
