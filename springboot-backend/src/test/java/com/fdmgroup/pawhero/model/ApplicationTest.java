package com.fdmgroup.pawhero.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ApplicationTest {

	Application actualApplication;
	
	@Mock
	Pet mockPet;
	
	@Mock
	Role mockRole;
	
	@Mock
	User mockUser;
	
	@Test
	void testApplication_DefaultConstructor() {
		actualApplication = new Application();
        actualApplication.setApplicationId(123);
        actualApplication.setDate("2020-03-01");
        actualApplication.setMessage("Not all who wander are lost");
        actualApplication.setPet(mockPet);
        actualApplication.setStatus("Status");
        actualApplication.setUser(mockUser);
        assertEquals(123, actualApplication.getApplicationId());
        assertEquals("2020-03-01", actualApplication.getDate());
        assertEquals("Not all who wander are lost", actualApplication.getMessage());
        assertSame(mockPet, actualApplication.getPet());
        assertEquals("Status", actualApplication.getStatus());
        assertSame(mockUser, actualApplication.getUser());
	}
	
	@Test
    public void testApplication_ParameterizedConstructor() {
        actualApplication = new Application(mockUser, "Not all who wander are lost", "Status", "2020-03-01", new Pet("Type", "Bella", "Breed", "Age", "Sex", "Location", "Adoption Fee", "The characteristics of someone or something", "https://example.org/example"));
        actualApplication.setApplicationId(123);
        actualApplication.setDate("2020-03-01");
        actualApplication.setMessage("Not all who wander are lost");
        actualApplication.setPet(mockPet);
        actualApplication.setStatus("Status");
        actualApplication.setUser(mockUser);
        assertEquals(123, actualApplication.getApplicationId());
        assertEquals("2020-03-01", actualApplication.getDate());
        assertEquals("Not all who wander are lost", actualApplication.getMessage());
        assertSame(mockPet, actualApplication.getPet());
        assertEquals("Status", actualApplication.getStatus());
        assertSame(mockUser, actualApplication.getUser());
	}
}
