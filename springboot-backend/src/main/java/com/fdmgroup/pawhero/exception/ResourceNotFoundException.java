package com.fdmgroup.pawhero.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The ResourceNotFoundException will be thrown whenever the resource does not exist
 * in the database. It extends RuntimeException that implemented serialiser interface.
 * 
 * The API will return a Not Found status to the client. 
 * 
 * @author kentwong
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
