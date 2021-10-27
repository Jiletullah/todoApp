package com.ismaildogukancokluk_todo.dto;

import org.springframework.stereotype.Component;

@Component
public class TodoUpdateRequest {
	
	private String requestField;
	private Byte requestType;
	
	
	// CONSTRUCTORS
	public TodoUpdateRequest() {};
	
	public TodoUpdateRequest(String requestField, Byte requestType) {
		this.requestField = requestField;
		this.requestType = requestType;
	}
	
	
	// GETTERS & SETTERS
	public String getRequestField() {
		return requestField;
	}
	public void setRequestField(String request) {
		this.requestField = request;
	}
	public Byte getRequestType() {
		return requestType;
	}
	public void setRequestType(Byte requestType) {
		this.requestType = requestType;
	}



	// HASH & EQUALS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((requestField == null) ? 0 : requestField.hashCode());
		result = prime * result + ((requestType == null) ? 0 : requestType.hashCode());
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
		TodoUpdateRequest other = (TodoUpdateRequest) obj;
		if (requestField == null) {
			if (other.requestField != null)
				return false;
		} else if (!requestField.equals(other.requestField))
			return false;
		if (requestType == null) {
			if (other.requestType != null)
				return false;
		} else if (!requestType.equals(other.requestType))
			return false;
		return true;
	}
	
	
}
