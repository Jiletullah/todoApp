package com.ismaildogukancokluk_todo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ismaildogukancokluk_todo.model.Todo;

@Repository
public interface TodoRepo extends JpaRepository<Todo, String> {
	
	

}
