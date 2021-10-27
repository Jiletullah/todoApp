package com.ismaildogukancokluk_todo.dto;

import org.springframework.stereotype.Component;

import com.ismaildogukancokluk_todo.model.Priority;

@Component
public class TodoDto {
	
	private String id;
	private Priority priority;
	private String content;
	private Boolean done = false;

	
	//constructors
	public TodoDto() {}

	public TodoDto(Priority priority, String content, Boolean done) {
		super();
		this.priority = priority;
		this.content = content;
		this.done = done;

	}
	
	
	public TodoDto(String id,Priority priority, String content, Boolean done) {
		super();
		this.id = id;
		this.priority = priority;
		this.content = content;
		this.done = done;

	}

	
	//getters & setter
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	
	//HASH & EQUALS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((done == null) ? 0 : done.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
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
		TodoDto other = (TodoDto) obj;
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
		return true;
	}

	
	
	
}
