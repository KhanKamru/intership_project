package com.project.Exception;

public class ResourceNotFoundException extends RuntimeException {
	private String resourceName;
	private long id;
	public ResourceNotFoundException(String resourceName, long id) {
		super(String.format("%s is not found with id :%d",resourceName,id));
		this.resourceName = resourceName;
		this.id = id;
	}
	

}
