package com.ismaildogukancokluk_todo.model;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Todo implements Comparable<Todo>{

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name ="uuid", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	@Enumerated(EnumType.STRING)
	private Priority priority;
	
	private String content;
	private Boolean done = false;
	
	@JsonBackReference
	@ManyToOne //no cascade here, we don't want to delete the user when todo is deleted
	@JoinColumn(name = "user_id",nullable = false)
	private User user;
	
	
	
	//constructors
	public Todo() {} //empty constructor needed for hibernate
	
	public Todo(Priority priority,String content,User user) {
		this.content = content;
		this.priority = priority;
		this.user = user;
	}
	
	public Todo(Priority priority,String content,Boolean done, User user) {
		this.content = content;
		this.priority = priority;
		this.done = done;
		this.user = user;
	}
	
	public Todo(String id,Priority priority,String content,Boolean done, User user) {
		this.id = id;
		this.content = content;
		this.priority = priority;
		this.done = done;
		this.user = user;
	}
	
	//functions
	@Override
	public int compareTo(Todo o) {
		
		if(!(o instanceof Todo)) {
			throw new IllegalArgumentException();
		}
		
		return	this.priority.compareTo(o.priority);
			
	}

	
	
	//getters & setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Boolean getDone() {
		return done;
	}
	public void setDone(Boolean done) {
		this.done = done;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	

	// HASH & EQUALS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((done == null) ? 0 : done.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (done == null) {
			if (other.done != null)
				return false;
		} else if (!done.equals(other.done))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (priority != other.priority)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	
	
	
	
}








