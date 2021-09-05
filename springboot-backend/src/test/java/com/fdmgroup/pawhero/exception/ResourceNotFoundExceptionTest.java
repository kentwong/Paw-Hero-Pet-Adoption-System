package com.fdmgroup.pawhero.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResourceNotFoundExceptionTest {

	ResourceNotFoundException actualResourceNotFoundException;
	
	@Test
	void testResourceNotFoundException() {
		actualResourceNotFoundException = new ResourceNotFoundException("An error occurred");
        assertNull(actualResourceNotFoundException.getCause());
        assertEquals("com.fdmgroup.pawhero.exception.ResourceNotFoundException: An error occurred", actualResourceNotFoundException.toString());
        assertEquals(0, actualResourceNotFoundException.getSuppressed().length);
        assertEquals("An error occurred", actualResourceNotFoundException.getMessage());
        assertEquals("An error occurred", actualResourceNotFoundException.getLocalizedMessage());
	}
}
