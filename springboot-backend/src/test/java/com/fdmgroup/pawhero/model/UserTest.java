package com.fdmgroup.pawhero.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserTest {

	User actualUser;
	
	@Mock
	Role mockRole;
	
	@Test
	void testUser_DefaultConstructor() {
		actualUser = new User();
		actualUser.setEmailAddress("42 Main St");
        actualUser.setFirstName("Jane");
        actualUser.setLastName("Doe");
        actualUser.setPassword("iloveyou");
        actualUser.setPhone("4105551212");
        actualUser.setRole(mockRole);
        actualUser.setUserId(123);
        assertEquals("42 Main St", actualUser.getEmailAddress());
        assertEquals("Jane", actualUser.getFirstName());
        assertEquals("Doe", actualUser.getLastName());
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals("4105551212", actualUser.getPhone());
        assertSame(mockRole, actualUser.getRole());
        assertEquals(123, actualUser.getUserId());
	}
	
	@Test
    public void testUser_ParameterizedConstructor() {
        User actualUser = new User(123, new Role(123, "Name"), "Jane", "Doe", "4105551212", "42 Main St", "iloveyou");
        actualUser.setEmailAddress("42 Main St");
        actualUser.setFirstName("Jane");
        actualUser.setLastName("Doe");
        actualUser.setPassword("iloveyou");
        actualUser.setPhone("4105551212");
        actualUser.setRole(mockRole);
        actualUser.setUserId(123);
        assertEquals("42 Main St", actualUser.getEmailAddress());
        assertEquals("Jane", actualUser.getFirstName());
        assertEquals("Doe", actualUser.getLastName());
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals("4105551212", actualUser.getPhone());
        assertSame(mockRole, actualUser.getRole());
        assertEquals(123, actualUser.getUserId());
    }
}
